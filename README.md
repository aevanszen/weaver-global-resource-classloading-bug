#  Repo description

This is a sample project demonstrating a bug in [Weaver](https://disneystreaming.github.io/weaver-test) trying to use a GlobalResource defined in an SBT subproject.

When a GlobalResource is in a sub-project i.e. our `test-support` module Weaver produces the below error:

```
[error] - Unexpected failure 0ms
[error]   GlobalResourceF$ResourceNotFound: Could not find a resource of type java.lang.String with label null
[error]
[error]   GlobalResourceF.scala:110    weaver.GlobalResourceF$Read#$anonfun$getOrFailR$1
[error]   Stream.scala:3475            fs2.Stream$#$anonfun$resourceWeak$3
[error]   Stream.scala:3475            fs2.Stream$#$anonfun$resourceWeak$3$adapted
[error]   Stream.scala:1191            fs2.Stream$#$anonfun$flatMap$1
[error]   Algebra.scala:620            fs2.internal.FreeC$#$anonfun$flatMapOutput$1
[error]   Algebra.scala:53             fs2.internal.FreeC$$anon$1#cont
[error]   Algebra.scala:240            fs2.internal.FreeC$ViewL$$anon$9$$anon$10#<init>
[error]   Algebra.scala:240            fs2.internal.FreeC$ViewL$$anon$9#cont
[error]   Algebra.scala:234            fs2.internal.FreeC$ViewL$$anon$8#next
[error]   Algebra.scala:475            fs2.internal.FreeC$#$anonfun$compile$8
[error]   CECompat.scala:51            eval @ weaver.CECompat#resourceLift
[error]   CompileScope.scala:413       map @ fs2.internal.CompileScope#interruptibleEval
[error]   Algebra.scala:503            flatMap @ fs2.internal.FreeC$#go$1
[error]   Algebra.scala:463            flatMap @ fs2.internal.FreeC$#$anonfun$compile$7
[error]   Algebra.scala:460            flatMap @ fs2.internal.FreeC$#go$1
[error]   Algebra.scala:436            flatMap @ fs2.internal.FreeC$#interruptGuard$1
[error]   Algebra.scala:436            flatMap @ fs2.internal.FreeC$#interruptGuard$1
[error]   CompileScope.scala:185       flatMap @ fs2.internal.CompileScope#$anonfun$acquireResource$4
[error]   ScopedResource.scala:139     flatten @ fs2.internal.ScopedResource$$anon$1#acquired
[error]   CompileScope.scala:183       flatMap @ fs2.internal.CompileScope#$anonfun$acquireResource$1
[error]   CompileScope.scala:180       flatMap @ fs2.internal.CompileScope#acquireResource
[error]   Algebra.scala:511            flatMap @ fs2.internal.FreeC$#$anonfun$compile$12
[error]   Algebra.scala:436            flatMap @ fs2.internal.FreeC$#interruptGuard$1
[error]   Algebra.scala:436            flatMap @ fs2.internal.FreeC$#interruptGuard$1
[error]   Algebra.scala:436            flatMap @ fs2.internal.FreeC$#interruptGuard$1
[error]   CompileScope.scala:185       flatMap @ fs2.internal.CompileScope#$anonfun$acquireResource$4
```

If you move the GlobalResource to the same project the test suite is defined (i.e. /src/test) the suite runs as expected.

```
sbt:root> test
[info] compiling 1 Scala source to /Users/adam.evans/Code/zendesk/weaver-poc/target/scala-2.12/test-classes ...
[info] MyTestSuite
[info] + I can use the global resource 19ms
[info] Passed: Total 1, Failed 0, Errors 0, Passed 1
[success] Total time: 1 s, completed 16 Feb 2022, 5:17:46 pm
```

## Running the sample project

The project is set up as a minimal [SBT](https://www.scala-sbt.org/) build.

To run the sample test use `sbt test`.