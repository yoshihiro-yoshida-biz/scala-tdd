package tdd20180913

case class User(name: String, campanyName: String, mailAddress: String, password: String) {
  def getSign: String = {
    val prefix = if (campanyName.isEmpty) "" else s"$campanyName: "
    val verifyResult = if (hasValidPassword) "OK" else "NG"
    prefix + name + " " + verifyResult
  }

  def hasValidPassword: Boolean = {
    password.length >= 8
  }


}
