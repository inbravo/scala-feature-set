# scala-src : experiments in scala

-  [How to create custom annotations using 'scala.annotation.StaticAnnotation'] [AnnotationTest.md]
-  [How value '_' initializes to default value of variable. Default accessor and mutator methods in an object] [MutatorTest.md]
-  [Usage of companion object in Scala] [CompanionObjectTest.md]
-  [How generics works in Scala] [GenericsTest.md]
-  [Enviornment variables in Scala] [EnvironmentVarTest.md]
-  [First class functions in Scala] [FirstClassFuncTest.md]
-  [How to use 'Either'] [EitherTest.md]
-  [Different types of looping techniques in Scala] [LoopTest.md]
-  [How 'for each' works as loop] [ForEachTest.md]
-  [Keyword 'trait' in Scala is like 'interface' in Java] [MultipleTraitTest.md]
-  [Keyword 'sealed trait' in Scala is like 'enum' in Java] [SealedTraitTest.md]
-  [Use 'tuple' to build abstractions over related values] [TupleTest.md]
-  [How 'yield' helps in extracting values during loops] [YieldTest.md]
-  [How default object factory works] [ObjectFactoryTest.md]
-  [How 'import' works in Scala] [ImportTest.md]
-  [How 'isInstanceOf' works in Scala] [InstanceOfTest.md]
-  [How 'Seq[String]' used in Scala] [SeqOfStringsTest.md]
-  [How 'List' and 'Vector' used in Scala] [ListTest.md]
-  [How 'ArrayBuffer' used in Scala] [ArrayBufferTest.md]
-  [How 'try' 'catch' works in Scala] [TryCatchTest.md]
-  [How 'require' can be used to enforce restrictions before creating instance of a Scala class] [RequireTest.md]
-  [How a simple thread can be created in Scala][ThreadTest.md]
-  [How thread pool based concurrency works in Scala][NetworkService.md]
-  [How 'ServerSocket' can be used in Scala][NetworkService.md]
-  [How 'CountDownLatch' can be used in Scala][CountDownLatchTest.md]
-  [How 'CyclicBarrier' can be used in Scala][CyclicBarrierTest.md]

[AnnotationTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/AnnotationTest.scala
[MutatorTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/MutatorTest.scala
[EitherTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/EitherTest.scala  
[LoopTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/LoopTest.scala  
[MultipleTraitTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/MultipleTraitTest.scala  
[SealedTraitTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/SealedTraitTest.scala 
[TupleTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/TupleTest.scala 
[ForEachTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/ForEachTest.scala 
[YieldTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/ForEachTest.scala 
[ObjectFactoryTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/ObjectFactoryTest.scala 
[ImportTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/ImportTest.scala 
[InstanceOfTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/InstanceOfTest.scala 
[GenericsTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/GenericsTest.scala 
[SeqOfStringsTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/SeqOfStringsTest.scala 
[ListTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/SeqOfStringsTest.scala 
[ArrayBufferTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/SeqOfStringsTest.scala 
[CompanionObjectTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/CompanionObjectTest.scala 
[MapTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/MapTest.scala 
[EnvironmentVarTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/EnvironmentVarTest.scala 
[FirstClassFuncTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/FirstClassFuncTest.scala 
[TryCatchTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/TryCatchTest.scala 
[RequireTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/CompanionObjectTest.scala 
[NetworkService.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/concurrency/NetworkService.scala
[ThreadTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/concurrency/ThreadTest.scala
[CountDownLatchTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/concurrency/CountDownLatchTest.scala
[CyclicBarrierTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/concurrency/CyclicBarrierTest.scala

## To build and generate jar. In sbt console type:
	
	package
## To run. In sbt console type:
	
	run
## To solve library dependencies in eclipse. In sbt console type:

    reload
    eclipse with-source=true
