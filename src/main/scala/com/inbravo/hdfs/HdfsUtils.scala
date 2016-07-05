package com.inbravo.hdfs

object HdfsUtils {

  /**
   * Create a file
   */
  def create(hdfsFile: String, hdfsServiceURL: String) = {

    println("Creating file: " + hdfsFile + ", at: " + hdfsServiceURL)

    /* Get Hadoop configuration */
    val hadoopConf = new org.apache.hadoop.conf.Configuration()
    val hdfs = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(hdfsServiceURL), hadoopConf)

    /* Delete the file */
    try { hdfs.create(new org.apache.hadoop.fs.Path(hdfsFile), true) } catch { case _: Throwable => { println("Error while creating Hadoop file") } }
  }

  /**
   * Delete a file
   */
  def delete(hdfsFile: String, hdfsServiceURL: String) = {

    println("Deleting file: " + hdfsFile + ", from: " + hdfsServiceURL)

    /* Get Hadoop configuration */
    val hadoopConf = new org.apache.hadoop.conf.Configuration()
    val hdfs = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(hdfsServiceURL), hadoopConf)

    /* Delete the file */
    try { hdfs.delete(new org.apache.hadoop.fs.Path(hdfsFile), true) } catch { case _: Throwable => { println("Error while deleting Hadoop file") } }
  }
}