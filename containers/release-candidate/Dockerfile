#!/bin/bash
#
# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

FROM registry.fedoraproject.org/fedora:41

WORKDIR /root

# Delete cruft fedora leaves in the homedir
RUN rm -rf /root/*

# Install dependencies, explicitly not enabling the updates repo so we are
# pinned at a particular fedora release.
RUN \
  dnf -y --quiet --repo=fedora install \
    clang \
    git \
    java-1.8.0-devel \
    llvm \
    mxml-devel \
    npm \
    pandoc \
    pinentry \
    rpm-build \
    rpm-sign \
    subversion \
    unzip \
    vim-minimal \
    wine \
    winetricks && \
  dnf clean all

# Enable sbt-pgp plugin
COPY src/plugins.sbt /root/.sbt/1.0/plugins/

# WIX is a Microsoft Windows Installer creation tool kit.
#
# Install wix, including changes to allow WiX to run in wine on Linux. See
# src/wix_wine.sh for more details on why we need to do this and how it works
#
# Updating WIX should be done only if there is a specific need (for security, or other compelling reason)
# because it is likely things will break and the release scripts/process will have to adapt.
# The WIX version 3.11.2 is hard coded into these script lines as tokens wix3112rtm and wix311.
#
# In order to ensure we are downloading and using the exact WIX binary we have tested and trust
# we verify the sha512 is the same as the one expected. This protects us from if someone
# was to get github credentials allowing them to change the wix binaries on github.
# If WIX is updated to a newer version, this sha512 will need to be recomputed.
ARG WIXSHA=6fd961c85e1e6adafb99ef50c9659e3eb83c84ecaf49f523e556788845b206e1857aba2c39409405d4cda1df9b30a552ce5aab808be5f8368a37a447d78d1a05
#
RUN \
  curl -sS -L https://github.com/wixtoolset/wix3/releases/download/wix3112rtm/wix311-binaries.zip -o wix311-binaries.zip && \
  echo "$WIXSHA wix311-binaries.zip" | sha512sum --quiet -c - && \
  mkdir /opt/wix311 && \
  unzip -q wix311-binaries.zip -d /opt/wix311/ && \
  rm wix311-binaries.zip
RUN mv /opt/wix311/{candle.exe,real-candle.exe}
RUN mv /opt/wix311/{light.exe,real-light.exe}
COPY src/wix_wine.sh /opt/wix311/candle.exe
COPY src/wix_wine.sh /opt/wix311/light.exe

# Install a pinned version of sbt. This is used only as a bootstrap so does not need to be updated.
# This version of sbt is not used to build any Daffodil project parts, as they specify their own sbt versions.
RUN \
  dnf -y --quiet --repofrompath=sbt-rpm,https://repo.scala-sbt.org/scalasbt/rpm --repo=sbt-rpm --nogpgcheck install \
    sbt-1.7.1 && \
  dnf clean all

# Install a pinned version of yarn. This is used only as a bootstrap so does not need to be updated.
# This version of yarn is not used to build any Daffodil project parts, as they specify their own yarn versions.
RUN \
  npm --no-update-notifier install --global yarn@1.22.19

# Install and set the entrypoint
COPY src/daffodil-release-candidate /usr/bin/
ENTRYPOINT ["/usr/bin/daffodil-release-candidate"]
