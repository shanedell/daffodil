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

package org.apache.daffodil.codegen.c.generators

import org.apache.daffodil.core.grammar.primitives.AlignmentFill

trait AlignmentFillCodeGenerator {

  // Generate C code to parse/unparse alignment fill bytes until an
  // alignment boundary is reached
  def alignmentFillGenerateCode(g: AlignmentFill, cgState: CodeGeneratorState): Unit = {
    val indent1 = if (cgState.hasChoice) INDENT else NO_INDENT
    val indent2 = if (cgState.hasArray) INDENT else NO_INDENT
    val alignmentInBits = g.alignment
    val octalFillByte = g.e.fillByteEv.constValue.toByte.toInt.toOctalString
    val initERDStatement = ""
    val parseStatement =
      s"""$indent1$indent2    // Align to closest alignment
         |$indent1$indent2    parse_align_to($alignmentInBits, pstate);
         |$indent1$indent2    if (pstate->pu.error) return;""".stripMargin
    val unparseStatement =
      s"""$indent1$indent2    // Align to closest alignment
         |$indent1$indent2    unparse_align_to($alignmentInBits, '\\$octalFillByte', ustate);
         |$indent1$indent2    if (ustate->pu.error) return;""".stripMargin
    cgState.addSimpleTypeStatements(initERDStatement, parseStatement, unparseStatement)
  }
}
