/*
 * Copyright 2019 Ossum, Inc.
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ossuminc.issue

import scala.collection.mutable
import scala.scalajs.js.annotation.*

/** An object for distinguishing several functions as ways to fold the model */
@JSExportTopLevel("Folding")
object Folding {

  trait RiddlValue {
    def isContainer: Boolean
    def isEmpty: Boolean
    def nonEmpty: Boolean = !isEmpty
    def isAnonymous: Boolean = false
  }

  private type Contents[+CV <: RiddlValue] = Seq[CV]

  sealed trait Container[+CV <: RiddlValue] extends RiddlValue {
    def contents: Contents[CV]
    def isContainer: Boolean = true
  }

  private type SimpleDispatch[S, V <: RiddlValue] = (Container[V], V, S) => S

  @JSExport
  def foldEachDefinition[S, V <: RiddlValue](
    parent: Container[V],
    child: V,
    state: S
  )(f: SimpleDispatch[S, V]): S = {
    child match {
      case value: V if value.isContainer && value.nonEmpty =>
        val result = f(parent, child, state)
        val container = value.asInstanceOf[Container[V]]
        container.contents.foldLeft(result) { case (next, child) =>
          foldEachDefinition[S, V](container, child, next)(f)
        }
      case value: V => f(parent, value, state)
    }
  }

  @JSExport final def foldLeftWithStack[S, CT <: RiddlValue](
    value: S,
    top: Container[CT],
    parents: mutable.Stack[Container[CT]] = mutable.Stack.empty[Container[CT]]
  )(f: (S, CT | Container[CT], Seq[Container[CT]]) => S = { (x: S, y: CT, z: Seq[Container[CT]]) => x }): S = {
    val initial = f(value, top, parents.toSeq)
    if !top.isAnonymous then parents.push(top)
    try {
      top.contents.foldLeft(initial) { (next, value) =>
        value match {
          case c: Container[CT] @unchecked if c.nonEmpty => foldLeftWithStack(next, c, parents)(f)
          case v: RiddlValue                             => f(next, v, parents.toSeq)
        }
      }
    } finally {
      if !top.isAnonymous then parents.pop()
    }
  }
}
