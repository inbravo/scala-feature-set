package com.inbravo.jdbc

import java.sql.DriverManager
import java.sql.Connection
/**
 * Program to test JDBC
 * amit.dixit
 *
 */
object JDBCTest {

  def main(args: Array[String]) {

    /* Connect to the database on the localhost */
    val driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
    val url = "jdbc:sqlserver://192.168.218.20:1433;" + "xopenStates=false;" + "sendTimeAsDatetime=true;" + "trustServerCertificate=false;" + "sendStringParametersAsUnicode=true;" + "selectMethod=direct;" + "responseBuffering=adaptive;" + "packetSize=8000;" + "loginTimeout=30;" + "lockTimeout=-1;" + "lastUpdateCount=true;" + "encrypt=false;" + "disableStatementPooling=true;" + "databaseName=BCHN;" + "applicationName=Microsoft SQL Server JDBC Driver;"
    val username = "sa"
    val password = "Impetus@123#"

    var connection: Connection = null

    try {

      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      /* Create the statement, and run the select query */
      val resultSet = connection.createStatement.executeQuery("SELECT host, user FROM user")

      while (resultSet.next) {

        println("host, user = " + resultSet.getString("host") + ", " + resultSet.getString("user"))
      }

    } catch {
      case e: Throwable => e.printStackTrace
    }
    if (connection != null) {
      connection.close
    }
  }
}