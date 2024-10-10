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

package org.apache.daffodil.section12.lengthKind

import org.apache.daffodil.tdml.Runner

import org.junit.AfterClass
import org.junit.Test

object TestLengthKindExplicit {
  val testDir = "/org/apache/daffodil/section12/lengthKind/"
  val runner = Runner(testDir, "ExplicitTests.tdml")

  @AfterClass def shutDown(): Unit = {
    runner.reset
  }

}

class TestLengthKindExplicit {

  import TestLengthKindExplicit._

  @Test def test_Lesson1_lengthKind_explicit(): Unit = {
    runner.runOneTest("Lesson1_lengthKind_explicit")
  }
  @Test def test_ExplicitLengthBytesNotFixed() = {
    runner.runOneTest("test_ExplicitLengthBytesNotFixed")
  }
  @Test def test_ExplicitLengthBitsFixed() = { runner.runOneTest("ExplicitLengthBitsFixed") }
  @Test def test_ExplicitLengthBytesFixed() = {
    runner.runOneTest("test_ExplicitLengthBytesFixed")
  }
  @Test def test_ExplicitLengthBitsNotFixed() = {
    runner.runOneTest("ExplicitLengthBitsNotFixed")
  }
  @Test def test_ExplicitLengthCharsNotFixed() = {
    runner.runOneTest("ExplicitLengthCharsNotFixed")
  }
  @Test def test_ExplicitLengthCharsFixed() = { runner.runOneTest("ExplicitLengthCharsFixed") }
  @Test def test_ExplicitLengthBytesFixed50() = {
    runner.runOneTest("ExplicitLengthBytesFixed50")
  }

  @Test def test_lengthRuntimeIntNaN_PE() = { runner.runOneTest("test_lengthRuntimeIntNaN_PE") }
  @Test def test_lengthRuntimeDoubleNaN_PE() = {
    runner.runOneTest("test_lengthRuntimeDoubleNaN_PE")
  }
  @Test def test_lengthRuntimeIntNegative_SDE() = {
    runner.runOneTest("test_lengthRuntimeIntNegative_SDE")
  }
  @Test def test_lengthRuntimeDoubleNegative_SDE() = {
    runner.runOneTest("test_lengthRuntimeDoubleNegative_SDE")
  }

  @Test def test_ExplicitLengthBytesBroken() = {
    runner.runOneTest("test_ExplicitLengthBytesBroken")
  }

  @Test def test_ExplicitLengthBytesNotGiven() = {
    runner.runOneTest("test_ExplicitLengthBytesNotGiven")
  }

  @Test def test_ExplicitLengthBytesChoiceRef() = {
    runner.runOneTest("test_ExplicitLengthBytesChoiceRef")
  }
  @Test def test_ExplicitLengthChildLengthLessParent_Chars() = {
    runner.runOneTest("test_ExplicitLengthChildLengthLessParent_Chars")
  }
  @Test def test_ExplicitLengthChildLengthLessParent_Bytes() = {
    runner.runOneTest("test_ExplicitLengthChildLengthLessParent_Bytes")
  }
  @Test def test_ExplicitLengthChildLengthMoreParent_Chars() = {
    runner.runOneTest("test_ExplicitLengthChildLengthMoreParent_Chars")
  }

  @Test def test_explicitBytes_string_01() = { runner.runOneTest("explicitBytes_string_01") }
  @Test def test_explicitBytes_int_01() = { runner.runOneTest("explicitBytes_int_01") }
  @Test def test_explicitBytes_int_02() = { runner.runOneTest("explicitBytes_int_02") }

  // Added for issue related to DFDL-1674
  @Test def test_denseBit_lengthKind_explicit(): Unit = {
    runner.runOneTest("denseBit_lengthKind_explicit")
  }

  // DFDL-2931
  @Test def test_lengthUnitsBitsForInteger_explicit(): Unit = {
    runner.runOneTest("lengthUnitsBitsForInteger_explicit")
  }
  @Test def test_lengthUnitsBitsForInteger_explicit2(): Unit = {
    runner.runOneTest("lengthUnitsBitsForInteger_explicit2")
  }
  @Test def test_lengthUnitsBitsForDecimal_explicit(): Unit = {
    runner.runOneTest("lengthUnitsBitsForDecimal_explicit")
  }
  @Test def test_lengthUnitsBitsForFloat_explicit1(): Unit = {
    runner.runOneTest("lengthUnitsBitsForFloat_explicit1")
  }
  @Test def test_lengthUnitsBitsForFloat_explicit2(): Unit = {
    runner.runOneTest("lengthUnitsBitsForFloat_explicit2")
  }
  @Test def test_lengthUnitsBitsForFloat_explicit3(): Unit = {
    runner.runOneTest("lengthUnitsBitsForFloat_explicit3")
  }
  @Test def test_lengthUnitsBitsForDouble_explicit1(): Unit = {
    runner.runOneTest("lengthUnitsBitsForDouble_explicit1")
  }
  @Test def test_lengthUnitsBitsForDouble_explicit2(): Unit = {
    runner.runOneTest("lengthUnitsBitsForDouble_explicit2")
  }
  @Test def test_lengthUnitsBitsForDouble_explicit3(): Unit = {
    runner.runOneTest("lengthUnitsBitsForDouble_explicit3")
  }

  @Test def test_invalidUnsignedLongBitLength(): Unit = {
    runner.runOneTest("invalidUnsignedLongBitLength")
  }

  @Test def test_invalidUnsignedLongByteLength(): Unit = {
    runner.runOneTest("invalidUnsignedLongByteLength")
  }
  @Test def test_invalidUnsignedIntBitLength(): Unit = {
    runner.runOneTest("invalidUnsignedIntBitLength")
  }
  @Test def test_invalidUnsignedShortBitLength(): Unit = {
    runner.runOneTest("invalidUnsignedShortBitLength")
  }
  @Test def test_invalidUnsignedByteBitLength(): Unit = {
    runner.runOneTest("invalidUnsignedByteBitLength")
  }

  @Test def test_invalidLongBitLength(): Unit = {
    runner.runOneTest("invalidLongBitLength")
  }
  @Test def test_invalidIntBitLength(): Unit = {
    runner.runOneTest("invalidIntBitLength")
  }
  @Test def test_invalidShortBitLength(): Unit = {
    runner.runOneTest("invalidShortBitLength")
  }
  @Test def test_invalidByteBitLength(): Unit = {
    runner.runOneTest("invalidByteBitLength")
  }

  @Test def test_invalidLongBitLengthExpr(): Unit = {
    runner.runOneTest("invalidLongBitLengthExpr")
  }

  @Test def test_invalidIntBitLengthExpr(): Unit = {
    runner.runOneTest("invalidIntBitLengthExpr")
  }
  @Test def test_unparseInvalidIntBitLengthExpr(): Unit = {
    runner.runOneTest("unparseInvalidIntBitLengthExpr")
  }

  @Test def test_invalidShortBitLengthExpr(): Unit = {
    runner.runOneTest("invalidShortBitLengthExpr")
  }

  @Test def test_invalidByteBitLengthExpr(): Unit = {
    runner.runOneTest("invalidByteBitLengthExpr")
  }

  @Test def test_insufficientBitsComplex(): Unit = {
    runner.runOneTest("insufficientBitsComplex")
  }

  @Test def test_insufficientBitsByte(): Unit = {
    runner.runOneTest("insufficientBitsByte")
  }

  // DFDL-2297
  @Test def test_outOfRangeLengthBinaryInteger1(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryInteger1")
  }
  @Test def test_outOfRangeLengthBinaryInteger2(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryInteger2")
  }
  @Test def test_outOfRangeLengthBinaryInteger3(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryInteger3")
  }
  @Test def test_outOfRangeLengthBinaryInteger4(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryInteger4")
  }
  @Test def test_outOfRangeLengthBinaryInteger5(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryInteger5")
  }
  @Test def test_outOfRangeLengthBinaryInteger6(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryInteger6")
  }
  @Test def test_outOfRangeLengthBinaryInteger7(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryInteger7")
  }
  @Test def test_outOfRangeLengthBinaryInteger8(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryInteger8")
  }
  @Test def test_outOfRangeLengthBinaryInteger9(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryInteger9")
  }
  @Test def test_outOfRangeLengthBinaryInteger10(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryInteger10")
  }
  @Test def test_outOfRangeLengthBinaryInteger11(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryInteger11")
  }
  @Test def test_outOfRangeLengthBinaryInteger12(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryInteger12")
  }
  @Test def test_outOfRangeLengthBinaryInteger13(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryInteger13")
  }
  @Test def test_inRangeLengthBinaryInteger1(): Unit = {
    runner.runOneTest("inRangeLengthBinaryInteger1")
  }
  @Test def test_inRangeLengthBinaryInteger2(): Unit = {
    runner.runOneTest("inRangeLengthBinaryInteger2")
  }
  @Test def test_inRangeLengthBinaryInteger3(): Unit = {
    runner.runOneTest("inRangeLengthBinaryInteger3")
  }
  @Test def test_inRangeLengthBinaryInteger4(): Unit = {
    runner.runOneTest("inRangeLengthBinaryInteger4")
  }
  @Test def test_inRangeLengthBinaryInteger5(): Unit = {
    runner.runOneTest("inRangeLengthBinaryInteger5")
  }
  @Test def test_inRangeLengthBinaryInteger6(): Unit = {
    runner.runOneTest("inRangeLengthBinaryInteger6")
  }
  @Test def test_inRangeLengthBinaryInteger7(): Unit = {
    runner.runOneTest("inRangeLengthBinaryInteger7")
  }
  @Test def test_inRangeLengthBinaryInteger8(): Unit = {
    runner.runOneTest("inRangeLengthBinaryInteger8")
  }
  @Test def test_inRangeLengthBinaryInteger9(): Unit = {
    runner.runOneTest("inRangeLengthBinaryInteger9")
  }
  @Test def test_inRangeLengthBinaryInteger10(): Unit = {
    runner.runOneTest("inRangeLengthBinaryInteger10")
  }
  @Test def test_outOfRangeLengthBinaryDecimal1(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryDecimal1")
  }
  @Test def test_outOfRangeLengthBinaryDecimal2(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryDecimal2")
  }
  @Test def test_outOfRangeLengthBinaryDecimal3(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryDecimal3")
  }
  @Test def test_outOfRangeLengthBinaryDecimal4(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryDecimal4")
  }
  @Test def test_outOfRangeLengthBinaryDecimal5(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryDecimal5")
  }
  @Test def test_outOfRangeLengthBinaryDecimal6(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryDecimal6")
  }
  @Test def test_outOfRangeLengthBinaryDecimal7(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryDecimal7")
  }
  @Test def test_outOfRangeLengthBinaryDecimal8(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryDecimal8")
  }
  @Test def test_outOfRangeLengthBinaryDecimal9(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryDecimal9")
  }
  @Test def test_outOfRangeLengthBinaryDecimal10(): Unit = {
    runner.runOneTest("outOfRangeLengthBinaryDecimal10")
  }
}
