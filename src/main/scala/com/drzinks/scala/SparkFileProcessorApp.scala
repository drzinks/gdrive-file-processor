package com.drzinks.scala

import org.apache.spark.sql.SparkSession

import java.io.File

class SparkFileProcessorApp {

  def processFile(file: File) : Unit = {
    val sparkSession = SparkSession.builder()
      .master("local[1]")
      .appName("spark-file-processor")
      .getOrCreate();

    val df = sparkSession.read.csv(file.getPath)
    df.show(10,100,false)

//    printFileContent(file)
  }

  private def printFileContent(file: File): Unit = {
    val source = scala.io.Source.fromFile(file)
    val lines = try source.mkString finally source.close
    println(lines)
  }
}
