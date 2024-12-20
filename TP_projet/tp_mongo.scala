
import org.apache.spark.sql.SparkSession

object LoadDataToMongo {
  def main(args: Array[String]): Unit = {
    // Initialiser la session Spark
    val spark = SparkSession.builder()
      .appName("Load Data to MongoDB")
      .master("local[*]") // Utilise tous les cœurs disponibles pour exécution locale
      .config("spark.mongodb.write.connection.uri", "mongodb://localhost:27017/mydatabase.mycollection")
      .getOrCreate()

    // Lire les données depuis un fichier JSON
    val dataFrame = spark.read.format("json")
      .load("../../../ressource/nvdcve-1.1-2024.json")

    // Écrire les données dans MongoDB
    dataFrame.write.format("mongodb")
      .mode("overwrite")
      .save()

    spark.stop()
  }
}
