/***** Lobxxx Translate Finished ******/
/*
 * Copyright (c) 1999, 2001, Oracle and/or its affiliates. All rights reserved.
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
* The interface for <tt>IRObject</tt>.  For more information on
* Operations interfaces, see <a href="doc-files/generatedfiles.html#operations">
* "Generated Files: Operations files"</a>.
* <p>
*  <tt> IRObject </tt>的界面。
* 有关操作界面的详细信息,请参见<a href="doc-files/generatedfiles.html#operations">"生成的文件：操作文件"</a>。
* 
*/

/*
 tempout/org/omg/CORBA/IRObjectOperations.java
 Generated by the IBM IDL-to-Java compiler, version 1.0
 from ../../Lib/ir.idl
 Thursday, February 25, 1999 2:11:21 o'clock PM PST
/* <p>
/*  tempout / org / omg / CORBA / IRObjectOperations.java由IBM IDL到Java编译器生成,版本为1.0从../../Lib/ir.idl 1999
/* 年2月25日星期四2:11:21 PM PST。
/* 
*/

/**
 * This is the Operations interface for the mapping from <tt>IRObject</tt>.
 * Several interfaces are used as base interfaces for objects in
 * the Interface Repository (IR). These base interfaces are not instantiable.
 * A common set of operations is used to locate objects within the
 * Interface Repository. Some of these operations are defined in
 * the IRObject. All IR objects inherit from the IRObject interface,
 * which provides an operation for identifying the actual type of
 * the object. (The IDL base interface IRObject represents the most
 * generic interface from which all other Interface Repository interfaces
 * are derived, even the Repository itself.) All java implementations of
 * IR objects must implement the IRObjectOperations interface.
 * <p>
 *  这是从<tt> IRObject </tt>映射的操作接口。几个接口用作接口存储库(IR)中对象的基本接口。这些基本接口不可实例化。
 * 一组常用的操作用于定位Interface Repository中的对象。其中一些操作在IRObject中定义。所有IR对象从IRObject接口继承,该接口提供用于标识对象的实际类型的操作。
 *  (IDL基础接口IRObject表示最通用的接口,从中导出所有其他Interface Repository接口,甚至Repository本身)。
 * 所有IR实现的IR对象必须实现IRObjectOperations接口。
 * 
 * 
 * @see IDLTypeOperations
 * @see IDLType
 * @see IRObject
 */
public interface IRObjectOperations
{

    // read interface
    /**
     * Returns the <code>DefinitionKind</code> corresponding to this Interface Repository object.
     * <p>
     *  返回与此Interface Repository对象对应的<code> DefinitionKind </code>。
     * 
     * 
     * @return the <code>DefinitionKind</code> corresponding to this Interface Repository object.
     */
    org.omg.CORBA.DefinitionKind def_kind ();

    // write interface
    /**
     * Destroys this object. If the object is a Container,
     * this method is applied to all its contents. If the object contains an IDLType
     * attribute for an anonymous type, that IDLType is destroyed.
     * If the object is currently contained in some other object, it is removed.
     * If the method is invoked on a <code>Repository</code> or on a <code>PrimitiveDef</code>
     * then the <code>BAD_INV_ORDER</code> exception is raised with minor value 2.
     * An attempt to destroy an object that would leave the repository in an
     * incoherent state causes <code>BAD_INV_ORDER</code> exception to be raised
     * with the minor code 1.
     * <p>
     * 销毁此对象。如果对象是容器,则此方法将应用于其所有内容。如果对象包含匿名类型的IDLType属性,那么该IDLType将被销毁。如果对象当前包含在某个其他对象中,则将其删除。
     * 如果该方法在<code> Repository </code>或<code> PrimitiveDef </code>上被调用,那么<code> BAD_INV_ORDER </code>异常被引发为次
     * 要值2.尝试销毁对象将使存储库处于不连续状态导致使用次要代码1引发<code> BAD_INV_ORDER </code>异常。
     * 
     * @exception BAD_INV_ORDER if this method is invoked on a repository or
     *            <code>PrimitiveDef</code>, or if an attempt to destroy an
     *            object would leave the repository in an incoherent state
     */
    void destroy ();
} // interface IRObjectOperations