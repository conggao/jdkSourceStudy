/***** Lobxxx Translate Finished ******/
/*
 * Copyright (c) 2007, 2015, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * Copyright 1999-2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 *  版权所有1999-2004 Apache软件基金会
 * 
 *  根据Apache许可证第20版("许可证")授权;您不得使用此文件,除非符合许可证您可以在获取许可证的副本
 * 
 *  http：// wwwapacheorg / licenses / LICENSE-20
 * 
 *  除非适用法律要求或书面同意,否则根据许可证分发的软件将按"原样"基础分发,无任何明示或暗示的保证或条件。请参阅许可证管理权限和限制许可证
 * 
 */
/*
 * $Id: Function2Args.java,v 1.2.4.1 2005/09/14 20:18:46 jeffsuttor Exp $
 * <p>
 *  $ Id：Function2Argsjava,v 1241 2005/09/14 20:18:46 jeffsuttor Exp $
 * 
 */
package com.sun.org.apache.xpath.internal.functions;

import com.sun.org.apache.xalan.internal.res.XSLMessages;
import com.sun.org.apache.xpath.internal.Expression;
import com.sun.org.apache.xpath.internal.ExpressionOwner;
import com.sun.org.apache.xpath.internal.XPathVisitor;

/**
 * Base class for functions that accept two arguments.
 * @xsl.usage advanced
 * <p>
 * 接受两个参数@xslusage advanced的函数的基类
 * 
 */
public class Function2Args extends FunctionOneArg
{
    static final long serialVersionUID = 5574294996842710641L;

  /** The second argument passed to the function (at index 1).
  /* <p>
  /* 
   *  @serial  */
  Expression m_arg1;

  /**
   * Return the second argument passed to the function (at index 1).
   *
   * <p>
   *  返回传递给函数的第二个参数(在索引1处)
   * 
   * 
   * @return An expression that represents the second argument passed to the
   *         function.
   */
  public Expression getArg1()
  {
    return m_arg1;
  }

  /**
   * This function is used to fixup variables from QNames to stack frame
   * indexes at stylesheet build time.
   * <p>
   *  此函数用于在样式表构建时将QNames中的变量修复为堆栈帧索引
   * 
   * 
   * @param vars List of QNames that correspond to variables.  This list
   * should be searched backwards for the first qualified name that
   * corresponds to the variable reference qname.  The position of the
   * QName in the vector from the start of the vector will be its position
   * in the stack frame (but variables above the globalsTop value will need
   * to be offset to the current stack frame).
   */
  public void fixupVariables(java.util.Vector vars, int globalsSize)
  {
    super.fixupVariables(vars, globalsSize);
    if(null != m_arg1)
      m_arg1.fixupVariables(vars, globalsSize);
  }


  /**
   * Set an argument expression for a function.  This method is called by the
   * XPath compiler.
   *
   * <p>
   *  设置函数的参数表达式此方法由XPath编译器调用
   * 
   * 
   * @param arg non-null expression that represents the argument.
   * @param argNum The argument number index.
   *
   * @throws WrongNumberArgsException If the argNum parameter is greater than 1.
   */
  public void setArg(Expression arg, int argNum)
          throws WrongNumberArgsException
  {

    // System.out.println("argNum: "+argNum);
    if (argNum == 0)
      super.setArg(arg, argNum);
    else if (1 == argNum)
    {
      m_arg1 = arg;
      arg.exprSetParent(this);
    }
    else
                  reportWrongNumberArgs();
  }

  /**
   * Check that the number of arguments passed to this function is correct.
   *
   *
   * <p>
   *  检查传递给此函数的参数数是否正确
   * 
   * 
   * @param argNum The number of arguments that is being passed to the function.
   *
   * @throws WrongNumberArgsException
   */
  public void checkNumberArgs(int argNum) throws WrongNumberArgsException
  {
    if (argNum != 2)
      reportWrongNumberArgs();
  }

  /**
   * Constructs and throws a WrongNumberArgException with the appropriate
   * message for this function object.
   *
   * <p>
   *  构造并抛出一个WrongNumberArgException与此函数对象的相应消息
   * 
   * 
   * @throws WrongNumberArgsException
   */
  protected void reportWrongNumberArgs() throws WrongNumberArgsException {
      throw new WrongNumberArgsException(XSLMessages.createXPATHMessage("two", null));
  }

  /**
   * Tell if this expression or it's subexpressions can traverse outside
   * the current subtree.
   *
   * <p>
   *  告诉这个表达式或它的子表达式是否可以遍历当前子树
   * 
   * 
   * @return true if traversal outside the context node's subtree can occur.
   */
   public boolean canTraverseOutsideSubtree()
   {
    return super.canTraverseOutsideSubtree()
    ? true : m_arg1.canTraverseOutsideSubtree();
   }

  class Arg1Owner implements ExpressionOwner
  {
    /**
    /* <p>
    /* 
     * @see ExpressionOwner#getExpression()
     */
    public Expression getExpression()
    {
      return m_arg1;
    }


    /**
    /* <p>
    /* 
     * @see ExpressionOwner#setExpression(Expression)
     */
    public void setExpression(Expression exp)
    {
        exp.exprSetParent(Function2Args.this);
        m_arg1 = exp;
    }
  }


  /**
  /* <p>
  /* 
   * @see com.sun.org.apache.xpath.internal.XPathVisitable#callVisitors(ExpressionOwner, XPathVisitor)
   */
  public void callArgVisitors(XPathVisitor visitor)
  {
        super.callArgVisitors(visitor);
        if(null != m_arg1)
                m_arg1.callVisitors(new Arg1Owner(), visitor);
  }

  /**
  /* <p>
  /* 
   * @see Expression#deepEquals(Expression)
   */
  public boolean deepEquals(Expression expr)
  {
        if(!super.deepEquals(expr))
                return false;

        if(null != m_arg1)
        {
                if(null == ((Function2Args)expr).m_arg1)
                        return false;

                if(!m_arg1.deepEquals(((Function2Args)expr).m_arg1))
                        return false;
        }
        else if(null != ((Function2Args)expr).m_arg1)
                return false;

        return true;
  }

}
