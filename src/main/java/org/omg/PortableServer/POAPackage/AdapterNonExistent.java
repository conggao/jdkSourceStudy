/***** Lobxxx Translate Finished ******/
package org.omg.PortableServer.POAPackage;


/**
* org/omg/PortableServer/POAPackage/AdapterNonExistent.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u45/3627/corba/src/share/classes/org/omg/PortableServer/poa.idl
* Thursday, April 30, 2015 12:42:10 PM PDT
*/

public final class AdapterNonExistent extends org.omg.CORBA.UserException
{

  public AdapterNonExistent ()
  {
    super(AdapterNonExistentHelper.id());
  } // ctor


  public AdapterNonExistent (String $reason)
  {
    super(AdapterNonExistentHelper.id() + "  " + $reason);
  } // ctor

} // class AdapterNonExistent
