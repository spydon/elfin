import util.hashing.MurmurHash3._
import code.HashUrl

object HashUrlTest {
  def randomStringFromCharList(length: Int, chars: Seq[Char]): String = {
    val sb = new StringBuilder
      for (i <- 1 to length) {
        val randomNum = util.Random.nextInt(chars.length)
        sb.append(chars(randomNum))
      }
    sb.toString
  }

  def randomAlphaNumericString(length: Int): String = {
    val chars = ('a' to 'z') ++ ('A' to 'Z') ++ ('0' to '9') ++ List('/', '#', ':')
    randomStringFromCharList(length, chars)
  }

  def test(tested: Set[String] = Set(), strings: Set[String] = Set(), iterations: Int = 0): (Int, String) = {
    val random = randomAlphaNumericString((Math.random()*50).toInt)
    val encoded = HashUrl(random, 5)
    if (tested(encoded) && !strings(random))
      (iterations, encoded)
    else
      test(tested + encoded, strings + random, iterations+1)
  }

  def main(args: Array[String]) {
    println(test())
  }
}

