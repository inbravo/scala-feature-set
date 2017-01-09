### Some useful Scala examples

#### Language constructs
-  [Create custom annotations using 'scala.annotation.StaticAnnotation'] [AnnotationTest.md]
-  [Value '_' initializes to default value of variable. Default accessor and mutator methods in an object] [MutatorTest.md]
-  ["Hello"(4) is actually "Hello".apply(4)] [MathOpsTest.md]
-  [BigInt("1234567890") is actually BigInt.apply("1234567890")] [MathOpsTest.md]
-  [The 'void' type is 'Unit'. Technically 'void' has no value whereas 'Unit' has one value that signifies 'no value'] [MathOpsTest.md]
-  [Usage of companion object in Scala] [CompanionObjectTest.md]
-  [Generics in Scala] [GenericsTest.md]
-  [Enviornment variables in Scala] [EnvironmentVarTest.md]
-  [First class functions in Scala] [FirstClassFuncTest.md]
-  [Using 'strip margin' to add new lines in a Scala string][CustomerRestService.md]
-  [Use of 'Either' as return types] [EitherTest.md]
-  [Different types of looping techniques in Scala] [LoopTest.md]
-  [Usage of 'for each' as loop] [ForEachTest.md]
-  [Keyword 'trait' in Scala is like 'interface' in Java] [MultipleTraitTest.md]
-  [Keyword 'sealed trait' in Scala is like 'enum' in Java] [SealedTraitTest.md]
-  [Use 'tuple' to build abstractions over related values] [TupleTest.md]
-  [Usage of 'yield' in extracting values during loops] [YieldTest.md]
-  [Default object factory in Scala] [ObjectFactoryTest.md]
-  [Usage of 'import' in Scala] [ImportTest.md]
-  [Usage of 'isInstanceOf' in Scala] [InstanceOfTest.md]
-  [Usage of 'try' 'catch' in Scala] [TryCatchTest.md]
-  [Usage of 'require' to enforce restrictions before creating instance of a Scala class] [RequireTest.md]
-  [Usage of 'tailrec' during recursions in Scala][FactorialTest.md]
-  [Usage of 'lazy val' in Scala][LazyValTest.md]
-  [Program to give runtime size of all primitive variables in Scala][PrimitiveVarsSizeTest.md]
-  [Usage of keyword '++' in Scala] [StringsTest.md]
-  [Operators are nothing just methods. Operator overloading example] [OperatorsAreMethods.md]
-  [Function that can take a variable number of arguments] [VarArgsTest.md]

#### Collection
-  [Usage of 'Seq[String]' in Scala] [SeqOfStringsTest.md]
-  [Usage of 'List' and 'Vector' in Scala] [ListTest.md]
-  [Usage of 'ArrayBuffer' in Scala] [ArrayBufferTest.md]
-  [Usage of WeakHashMap in Scala][WeakHashMapTest.md]

#### Socket
-  [Usage of 'ServerSocket' in Scala][NetworkService.md]

#### Concurrency
-  [Creating a 'Thread' in Scala][ThreadTest.md]
-  [Usage of thread pool based concurrency in Scala][NetworkService.md]
-  [Object synchronization in Scala][WeakHashMapTest.md]
-  [Usage of 'CountDownLatch' in Scala][CountDownLatchTest.md]
-  [Usage of 'CyclicBarrier' is in Scala][CyclicBarrierTest.md]

#### Useful programs
-  [Test for Anagram String in Scala][Anagram.md]
-  [Counter number of words per String in Scala][WordFrequency.md]

#### Data structures
-  [A Stack implemented in Scala][Stack.md]
-  [Reverse a word using a stack in Scala][ReverseTheWord.md]
-  [A Queue implemented in Scala][Queue.md]
-  [A Circular Queue implemented in Scala][CircularQueue.md]

#### Akka
-  [A simple Akka Actor][HelloActor.md]
-  [A Ping Pong program using Akka Actors][PingPongTest.md]
-  [A simple HTTP service in Scala using Akka][SimpleHttpService.md]
-  [A simple REST web service in Scala using Akka][CustomerRestService.md]

#### Spark 
-  [Program to count 'words per statement'][SparkWordCount.md]
-  [Program to count 'words per statement', arrived on network socket][SocketWordCount.md]
-  [Program to show case RDD operations][SparkRDDTest.md]
-  [Program to show case DataFrame operations][SparkDFTest.md]
-  [Program to show case DataSet operations][SparkDSTest.md]
-  [Program to show various operations on Data retrieved from File][SparkTestFileTest.md]
-  [Program to show Kryo based serialization][KryoEncodingTest.md]

[VarArgsTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/VarArgsTest.scala
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
[StringsTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/StringsTest.scala 
[SeqOfStringsTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/SeqOfStringsTest.scala 
[ListTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/SeqOfStringsTest.scala
[MathOpsTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/MathOpsTest.scala  
[ArrayBufferTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/SeqOfStringsTest.scala 
[CompanionObjectTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/CompanionObjectTest.scala 
[MapTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/MapTest.scala 
[EnvironmentVarTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/EnvironmentVarTest.scala 
[FirstClassFuncTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/FirstClassFuncTest.scala 
[TryCatchTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/TryCatchTest.scala 
[RequireTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/CompanionObjectTest.scala
[OperatorsAreMethods.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/OperatorsAreMethods.scala 
[NetworkService.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/concurrency/NetworkService.scala
[ThreadTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/concurrency/ThreadTest.scala
[CountDownLatchTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/concurrency/CountDownLatchTest.scala
[CyclicBarrierTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/concurrency/CyclicBarrierTest.scala
[FactorialTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/number/FactorialTest.scala
[LazyValTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/LazyValTest.scala
[Anagram.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/string/Anagram.scala
[WordFrequency.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/string/WordFrequency.scala
[Stack.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/ds/stack/Stack.scala
[ReverseTheWord.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/ds/stack/ReverseTheWord.scala
[Queue.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/ds/queue/Queue.scala
[CircularQueue.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/ds/queue/CircularQueue.scala
[PrimitiveVarsSizeTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/memory/PrimitiveVarsSizeTest.scala
[HelloActor.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/akka/basic/HelloActor.scala
[PingPongTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/akka/basic/PingPongTest.scala
[SimpleHttpService.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/akka/http/SimpleHttpService.scala
[CustomerRestService.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/akka/http/CustomerRestService.scala
[WeakHashMapTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/ref/WeakHashMapTest.scala
[SparkWordCount.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/spark/SparkWordCount.scala
[SparkRDDTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/spark/SparkRDDTest.scala
[SparkDFTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/spark/SparkDFTest.scala
[SparkDSTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/spark/SparkDSTest.scala
[SparkTestFileTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/spark/SparkTestFileTest.scala
[SocketWordCount.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/spark/SocketWordCount.scala
[KryoEncodingTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/spark/KryoEncodingTest.scala