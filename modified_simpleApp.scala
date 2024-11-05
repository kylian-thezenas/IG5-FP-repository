// Databricks notebook source
      val logFile = "/FileStore/tables/README.md" 
      val logData = spark.read.textFile(logFile).cache()

      val numAs = logData.filter(line => line.contains("Scala")).count()
      val numBs = logData.filter(line => line.contains("Spark")).count()

      println(s"Lines with Scala: $numAs, Lines with Spark: $numBs")

// COMMAND ----------

import org.apache.spark.sql.types.{IntegerType, StringType, StructType}

val logFile = "/FileStore/tables/Stackoverflow"

// Define schema
val schema = new StructType()
  .add("postTypeId", IntegerType, nullable = true)
  .add("id", IntegerType, nullable = true)
  .add("acceptedAnswer", StringType, nullable = true)
  .add("parentId", IntegerType, nullable = true)
  .add("score", IntegerType, nullable = true)
  .add("tag", StringType, nullable = true)

// Read data using defined schema
val df = spark.read
  .option("header", "false")
  .schema(schema)
  .csv(logFile)
  .cache()  // Cache the DataFrame

// Drop the 'acceptedAnswer' column
val processedDf = df.drop("acceptedAnswer")

// Show the number of records, the schema, and the first 5 records
println(s"\nCount of records in CSV file: ${processedDf.count()}")
processedDf.printSchema()
processedDf.show(5)

// COMMAND ----------

println("\n count tag null: " + df.filter($"tag".isNull).count + "\n count parentId null: " + df.filter($"parentId".isNull).count)
