package code
package snippet

import net.liftweb.util._
import Helpers._
import net.liftweb._
import http._
import common._
import util.Helpers._
import js._
import JsCmds._
import JE._
import code.HashUrl
import scala.xml.NodeSeq
import scala.xml.Text

object AjaxUrl extends LiftScreen {
  val url = field("Url", "")
  val length = field("Length", 6, minVal(5, "Too short"))

  def finish() {
    val fullUrl = S.hostName + "/" + HashUrl(url, length)
    S.notice(<a href={fullUrl}>{fullUrl}</a>)
  }
}
