package code

import net.liftweb.http.rest.RestHelper
import net.liftweb.http._
import com.redis._

object Get extends RestHelper {
  val r = new RedisClient("localhost", 6379)

  serve {
    case Req(List(id), _, GetRequest) if id != "index" =>
      RedirectResponse(r.get(id).getOrElse("/"))
  }
}
