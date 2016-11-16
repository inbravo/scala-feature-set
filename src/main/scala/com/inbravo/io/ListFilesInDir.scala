package com.inbravo.io

import java.io.File
/**
 * amit.dixit
 */
object ListFilesInDir {

  def recursiveListFiles(f: File): Array[File] = {

    /* List all files */
    val these = f.listFiles

    /* Filter out all directories */
    these ++ these.filter(_.isDirectory).flatMap(recursiveListFiles)
  }

  def main(args: Array[String]): Unit = {

    val files = recursiveListFiles(new File("D://personal//mygithub//aniket-docs//class-six//maths"));
    println(files.foreach { x => println(x.getName) });
  }
}