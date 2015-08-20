package code
package snippet

import net.liftweb._
import http._
import util._
import Helpers._

object Shorten {
  def results = ClearClearable andThen
    "li *" #> S.param("u"). // get the query parameter
    toList. // convert the Box to a List
    flatMap(q => {
        ("You asked: "+q) :: // prepend the query
        (1 to toInt(q)).toList.map(_.toString) // if it can be converted to an Int
        // convert it and return a sequence of Ints
        })
}
