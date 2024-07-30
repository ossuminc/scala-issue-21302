import com.ossuminc.sbt.{OssumIncPlugin, Plugin}
import sbt.Keys.description
import sbtbuildinfo.BuildInfoPlugin.autoImport.buildInfoPackage
import sbtcrossproject.CrossProject

Global / onChangedBuildSource := ReloadOnSourceChanges
(Global / excludeLintKeys) ++= Set(mainClass)

enablePlugins(OssumIncPlugin)

lazy val root: Project = Root("scala-issue", startYr = 2024)
  .configure(With.noPublishing, With.git, With.dynver)
  .aggregate(issue, issueJS)

lazy val issue_cp: CrossProject = CrossModule("issue", "scala-issue-21302")(JVM,JS)
  .configure(With.typical)
  .settings(
    description := "Abstract Syntax Tree and basic RIDDL language parser",
    scalaVersion := "3.4.2",
    scalacOptions ++= Seq("-explain", "--explain-types", "--explain-cyclic", "--no-warnings")
  )
  .jvmConfigure(With.publishing)
  .jsConfigure(With.js(hasMain = false, forProd = true, withCommonJSModule=false))
  .jvmSettings(
    libraryDependencies += "com.lihaoyi" %%% "fastparse" % "3.1.1",
    libraryDependencies += "commons-io" % "commons-io" % "2.16.1" % Test
  )
  .jsSettings(
    libraryDependencies += "com.lihaoyi" %%% "fastparse" % "3.1.1"
  )
lazy val issue = issue_cp.jvm
lazy val issueJS = issue_cp.js
