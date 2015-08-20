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

object AjaxUrl {
  def render = {
    var url = ""
    "#url" #> SHtml.text(url, url = _)
    //"#short" #> SHtml.text(() => addUrl(url))
    "#short *" #> "test"
    "#shorten [onclick]" #> SHtml.ajaxInvoke(() => addUrl(url))
  }

  def addUrl(url: String) {
     S.notice(HashUrl("rest"))
  }
}
