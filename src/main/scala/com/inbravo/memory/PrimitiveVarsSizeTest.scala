package com.inbravo.memory

import java.util.concurrent.TimeUnit;

/**
 * Add VM arguments before running: -javaagent:lib/object-explorer.jar -XX:+UseG1GC
 * -XX:ConcGCThreads=2 -XX:+UnlockExperimentalVMOptions -verbosegc -XX:G1LogLevel=finest
 * 
 * amit.dixit
 */
object PrimitiveVarsSizeTest {

  def main(args: Array[String]) = {

    println("==========================================================================================================================");
    println("[*] Total Object Memory: [OBJECT META INFO] + [OBJECT DATA]");
    println("[*] [OBJECT META DATA]: [CLASS INFO = 4 bytes] + [FLAGS = 4 bytes] + [LOCK INFO = 4 bytes]");
    println("[*] Total Object Memory: [12 bytes] + [OBJECT DATA]");
    println("[*] [OBJECT DATA]: Size of all fields in Object");
    println("[*] Default Size: 'byte': 1 byte, 'char': 2 bytes, 'int'/'float': 4 bytes, 'long'/'double': 8 bytes");
    println("[*] Even if the data member is a byte, it will still take up 4 bytes!");
    println("[*] JVM takes minimum 4 bytes by default");

    var byteClass = new ByteClass("0".toByte)
    var booleanClass = new BooleanClass(true)
    var shortClass = new ShortClass("0".toByte)
    var charClass = new CharClass('0')
    var intClass = new IntClass(5)
    var longClass = new LongClass(5)
    var floatClass = new FloatClass(5)
    var doubleClass = new DoubleClass(5)

    println("==========================================================================================================================");

    while (true) {

      /* Sleep for 10 seconds */
      TimeUnit.SECONDS.sleep(10);

      /* Call GC */
      System.gc();
    }
  }
}

/* Actual memory consumption = 16 bytes (12 bytes meta info + 4 byte for a 'char') */
class CharClass(ch: Char) {

  /* 2 bytes */
  var ch: Char = _
}

/* Actual memory consumption = 16 bytes (12 bytes meta info + 4 byte for a 'boolean') */
class BooleanClass(bool: Boolean) {

  /* 1 byte */
  var bool: Boolean = _
}

/* Actual memory consumption = 16 bytes (12 bytes meta info + 4 byte for a 'byte') */
class ByteClass(number: Byte) {

  var number: Byte = _
}

/* Actual memory consumption = 16 bytes (12 bytes meta info + 4 byte for a 'short') */
class ShortClass(number: Short) {

  var number: Short = _
}

/* Actual memory consumption = 16 bytes (12 bytes meta info + 4 byte for a 'int') */
class IntClass(number: Int) {

  var number: Int = _
}

/* Actual memory consumption = 24 bytes (12 bytes meta info + 12 byte for a 'long') */
class LongClass(number: Long) {

  var number: Long = _
}

/* Actual memory consumption = 16 bytes (12 bytes meta info + 4 byte for a 'float') */
class FloatClass(number: Float) {

  var number: Float = _
}

/* Memory consumption = 24 bytes (12 bytes meta info + 12 byte for a 'double') */
class DoubleClass(number: Double) {

  var number: Double = _
}
