package com.inbravo.hdfs

object HdfsUtils {

  var hdfsServiceURL: String = "hdfs://localhost:9000"

  /**
   * Delete a file
   */
  def delete(hdfsFile: String, hdfsServiceURL: String) = {

    println("Cleaning the file: " + hdfsFile + " @ hdfsServiceURL: " + hdfsServiceURL)

    /* Get Hadoop configuration */
    val hadoopConf = new org.apache.hadoop.conf.Configuration()
    val hdfs = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(hdfsServiceURL), hadoopConf)
    
    /* Delete the file */
    try { hdfs.delete(new org.apache.hadoop.fs.Path(hdfsFile), true) } catch { case _: Throwable => { println("Error while deleting Hadoop file") } }
  }
}