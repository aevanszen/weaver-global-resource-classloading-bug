lazy val root = (project in file("."))
  .settings(
    testFrameworks := Seq(
      new TestFramework("weaver.framework.Monix")
    ),

    libraryDependencies ++= Seq(
      "com.disneystreaming" %% "weaver-monix" % "0.6.9"
    )
  )
  .dependsOn(testSupport % "test")

lazy val testSupport = (project in file("test-support"))
  .settings(
    libraryDependencies ++= Seq(
      "com.disneystreaming" %% "weaver-monix" % "0.6.9"
    )
  )