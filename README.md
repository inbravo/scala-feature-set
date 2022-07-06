[![Codacy Badge](https://api.codacy.com/project/badge/Grade/507e7b65e6794888b4a89a6682db0287)](https://www.codacy.com/app/inbravo/scala-feature-set?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=inbravo/scala-feature-set&amp;utm_campaign=Badge_Grade)
[![GitPitch](https://gitpitch.com/assets/badge.svg)](https://gitpitch.com/inbravo/scala-feature-set/master?grs=github&t=white)


## Some useful Scala examples

### Language constructs

#### Hello World
-  [Hello World with main method][HelloWorld.md]
-  [Hello World without main method][HelloWorldWithoutMain.md]

#### Common Keywords
-  [Usage of 'import' to import classes][ImportTest.md]
-  [Usage of 'tuple' to build abstractions over related values][TupleTest.md]
-  [Usage of 'yield' in extracting values during loops][YieldTest.md]
-  [Usage of 'isInstanceOf'][InstanceOfTest.md]
-  [Usage of 'try' 'catch'][TryCatchTest.md]
-  [Usage of 'require' to enforce restrictions before creating instance of a Scala class][RequireTest.md]
-  [Usage of 'tailrec' during recursions in methods][FactorialTest.md]
-  [Usage of keyword '++' in collections][StringsTest.md]
-  [Usage of 'Either' as return types][EitherTest.md]
-  [Usage of '@inline' as performance optimizer][MethodInlineTest.md]

#### Basic Constructs: trait, class, object, annotations
-  [Java 'Object' is equivalent to Scala 'AnyRef'][VarArgsTest.md]
-  [Java 'void' is equivalent to Scala 'Unit'][MathOpsTest.md]
-  [Java 'enum' is equivalent to Scala 'sealed trait'][SealedTraitTest.md]
-  [Java 'interface' is equivalent to Scala 'trait'][MultipleTraitTest.md]
-  [Purpose of trait, class and Object keywords in Scala][ClassObjectTest.md]
-  ["Hello"(4) is actually "Hello".apply(4)][ApplyMethodTest.md]
-  [Create custom annotations using 'scala.annotation.StaticAnnotation'][AnnotationTest.md]
-  [The 'App' trait can be used to quickly turn objects into executable programs][EitherTest.md]

#### Var, Val, Int, Float, Double, BigInteger
-  [Various Scala types][ValuesTest.md]
-  [Values which are lazy initialised using 'lazy val'][LazyValTest.md]
-  [BigInt("1234567890") is actually BigInt.apply("1234567890")][MathOpsTest.md]

#### Looping
-  [Different types of looping techniques][LoopTest.md]
-  [Usage of 'for each' as loop][ForEachTest.md]

#### Methods/Functions
-  [How methods or definitions are created using 'def'][MethodTest.md]
-  [How object-private access works][ObjectPrivateAccess.md]
-  [How definitions can also be created using 'var' or 'val'][VarAndValTest.md]
-  [Type aliases in Scala][TypeAliasTest.md]
-  [Never use 'return' keyword in Scala method][AvoidReturnTest.md]
-  [A function without a return type is called Procedure in Scala][ProcedureTest.md]
-  [Example of a function that can take a variable number of arguments][VarArgsTest.md]
-  [Difference between call by name and call by value][CallByNameAndValueTest.md]
-  [Methods 'apply' as Injector and 'unapply' as Extractor][ObjectExtractorTest.md]
-  [Operators are nothing just methods. Operator overloading example][OperatorsAreMethods.md]

#### Collection
-  [Usage of 'Seq[String]' in Scala][SeqOfStringsTest.md]
-  [Usage of 'List' and 'Vector' in Scala][ListTest.md]
-  [Usage of 'ArrayBuffer' in Scala][ArrayBufferTest.md]
-  [Usage of WeakHashMap in Scala][WeakHashMapTest.md]
-  [Different operations on List class][ListOperationsTest.md]
-  [Scala Array that can store all object types][AnyValTest.md]
-  [Equivalent of Java 'ArrayList' Class in Scala is 'ArrayBuffer'][ArrayBufferTest.md]

#### Others
-  [How Scala beans works : Half a line of Scala is the equivalent of seven lines of Java][PrimaryConstructorTest.md]
-  [Primary constructor][PrimaryConstructorTest.md]
-  [Auxiliary constructors][AuxiliaryConstructorsTest.md]
-  [Difference between private and private[this]][ObjectPrivateAccess.md]
-  [Value '_' initializes to default value of variable][MutatorTest.md]
-  [How getter/setter is automatically generated in a class][MutatorTest.md]
-  [How Scala avoids NullPointerException using 'Option', 'Some' and 'None'][SomeNoneOptionTest.md]
-  [Default object factory in Scala][ObjectFactoryTest.md]
-  [Using 'strip margin' to add new lines in string][CustomerRestService.md]
-  [Generics example][GenericsTest.md]
-  [Enviornment variables example][EnvironmentVarTest.md]
-  [How to find object hashcode in Scala][HashCodeTest.md]
-  [How to view bounds works in Scala][ViewBoundTest.md]
-  [How to upper and lower type bounds works in Scala][TypeBoundTest.md]

#### Functional constructs
-  [Companion objects][CompanionObjectTest.md]
-  [Partial applied functions][PartialAppliedFuncTest.md]
-  [Currying][CurryingTest.md]
-  [Type inference and ascription][TypeAscriptionInferenceTest.md]
-  [First class functions][FirstClassFuncTest.md]
-  [High order functions][HighOrderFunctionTest.md] 

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
-  [Verify all HTTP URLs of a markdown file][MdFileLinksTest.md]
-  [Test for Anagram String in Scala][Anagram.md]
-  [Counter number of words per String in Scala][WordFrequency.md]
-  [Program to give runtime size of all primitive variables][PrimitiveVarsSizeTest.md]

#### Data structures
-  [A Stack implemented in Scala][Stack.md]
-  [Reverse a word using a stack in Scala][ReverseTheWord.md]
-  [A Queue implemented in Scala][Queue.md]
-  [A Circular Queue implemented in Scala][CircularQueue.md]

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
-  [Program to show hive connection][SparkHiveTest.md]

## How to build and configure
### To solve library dependencies in eclipse ([sbteclipse plugin required][Using-sbteclipse.md]), in sbt console type: 
    eclipse with-source=true
 
### To build, in sbt console type:
    package


[Using-sbteclipse.md]: https://github.com/typesafehub/sbteclipse/wiki/Using-sbteclipse

[HelloWorld.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/HelloWorld.scala
[HelloWorldWithoutMain.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/HelloWorldWithoutMain.scala
[VarArgsTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/VarArgsTest.scala
[ClassObjectTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/ClassObjectTest.scala
[ValuesTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/ValuesTest.scala
[TypeAliasTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/TypeAliasTest.scala
[VarArgsTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/VarArgsTest.scala
[ObjectExtractorTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/ObjectExtractorTest.scala
[AnyValTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/AnyValTest.scala
[HashCodeTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/HashCodeTest.scala
[ViewBoundTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/ViewBoundTest.scala
[TypeBoundTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/TypeBoundTest.scala
[PartialAppliedFuncTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/PartialAppliedFuncTest.scala
[CurryingTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/CurryingTest.scala
[TypeAscriptionInferenceTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/TypeAscriptionInferenceTest.scala
[FirstClassFuncTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/FirstClassFuncTest.scala
[HighOrderFunctionTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/HighOrderFunctionTest.scala
[AvoidReturnTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/AvoidReturnTest.scala
[VarAndValTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/VarAndValTest.scala
[MethodTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/MethodTest.scala
[ArrayBufferTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/ArrayBufferTest.scala
[ProcedureTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/ProcedureTest.scala
[AnnotationTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/AnnotationTest.scala
[MutatorTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/MutatorTest.scala
[SomeNoneOptionTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/SomeNoneOptionTest.scala
[EitherTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/EitherTest.scala  
[LoopTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/LoopTest.scala  
[MultipleTraitTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/MultipleTraitTest.scala  
[SealedTraitTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/SealedTraitTest.scala 
[TupleTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/TupleTest.scala 
[ForEachTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/ForEachTest.scala 
[YieldTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/ForEachTest.scala 
[ObjectFactoryTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/ObjectFactoryTest.scala 
[ImportTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/ImportTest.scala 
[InstanceOfTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/InstanceOfTest.scala 
[PrimaryConstructorTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/PrimaryConstructorTest.scala
[AuxiliaryConstructorsTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/AuxiliaryConstructorsTest.scala
[ObjectPrivateAccess.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/ObjectPrivateAccess.scala
[CallByNameAndValueTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/CallByNameAndValueTest.scala
[MethodInlineTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/MethodInlineTest.scala
[GenericsTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/GenericsTest.scala 
[StringsTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/StringsTest.scala 
[SeqOfStringsTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/SeqOfStringsTest.scala 
[ListTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/SeqOfStringsTest.scala
[ListOperationsTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/ListOperationsTest.scala
[MathOpsTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/MathOpsTest.scala  
[ApplyMethodTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/ApplyMethodTest.scala
[ArrayBufferTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/SeqOfStringsTest.scala 
[CompanionObjectTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/CompanionObjectTest.scala 
[MapTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/MapTest.scala 
[EnvironmentVarTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/EnvironmentVarTest.scala 
[TryCatchTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/TryCatchTest.scala 
[RequireTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/CompanionObjectTest.scala
[OperatorsAreMethods.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/OperatorsAreMethods.scala 
[NetworkService.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/concurrency/NetworkService.scala
[JDBCTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/jdbc/JDBCTest.scala
[ThreadTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/concurrency/ThreadTest.scala
[CountDownLatchTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/concurrency/CountDownLatchTest.scala
[CyclicBarrierTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/concurrency/CyclicBarrierTest.scala
[FactorialTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/number/FactorialTest.scala
[LazyValTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/LazyValTest.scala
[Anagram.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/string/Anagram.scala
[MdFileLinksTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/net/MdFileLinksTest.scala
[WordFrequency.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/string/WordFrequency.scala
[Stack.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/ds/stack/Stack.scala
[ReverseTheWord.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/ds/stack/ReverseTheWord.scala
[Queue.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/ds/queue/Queue.scala
[CircularQueue.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/ds/queue/CircularQueue.scala
[PrimitiveVarsSizeTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/memory/PrimitiveVarsSizeTest.scala
[FinagleHttpService.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/finagle/FinagleHttpService.scala
[WeakHashMapTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/lang/ref/WeakHashMapTest.scala
[SparkWordCount.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/spark/SparkWordCount.scala
[SparkRDDTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/spark/SparkRDDTest.scala
[SparkDFTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/spark/SparkDFTest.scala
[SparkDSTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/spark/SparkDSTest.scala
[SparkTestFileTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/spark/SparkTestFileTest.scala
[SocketWordCount.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/spark/SocketWordCount.scala
[KryoEncodingTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/spark/KryoEncodingTest.scala
[SparkHiveTest.md]: https://github.com/inbravo/scala-feature-set/blob/master/src/main/scala/com/inbravo/spark/SparkHiveTest.scala
