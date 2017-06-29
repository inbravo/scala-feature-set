[![Codacy Badge](https://api.codacy.com/project/badge/Grade/507e7b65e6794888b4a89a6682db0287)](https://www.codacy.com/app/inbravo/scala-src?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=inbravo/scala-src&amp;utm_campaign=Badge_Grade)
[![GitPitch](https://gitpitch.com/assets/badge.svg)](https://gitpitch.com/inbravo/scala-src/master?grs=github&t=white)


### Some useful Scala examples

#### Language constructs
-  [Hello World with main method](https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/HelloWorld.scala)
-  [Hello World without main method](https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/HelloWorldWithoutMain.scala)
-  [Purpose of trait, class and Object keywords in Scala](https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/ClassObjectTest.scala)
-  [Java 'Object' is equivalent to Scala 'AnyRef'](https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/VarArgsTest.scala)
-  [Scala Array that can store all object types](https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/AnyValTest.scala)
-  [Various Scala types](https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/ValuesTest.scala)
-  [Type aliases in Scala](https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/TypeAliasTest.scala)
-  [never use 'return' keyword in Scala][AvoidReturnTest.md]
-  [How methods or definitions are created using 'def'][MethodTest.md]
-  [How definitions can also be created using 'var' or 'val'][VarAndValTest.md]
-  [Java 'void' is equivalent to Scala 'Unit'][MathOpsTest.md]
-  [Values which are lazy initialised using 'lazy val'][LazyValTest.md]
-  [Scala 'import' is richer than Java][ImportTest.md]
-  [Equivalent of Java 'interface' in Scala is 'trait'][MultipleTraitTest.md]
-  [Equivalent of Java 'sealed trait' in Scala is 'enum'][SealedTraitTest.md]
-  [Equivalent of Java 'ArrayList' Class in Scala is 'ArrayBuffer'][ArrayBufferTest.md]
-  [Usage of 'tuple' to build abstractions over related values][TupleTest.md]
-  [Usage of 'yield' in extracting values during loops][YieldTest.md]
-  [Usage of 'isInstanceOf'][InstanceOfTest.md]
-  [Usage of 'try' 'catch'][TryCatchTest.md]
-  [Usage of 'require' to enforce restrictions before creating instance of a Scala class][RequireTest.md]
-  [Usage of 'tailrec' during recursions in methods][FactorialTest.md]
-  [Usage of keyword '++' in collections][StringsTest.md]
-  [Usage of 'for each' as loop][ForEachTest.md]
-  [Usage of 'Either' as return types][EitherTest.md]
-  [How Scala beans works : Half a line of Scala is the equivalent of seven lines of Java][PrimaryConstructorTest.md]
-  [Primary constructor][PrimaryConstructorTest.md]
-  [Auxiliary constructors][AuxiliaryConstructorsTest.md]
-  [Difference between private and private[this]][ObjectPrivateAccess.md]
-  [Difference between call by name and call by value][CallByNameAndValueTest.md]
-  [How '@inline' works][MethodInlineTest.md]
-  [How object-private access works][ObjectPrivateAccess.md]
-  [Operators are nothing just methods. Operator overloading example][OperatorsAreMethods.md]
-  [A function without a return type is called Procedure in Scala][ProcedureTest.md]
-  [Example of a function that can take a variable number of arguments](https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/VarArgsTest.scala)
-  [Value '_' initializes to default value of variable][MutatorTest.md]
-  [How getter/setter is automatically generated in a class][MutatorTest.md]
-  [How Scala avoids NullPointerException using 'Option', 'Some' and 'None'][SomeNoneOptionTest.md]
-  [Default object factory in Scala][ObjectFactoryTest.md]
-  [Using 'strip margin' to add new lines in string][CustomerRestService.md]
-  [Different types of looping techniques][LoopTest.md]
-  [Companion objects][CompanionObjectTest.md]
-  [Generics example][GenericsTest.md]
-  [Enviornment variables example][EnvironmentVarTest.md]
-  [How to find object hashcode in Scala](https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/HashCodeTest.scala)
-  [How to view bounds works in Scala](https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/ViewBoundTest.scala)
-  [How to upper and lower type bounds works in Scala](https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/TypeBoundTest.scala)

### Functional constructs
-  [Partial applied functions](https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/PartialAppliedFuncTest.scala)
-  [Type inference and ascription](https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/TypeAscriptionInferenceTest.scala)
-  [First class functions](https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/FirstClassFuncTest.scala)
-  [Currying](https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/CurryingTest.scala)
-  [High order functions](https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/HighOrderFunctionTest.scala) 

#### Class and Methods
-  ["Hello"(4) is actually "Hello".apply(4)][ApplyMethodTest.md]
-  [Methods 'apply' as Injector and 'unapply' as Extractor](https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/ObjectExtractorTest.scala)
-  [BigInt("1234567890") is actually BigInt.apply("1234567890")][MathOpsTest.md]
-  [Create custom annotations using 'scala.annotation.StaticAnnotation'][AnnotationTest.md]
-  [The 'App' trait can be used to quickly turn objects into executable programs][EitherTest.md]

#### Collection
-  [Usage of 'Seq[String]' in Scala][SeqOfStringsTest.md]
-  [Usage of 'List' and 'Vector' in Scala][ListTest.md]
-  [Usage of 'ArrayBuffer' in Scala][ArrayBufferTest.md]
-  [Usage of WeakHashMap in Scala][WeakHashMapTest.md]
-  [Different operations on List class][ListOperationsTest.md]

#### Socket
-  [Usage of 'ServerSocket' in Scala][NetworkService.md]

#### SQL
-  [Data base connection in Scala][JDBCTest.md]

#### Concurrency
-  [Creating a 'Thread' in Scala][ThreadTest.md]
-  [Usage of thread pool based concurrency in Scala][NetworkService.md]
-  [Object synchronization in Scala][WeakHashMapTest.md]
-  [Usage of 'CountDownLatch' in Scala][CountDownLatchTest.md]
-  [Usage of 'CyclicBarrier' is in Scala][CyclicBarrierTest.md]

#### Useful programs
-  [Test for Anagram String in Scala][Anagram.md]
-  [Counter number of words per String in Scala][WordFrequency.md]
-  [Program to give runtime size of all primitive variables][PrimitiveVarsSizeTest.md]

#### Data structures
-  [A Stack implemented in Scala][Stack.md]
-  [Reverse a word using a stack in Scala][ReverseTheWord.md]
-  [A Queue implemented in Scala][Queue.md]
-  [A Circular Queue implemented in Scala][CircularQueue.md]

#### Akka
-  [A simple Akka Actor][HelloActor.md]
-  [A Ping Pong program using Akka Actors][PingPongTest.md]
-  [A simple HTTP service using Akka][SimpleHttpService.md]
-  [A simple REST web service using Akka][CustomerRestService.md]

#### Finagle
-  [A simple HTTP service using Finagle][FinagleHttpService.md]

#### Spark 
-  [Program to count 'words per statement'][SparkWordCount.md]
-  [Program to count 'words per statement', arrived on network socket][SocketWordCount.md]
-  [Program to show case RDD operations][SparkRDDTest.md]
-  [Program to show case DataFrame operations][SparkDFTest.md]
-  [Program to show case DataSet operations][SparkDSTest.md]
-  [Program to show various operations on Data retrieved from File][SparkTestFileTest.md]
-  [Program to show Kryo based serialization][KryoEncodingTest.md]

## How to build and configure
### To solve library dependencies in eclipse ([sbteclipse plugin required][Using-sbteclipse.md]), in sbt console type: 
    eclipse with-source=true
 
### To build, in sbt console type:
    package


[Using-sbteclipse.md]: https://github.com/typesafehub/sbteclipse/wiki/Using-sbteclipse
[AvoidReturnTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/AvoidReturnTest.scala
[VarAndValTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/VarAndValTest.scala
[MethodTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/MethodTest.scala
[ArrayBufferTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/ArrayBufferTest.scala
[ProcedureTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/ProcedureTest.scala
[AnnotationTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/AnnotationTest.scala
[MutatorTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/MutatorTest.scala
[SomeNoneOptionTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/SomeNoneOptionTest.scala
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
[PrimaryConstructorTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/PrimaryConstructorTest.scala
[AuxiliaryConstructorsTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/AuxiliaryConstructorsTest.scala
[ObjectPrivateAccess.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/ObjectPrivateAccess.scala
[CallByNameAndValueTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/CallByNameAndValueTest.scala
[MethodInlineTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/MethodInlineTest.scala
[GenericsTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/GenericsTest.scala 
[StringsTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/StringsTest.scala 
[SeqOfStringsTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/SeqOfStringsTest.scala 
[ListTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/SeqOfStringsTest.scala
[ListOperationsTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/ListOperationsTest.scala
[MathOpsTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/MathOpsTest.scala  
[ApplyMethodTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/ApplyMethodTest.scala
[ArrayBufferTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/SeqOfStringsTest.scala 
[CompanionObjectTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/CompanionObjectTest.scala 
[MapTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/MapTest.scala 
[EnvironmentVarTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/EnvironmentVarTest.scala 
[TryCatchTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/TryCatchTest.scala 
[RequireTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/CompanionObjectTest.scala
[OperatorsAreMethods.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/OperatorsAreMethods.scala 
[NetworkService.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/concurrency/NetworkService.scala
[JDBCTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/jdbc/JDBCTest.scala
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
[FinagleHttpService.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/finagle/FinagleHttpService.scala
[CustomerRestService.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/akka/http/CustomerRestService.scala
[WeakHashMapTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/lang/ref/WeakHashMapTest.scala
[SparkWordCount.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/spark/SparkWordCount.scala
[SparkRDDTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/spark/SparkRDDTest.scala
[SparkDFTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/spark/SparkDFTest.scala
[SparkDSTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/spark/SparkDSTest.scala
[SparkTestFileTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/spark/SparkTestFileTest.scala
[SocketWordCount.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/spark/SocketWordCount.scala
[KryoEncodingTest.md]: https://github.com/inbravo/scala-src/blob/master/src/main/scala/com/inbravo/spark/KryoEncodingTest.scala
