/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.daffodil.sapi.io

import java.io.InputStream
import java.nio.ByteBuffer

import org.apache.daffodil.io.{ InputSourceDataInputStream => SInputSourceDataInputStream }

/**
 * Provides Daffodil with byte data from an InputStream, ByteBuffer, or byte
 * Array.
 *
 * Note that the InputStream variant has potential overhead due to streaming capabilities and
 * support for files greater than 2GB. In some cases, better performance might come from using
 * the byte array or ByteBuffer variants instead. For example, if your data is already in a byte
 * array, one should use the Array[Byte] or ByteBuffer variants instead of wrapping it in a
 * ByteArrayInputStream. As another example, instead of using a FileInputStream like this:
 *
 * {{{
 * val path = Paths.get(file)
 * val fis = Files.newInputStream(path)
 * val input = InputSourceDataInputStream(fis)
 * }}}
 *
 * You might consider mapping the file to a MappedByteBuffer like below, keeping in mind that
 * MappedByteBuffers have size limitations and potentially different performance characteristics
 * depending on the file size and system--it maybe not always be faster than above.
 *
 * {{{
 * val path = Paths.get(file)
 * val size = Files.size(path)
 * val fc = FileChannel.open(path, StandardOpenOption.READ)
 * val bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, size)
 * fc.close()
 * val input = InputSourceDataInputStream(bb)
 * }}}
 *
 * @param dis the underlying Scala InputSourceDataInputStream
 */
class InputSourceDataInputStream private[sapi] (
  private[sapi] val dis: SInputSourceDataInputStream
) extends java.io.Closeable {

  /**
   * Create an InputSourceDataInputStream from a java.io.InputStream
   */
  def this(is: InputStream) = this(SInputSourceDataInputStream(is))

  /**
   * Create an InputSourceDataInputStream from a java.nio.ByteBuffer
   */
  def this(bb: ByteBuffer) = this(SInputSourceDataInputStream(bb))

  /**
   * Create an InputSourceDataInputStream from a byte array
   */
  def this(arr: Array[Byte]) = this(SInputSourceDataInputStream(arr))

  /**
   * Returns true if the input stream has at least 1 bit of data.
   *
   * Does not advance the position.
   *
   * Returns true immediately if the input stream has available data that
   * has not yet been consumed.
   *
   * On a network input stream, this may block to determine if the stream
   * contains data or is at end-of-data.
   *
   * This is used when parsing multiple elements from a stream to see if there
   * is data or not before calling parse().
   *
   * It may also be used after a parse() operation that is intended to consume
   * the entire data stream (such as for a file) to determine if all data has
   * been consumed or some data is left-over.
   */
  def hasData(): Boolean = dis.isDefinedForLength(1)

  /**
   * Closes the underlying resource associated with this object.
   *
   * Once the resource is closed, any subsequent operations on the
   * resource may throw an `IOException`.
   */
  def close(): Unit = dis.close()
}
