/***** Lobxxx Translate Finished ******/
/*
 * Copyright (c) 2000, 2001, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.omg.CORBA;

/**
* The Holder for <tt>UnknownUserException</tt>.  For more information on
* Holder files, see <a href="doc-files/generatedfiles.html#holder">
* "Generated Files: Holder Files"</a>.<P>
* org/omg/CORBA/UnknownUserExceptionHolder.java
* Generated by the IDL-to-Java compiler (portable), version "3.0"
* from CORBA.idl
* Thursday, August 24, 2000 5:52:22 PM PDT
* <p>
*  <tt> UnknownUserException </tt>的持有人。
* 有关Holder文件的详细信息,请参见<a href="doc-files/generatedfiles.html#holder">"生成的文件：持有人文件"</a>。
* <P> org / omg / CORBA / UnknownUserExceptionHolder.java生成者IDL到Java编译器(portable),版本"3.0"from CORBA.idl
*/

public final class UnknownUserExceptionHolder implements org.omg.CORBA.portable.Streamable
{
  public org.omg.CORBA.UnknownUserException value = null;

  public UnknownUserExceptionHolder ()
  {
  }

  public UnknownUserExceptionHolder (org.omg.CORBA.UnknownUserException initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.omg.CORBA.UnknownUserExceptionHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.omg.CORBA.UnknownUserExceptionHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.omg.CORBA.UnknownUserExceptionHelper.type ();
  }

}