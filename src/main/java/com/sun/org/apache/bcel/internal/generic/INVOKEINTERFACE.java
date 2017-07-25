/***** Lobxxx Translate Finished ******/
/*
 * Copyright (c) 2007, 2015, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sun.org.apache.bcel.internal.generic;

/* ====================================================================
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2001 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The names "Apache" and "Apache Software Foundation" and
 *    "Apache BCEL" must not be used to endorse or promote products
 *    derived from this software without prior written permission. For
 *    written permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache",
 *    "Apache BCEL", nor may "Apache" appear in their name, without
 *    prior written permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 * <p>
 *  Apache软件许可证,版本1.1
 * 
 *  版权所有(c)2001 Apache软件基金会。版权所有。
 * 
 *  如果满足以下条件,则允许重新分发和使用源代码和二进制形式(带或不带修改)：
 * 
 *  1.源代码的再分发必须保留上述版权声明,此条件列表和以下免责声明。
 * 
 *  2.二进制形式的再分发必须在分发所提供的文档和/或其他材料中复制上述版权声明,此条件列表和以下免责声明。
 * 
 *  3.包含在重新分发中的最终用户文档(如果有)必须包括以下声明："本产品包括由Apache Software Foundation(http://www.apache.org/)开发的软件。
 * 或者,如果此类第三方确认通常出现,则此确认可能出现在软件本身中。
 * 
 *  4.未经事先书面许可,不得使用名称"Apache"和"Apache Software Foundation"和"Apache BCEL"来认可或推广从本软件衍生的产品。
 * 如需书面许可,请联系apache@apache.org。
 * 
 * 未经Apache软件基金会事先书面许可,从本软件衍生的产品可能不会被称为"Apache","Apache BCEL",也不可能出现在他们的名字中。
 * 
 *  本软件按"原样"提供,任何明示或默示的保证,包括但不限于适销性和特定用途适用性的默示保证。
 * 在任何情况下,APACHE软件基金会或其捐赠者均不对任何直接,间接,偶发,特殊,惩罚性或后果性损害(包括但不限于替代商品或服务的采购,使用,数据丢失或利润或业务中断),无论是由于任何责任推理原因,无论是
 * 在合同,严格责任或侵权(包括疏忽或其他方式)中,以任何方式使用本软件,即使已被告知此类软件的可能性损伤。
 *  本软件按"原样"提供,任何明示或默示的保证,包括但不限于适销性和特定用途适用性的默示保证。
 *  ================================================== ==================。
 */
import com.sun.org.apache.bcel.internal.classfile.ConstantPool;
import com.sun.org.apache.bcel.internal.Constants;
import com.sun.org.apache.bcel.internal.ExceptionConstants;

import java.io.*;
import com.sun.org.apache.bcel.internal.util.ByteSequence;

/**
 * INVOKEINTERFACE - Invoke interface method
 * <PRE>Stack: ..., objectref, [arg1, [arg2 ...]] -&gt; ...</PRE>
 *
 * <p>
 * 
 *  该软件包括许多个人代表Apache软件基金会所做的自愿捐款。有关Apache Software Foundation的更多信息,请参阅<http://www.apache.org/>。
 * 
 * 
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public final class INVOKEINTERFACE extends InvokeInstruction {
  private int nargs; // Number of arguments on stack (number of stack slots), called "count" in vmspec2

  /**
   * Empty constructor needed for the Class.newInstance() statement in
   * Instruction.readInstruction(). Not to be used otherwise.
   * <p>
   *  INVOKEINTERFACE  - 调用接口方法<PRE> Stack：...,objectref,[arg1,[arg2 ...]]  - &gt; ... </PRE>
   * 
   */
  INVOKEINTERFACE() {}

  public INVOKEINTERFACE(int index, int nargs) {
    super(Constants.INVOKEINTERFACE, index);
    length = 5;

    if(nargs < 1)
      throw new ClassGenException("Number of arguments must be > 0 " + nargs);

    this.nargs = nargs;
  }

  /**
   * Dump instruction as byte code to stream out.
   * <p>
   *  Instruction.readInstruction()中的Class.newInstance()语句所需的空构造函数。不要以其他方式使用。
   * 
   * 
   * @param out Output stream
   */
  public void dump(DataOutputStream out) throws IOException {
    out.writeByte(opcode);
    out.writeShort(index);
    out.writeByte(nargs);
    out.writeByte(0);
  }

  /**
   * The <B>count</B> argument according to the Java Language Specification,
   * Second Edition.
   * <p>
   *  转储指令作为字节码流输出。
   * 
   */
  public int getCount() { return nargs; }

  /**
   * Read needed data (i.e., index) from file.
   * <p>
   * 根据Java语言规范第二版的<B>计数</B>参数。
   * 
   */
  protected void initFromFile(ByteSequence bytes, boolean wide)
       throws IOException
  {
    super.initFromFile(bytes, wide);

    length = 5;
    nargs = bytes.readUnsignedByte();
    bytes.readByte(); // Skip 0 byte
  }

  /**
  /* <p>
  /*  从文件中读取所需的数据(即索引)。
  /* 
  /* 
   * @return mnemonic for instruction with symbolic references resolved
   */
  public String toString(ConstantPool cp) {
    return super.toString(cp) + " " + nargs;
  }

  public int consumeStack(ConstantPoolGen cpg) { // nargs is given in byte-code
    return nargs;  // nargs includes this reference
  }

  public Class[] getExceptions() {
    Class[] cs = new Class[4 + ExceptionConstants.EXCS_INTERFACE_METHOD_RESOLUTION.length];

    System.arraycopy(ExceptionConstants.EXCS_INTERFACE_METHOD_RESOLUTION, 0,
                     cs, 0, ExceptionConstants.EXCS_INTERFACE_METHOD_RESOLUTION.length);

    cs[ExceptionConstants.EXCS_INTERFACE_METHOD_RESOLUTION.length+3] = ExceptionConstants.INCOMPATIBLE_CLASS_CHANGE_ERROR;
    cs[ExceptionConstants.EXCS_INTERFACE_METHOD_RESOLUTION.length+2] = ExceptionConstants.ILLEGAL_ACCESS_ERROR;
    cs[ExceptionConstants.EXCS_INTERFACE_METHOD_RESOLUTION.length+1] = ExceptionConstants.ABSTRACT_METHOD_ERROR;
    cs[ExceptionConstants.EXCS_INTERFACE_METHOD_RESOLUTION.length]   = ExceptionConstants.UNSATISFIED_LINK_ERROR;

    return cs;
  }

  /**
   * Call corresponding visitor method(s). The order is:
   * Call visitor methods of implemented interfaces first, then
   * call methods according to the class hierarchy in descending order,
   * i.e., the most specific visitXXX() call comes last.
   *
   * <p>
   * 
   * @param v Visitor object
   */
  public void accept(Visitor v) {
    v.visitExceptionThrower(this);
    v.visitTypedInstruction(this);
    v.visitStackConsumer(this);
    v.visitStackProducer(this);
    v.visitLoadClass(this);
    v.visitCPInstruction(this);
    v.visitFieldOrMethod(this);
    v.visitInvokeInstruction(this);
    v.visitINVOKEINTERFACE(this);
  }
}
