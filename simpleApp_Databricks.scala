// Databricks notebook source
      val logFile = "/FileStore/tables/README.md" 
      val logData = spark.read.textFile(logFile).cache()

      val numAs = logData.filter(line => line.contains("Scala")).count()
      val numBs = logData.filter(line => line.contains("Spark")).count()

      println(s"Lines with Scala: $numAs, Lines with Spark: $numBs")
