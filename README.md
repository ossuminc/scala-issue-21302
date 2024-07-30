# scala-issue-21302
Reproduction Case for Scala 3 compiler issue #21302
You can reference the issue here:
https://github.com/scala/scala3/issues/21302

The reproduction case is in this repository:
https://github.com/ossuminc/scala-issue-21302

To reproduce:
* `git clone https://github.com/ossuminc/scala-issue-21302`
* `cd scala-issue-21302`
* `sbt`
* `project issue`
* `compile # should work`
* `project issueJS`
* `compile # should reproduce issue`

## Unexpected output:
```shell
  An unhandled exception was thrown in the compiler.
  Please file a crash report here:
  https://github.com/scala/scala3/issues/new/choose
  For non-enriched exceptions, compile with -Yno-enrich-error-messages.

     while compiling: /Users/reid/Code/ossuminc/scala-issue-21302/issue/shared/src/main/scala/com/ossuminc/issue/Folding.scala
        during phase: prepjsinterop
                mode: Mode(ImplicitsEnabled)
     library version: version 2.13.12
    compiler version: version 3.4.2
            settings: -Werror true -bootclasspath /Users/reid/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.4.2/scala3-library_3-3.4.2.jar:/Users/reid/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar -classpath /Users/reid/Code/ossuminc/scala-issue-21302/issue/js/target/scala-3.4.2/classes:/Users/reid/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_sjs1_3/3.4.2/scala3-library_sjs1_3-3.4.2.jar:/Users/reid/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-js/scalajs-library_2.13/1.16.0/scalajs-library_2.13-1.16.0.jar:/Users/reid/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/com/lihaoyi/fastparse_sjs1_3/3.1.1/fastparse_sjs1_3-3.1.1.jar:/Users/reid/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-js/scalajs-javalib/1.16.0/scalajs-javalib-1.16.0.jar:/Users/reid/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-js/scalajs-scalalib_2.13/2.13.13%2B1.16.0/scalajs-scalalib_2.13-2.13.13%2B1.16.0.jar:/Users/reid/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/com/lihaoyi/sourcecode_sjs1_3/0.4.0/sourcecode_sjs1_3-0.4.0.jar:/Users/reid/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/com/lihaoyi/geny_sjs1_3/1.1.0/geny_sjs1_3-1.1.0.jar -d /Users/reid/Code/ossuminc/scala-issue-21302/issue/js/target/scala-3.4.2/classes -deprecation true -explain true -explain-cyclic true -explain-types true -feature true -new-syntax true -nowarn true -pagewidth 120 -scalajs true

[error] ## Exception when compiling 1 sources to /Users/reid/Code/ossuminc/scala-issue-21302/issue/js/target/scala-3.4.2/classes
[error] java.lang.AssertionError: assertion failed: Cannot find default getter for param 4 of method foldLeftWithStack
[error] scala.runtime.Scala3RunTime$.assertFailed(Scala3RunTime.scala:8)
[error] dotty.tools.dotc.transform.sjs.PrepJSExports$.genExportDefaultGetter(PrepJSExports.scala:411)
[error] dotty.tools.dotc.transform.sjs.PrepJSExports$.$anonfun$9(PrepJSExports.scala:398)
[error] scala.collection.Iterator$$anon$9.next(Iterator.scala:584)
[error] scala.collection.immutable.List.prependedAll(List.scala:153)
[error] scala.collection.immutable.List$.from(List.scala:684)
[error] scala.collection.immutable.List$.from(List.scala:681)
[error] scala.collection.IterableOps$WithFilter.map(Iterable.scala:898)
[error] dotty.tools.dotc.transform.sjs.PrepJSExports$.genExportDefs(PrepJSExports.scala:399)
[error] dotty.tools.dotc.transform.sjs.PrepJSExports$.genExportMember$$anonfun$1(PrepJSExports.scala:98)
[error] scala.collection.immutable.List.flatMap(List.scala:293)
[error] dotty.tools.dotc.transform.sjs.PrepJSExports$.genExportMember(PrepJSExports.scala:98)
[error] dotty.tools.dotc.transform.sjs.PrepJSInterop$ScalaJSPrepJSInteropTransformer.transformMemberDef(PrepJSInterop.scala:175)
[error] dotty.tools.dotc.transform.sjs.PrepJSInterop$ScalaJSPrepJSInteropTransformer.transform(PrepJSInterop.scala:128)
[error] dotty.tools.dotc.ast.tpd$TreeMapWithPreciseStatContexts.loop$2(tpd.scala:1254)
[error] dotty.tools.dotc.ast.tpd$TreeMapWithPreciseStatContexts.transformStats(tpd.scala:1254)
[error] dotty.tools.dotc.ast.tpd$TreeMapWithPreciseStatContexts.transformStats(tpd.scala:1256)
[error] dotty.tools.dotc.transform.MacroTransform$Transformer.transform(MacroTransform.scala:47)
[error] dotty.tools.dotc.transform.sjs.PrepJSInterop$ScalaJSPrepJSInteropTransformer.transformTemplate(PrepJSInterop.scala:222)
[error] dotty.tools.dotc.transform.sjs.PrepJSInterop$ScalaJSPrepJSInteropTransformer.transform(PrepJSInterop.scala:129)
[error] dotty.tools.dotc.ast.Trees$Instance$TreeMap.transform(Trees.scala:1602)
[error] dotty.tools.dotc.transform.MacroTransform$Transformer.transform(MacroTransform.scala:40)
[error] dotty.tools.dotc.transform.sjs.PrepJSInterop$ScalaJSPrepJSInteropTransformer.transformScalaClassDef$$anonfun$2(PrepJSInterop.scala:216)
[error] dotty.tools.dotc.transform.sjs.PrepJSInterop$ScalaJSPrepJSInteropTransformer.enterOwner(PrepJSInterop.scala:89)
[error] dotty.tools.dotc.transform.sjs.PrepJSInterop$ScalaJSPrepJSInteropTransformer.transformScalaClassDef(PrepJSInterop.scala:217)
[error] dotty.tools.dotc.transform.sjs.PrepJSInterop$ScalaJSPrepJSInteropTransformer.transformMemberDef(PrepJSInterop.scala:168)
[error] dotty.tools.dotc.transform.sjs.PrepJSInterop$ScalaJSPrepJSInteropTransformer.transform(PrepJSInterop.scala:128)
[error] dotty.tools.dotc.ast.tpd$TreeMapWithPreciseStatContexts.loop$2(tpd.scala:1254)
[error] dotty.tools.dotc.ast.tpd$TreeMapWithPreciseStatContexts.transformStats(tpd.scala:1254)
[error] dotty.tools.dotc.ast.tpd$TreeMapWithPreciseStatContexts.transformStats(tpd.scala:1256)
[error] dotty.tools.dotc.ast.Trees$Instance$TreeMap.transform(Trees.scala:1613)
[error] dotty.tools.dotc.transform.MacroTransform$Transformer.transform(MacroTransform.scala:40)
[error] dotty.tools.dotc.transform.sjs.PrepJSInterop$ScalaJSPrepJSInteropTransformer.transformStatOrExpr(PrepJSInterop.scala:402)
[error] dotty.tools.dotc.transform.sjs.PrepJSInterop$ScalaJSPrepJSInteropTransformer.transform(PrepJSInterop.scala:130)
[error] dotty.tools.dotc.transform.MacroTransform.run(MacroTransform.scala:18)
[error] dotty.tools.dotc.core.Phases$Phase.runOn$$anonfun$1(Phases.scala:354)
[error] scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
[error] scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
[error] scala.collection.immutable.List.foreach(List.scala:333)
[error] dotty.tools.dotc.core.Phases$Phase.runOn(Phases.scala:360)
[error] dotty.tools.dotc.Run.runPhases$1$$anonfun$1(Run.scala:315)
[error] scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
[error] scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
[error] scala.collection.ArrayOps$.foreach$extension(ArrayOps.scala:1323)
[error] dotty.tools.dotc.Run.runPhases$1(Run.scala:337)
[error] dotty.tools.dotc.Run.compileUnits$$anonfun$1(Run.scala:350)
[error] dotty.tools.dotc.Run.compileUnits$$anonfun$adapted$1(Run.scala:360)
[error] dotty.tools.dotc.util.Stats$.maybeMonitored(Stats.scala:69)
[error] dotty.tools.dotc.Run.compileUnits(Run.scala:360)
[error] dotty.tools.dotc.Run.compileSources(Run.scala:261)
[error] dotty.tools.dotc.Run.compile(Run.scala:246)
[error] dotty.tools.dotc.Driver.doCompile(Driver.scala:37)
[error] dotty.tools.xsbt.CompilerBridgeDriver.run(CompilerBridgeDriver.java:141)
[error] dotty.tools.xsbt.CompilerBridge.run(CompilerBridge.java:22)
[error] sbt.internal.inc.AnalyzingCompiler.compile(AnalyzingCompiler.scala:91)
[error] sbt.internal.inc.MixedAnalyzingCompiler.$anonfun$compile$7(MixedAnalyzingCompiler.scala:193)
[error] scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.java:23)
[error] sbt.internal.inc.MixedAnalyzingCompiler.timed(MixedAnalyzingCompiler.scala:248)
[error] sbt.internal.inc.MixedAnalyzingCompiler.$anonfun$compile$4(MixedAnalyzingCompiler.scala:183)
[error] sbt.internal.inc.MixedAnalyzingCompiler.$anonfun$compile$4$adapted(MixedAnalyzingCompiler.scala:163)
[error] sbt.internal.inc.JarUtils$.withPreviousJar(JarUtils.scala:239)
[error] sbt.internal.inc.MixedAnalyzingCompiler.compileScala$1(MixedAnalyzingCompiler.scala:163)
[error] sbt.internal.inc.MixedAnalyzingCompiler.compile(MixedAnalyzingCompiler.scala:211)
[error] sbt.internal.inc.IncrementalCompilerImpl.$anonfun$compileInternal$1(IncrementalCompilerImpl.scala:534)
[error] sbt.internal.inc.IncrementalCompilerImpl.$anonfun$compileInternal$1$adapted(IncrementalCompilerImpl.scala:534)
[error] sbt.internal.inc.Incremental$.$anonfun$apply$5(Incremental.scala:180)
[error] sbt.internal.inc.Incremental$.$anonfun$apply$5$adapted(Incremental.scala:178)
[error] sbt.internal.inc.Incremental$$anon$2.run(Incremental.scala:464)
[error] sbt.internal.inc.IncrementalCommon$CycleState.next(IncrementalCommon.scala:116)
[error] sbt.internal.inc.IncrementalCommon$$anon$1.next(IncrementalCommon.scala:56)
[error] sbt.internal.inc.IncrementalCommon$$anon$1.next(IncrementalCommon.scala:52)
[error] sbt.internal.inc.IncrementalCommon.cycle(IncrementalCommon.scala:263)
[error] sbt.internal.inc.Incremental$.$anonfun$incrementalCompile$8(Incremental.scala:419)
[error] sbt.internal.inc.Incremental$.withClassfileManager(Incremental.scala:506)
[error] sbt.internal.inc.Incremental$.incrementalCompile(Incremental.scala:406)
[error] sbt.internal.inc.Incremental$.apply(Incremental.scala:172)
[error] sbt.internal.inc.IncrementalCompilerImpl.compileInternal(IncrementalCompilerImpl.scala:534)
[error] sbt.internal.inc.IncrementalCompilerImpl.$anonfun$compileIncrementally$1(IncrementalCompilerImpl.scala:488)
[error] sbt.internal.inc.IncrementalCompilerImpl.handleCompilationError(IncrementalCompilerImpl.scala:332)
[error] sbt.internal.inc.IncrementalCompilerImpl.compileIncrementally(IncrementalCompilerImpl.scala:425)
[error] sbt.internal.inc.IncrementalCompilerImpl.compile(IncrementalCompilerImpl.scala:137)
[error] sbt.Defaults$.compileIncrementalTaskImpl(Defaults.scala:2371)
[error] sbt.Defaults$.$anonfun$compileIncrementalTask$2(Defaults.scala:2321)
[error] sbt.internal.server.BspCompileTask$.$anonfun$compute$1(BspCompileTask.scala:31)
[error] sbt.internal.io.Retry$.apply(Retry.scala:47)
[error] sbt.internal.io.Retry$.apply(Retry.scala:29)
[error] sbt.internal.io.Retry$.apply(Retry.scala:24)
[error] sbt.internal.server.BspCompileTask$.compute(BspCompileTask.scala:31)
[error] sbt.Defaults$.$anonfun$compileIncrementalTask$1(Defaults.scala:2319)
[error] scala.Function1.$anonfun$compose$1(Function1.scala:49)
[error] sbt.internal.util.$tilde$greater.$anonfun$$u2219$1(TypeFunctions.scala:63)
[error] sbt.std.Transform$$anon$4.work(Transform.scala:69)
[error] sbt.Execute.$anonfun$submit$2(Execute.scala:283)
[error] sbt.internal.util.ErrorHandling$.wideConvert(ErrorHandling.scala:24)
[error] sbt.Execute.work(Execute.scala:292)
[error] sbt.Execute.$anonfun$submit$1(Execute.scala:283)
[error] sbt.ConcurrentRestrictions$$anon$4.$anonfun$submitValid$1(ConcurrentRestrictions.scala:265)
[error] sbt.CompletionService$$anon$2.call(CompletionService.scala:65)
[error] java.base/java.util.concurrent.FutureTask.run(FutureTask.java:317)
[error] java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:572)
[error] java.base/java.util.concurrent.FutureTask.run(FutureTask.java:317)
[error] java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
[error] java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
[error] java.base/java.lang.Thread.run(Thread.java:1583)
```
