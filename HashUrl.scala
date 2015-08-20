import util.hashing.MurmurHash3._

class HashUrl {
  // 70 safe characters to use for URL's
  // Should still work if language is extended or reduced
  val alpha: List[Char] = ('a' to 'z').toList :::
                          ('A' to 'Z').toList :::
                          ('0' to '9').toList :::
                          List('$', '_', '.', '+', '*', '!', '(', ')').toList

  def apply(url: String, length: Int) = {
    encode(buildHash(url, length*2, stringSeed))
  }

  def buildHash(url: String, length: Int, seed: Int, hash: String = "") : String = {
    val fullHash = hash + Math.abs(stringHash(url, seed)).toString
    if (fullHash.length >= length)
      fullHash.substring(0, length)
    else
      buildHash(url, length, seed+1, fullHash)
  }

  // TODO: Transform to higher order function
  def encode(hash: String, chars: List[Char] = List()) : String = {
    hash match {
      case "" => chars.mkString
      case _ =>
        val splitHash = hash splitAt 2
        val encoded = alpha(splitHash._1.toInt%alpha.length)
        encode(splitHash._2, encoded :: chars)
    }
  }
}
