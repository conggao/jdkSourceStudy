/***** Lobxxx Translate Finished ******/
package org.omg.IOP;


/**
* org/omg/IOP/TAG_RMI_CUSTOM_MAX_STREAM_FORMAT.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u45/3627/corba/src/share/classes/org/omg/PortableInterceptor/IOP.idl
* Thursday, April 30, 2015 12:42:09 PM PDT
*/

public interface TAG_RMI_CUSTOM_MAX_STREAM_FORMAT
{

  /**
     * RMI-IIOP has multiple stream format versions.  A server
     * can specify its maximum version by including the
     * TAG_RMI_CUSTOM_MAX_STREAM_FORMAT tagged component or
     * rely on the default of version 1 for GIOP 1.2 and less
     * and version 2 for GIOP 1.3 and higher.
     *
     * See Java to IDL ptc/02-01-12 1.4.11.
     * <p>
     *  RMI-IIOP有多个流格式版本。
     * 服务器可以通过包括TAG_RMI_CUSTOM_MAX_STREAM_FORMAT标记的组件来指定其最大版本,或者依赖于版本1(对于GIOP 1.2和更低)和版本2(对于GIOP 1.3和更高版本)的默
     * 认值。
     *  RMI-IIOP有多个流格式版本。
     */
  public static final int value = (int)(38L);
}
