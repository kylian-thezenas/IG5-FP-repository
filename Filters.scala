import scala.io.Source
import play.api.libs.json._

object FilterUsers {
  def main(args: Array[String]): Unit = {
    val jsonFile = "data.json"
    val jsonData = Source.fromFile(jsonFile).getLines().mkString

    val parsedJson = Json.parse(jsonData)

    parsedJson match {
      case JsArray(users) =>
   
        val filteredUsers = users.filter { user =>
          (user \ "age").asOpt[Int].exists(_ > 25)
        }

        filteredUsers.foreach { user =>
          println(Json.prettyPrint(user))
        }

      case _ =>
        println("Le fichier JSON ne contient pas un tableau valide.")
    }
  }
}
