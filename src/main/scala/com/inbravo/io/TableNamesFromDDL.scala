package com.inbravo.io

import scala.io.Source

object TableNamesFromDDL {

  def main(args: Array[String]): Unit = {

    val filename = "D:/work/work-documents/ilabs/presales-docs/presales-artifacts-history/[bfsi]-[amex]-[idw]-[cos-teradata-migration]/references/Hive_UDFs_DDLs_And_Scripts/Hive_UDFs_DDLs_And_Scripts/Hive_Table_And_View_DDLs.sql"

    for (line: String <- Source.fromFile(filename).getLines) {

      if (line.startsWith("CREATE VIEW if not exists"))
        
        println(line)
    }
  }
}