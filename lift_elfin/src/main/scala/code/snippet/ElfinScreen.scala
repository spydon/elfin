package code
package snippet

import net.liftweb._
import net.liftweb.util._
import Helpers._
import http._
import code.HashUrl

object ElfinScreen extends LiftScreen {
  val url = field("Url", "", trim, valMinLen(1, "Enter URL"))
  val length = field("Key length", 6, minVal(5, "Too short"), maxVal(50, "Too long"))

  def finish() {
    val fullUrl = (url.contains("://")) ? url.toString | "http://" + url
    val shortUrl = S.hostName + "/" + HashUrl(fullUrl, length)
    S.notice(<a href={"http://" + shortUrl}>{shortUrl}</a>)
  }
}
