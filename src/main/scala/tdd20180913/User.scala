package tdd20180913

class User(val name: String, val campanyName: String, val mailAddress: String, val password: String) {
  def getSign: String = {
    if (!hasValidPassword) {
      "Stanby: Yamada NG"
    } else {
      if (campanyName.isEmpty) {
        "Yamada OK"
      } else {
        "Stanby: Yamada OK"
      }
    }
  }

  def hasValidPassword: Boolean = {
    password.length >= 8
  }


}
