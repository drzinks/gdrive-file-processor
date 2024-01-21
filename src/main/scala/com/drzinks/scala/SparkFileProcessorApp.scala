package com.drzinks.scala

import org.apache.spark.sql.{DataFrame, Row, SparkSession}

import java.io.File

class SparkFileProcessorApp {

  def processFile(file: File) : Unit = {
    val sparkSession = SparkSession.builder()
      .master("local[1]")
      .appName("spark-file-processor")
      .getOrCreate();

    val df = sparkSession
      .read
      .option("header","true")
      .csv(file.getPath)
    
      filterTransformations(df)
//    df.show(10,100,false)
//    printFileContent(file)
  }

  private def filterTransformations(df: DataFrame): Unit = {
    df.filter(row => row.getString(7).equalsIgnoreCase("textiles")).show(10,100,false) //Row => boolean
    df.filter(df("Country") === "Poland").show(10,100,false) //condition: Column
    df.filter("Founded == '1990'").show(false) //conditionExpr: String
  }

  private def printFileContent(file: File): Unit = {
    val source = scala.io.Source.fromFile(file)
    val lines = try source.mkString finally source.close
    println(lines)
  }
}
