package tdd20180913

import org.scalatest.{FlatSpec, Matchers}

class UserSpec extends FlatSpec with Matchers {

  private val defaultUser = new User("Yamada", "Stanby", "stanby@gmail.com", "password")

  val dataTable = Seq(
    (defaultUser, "Stanby: Yamada OK"),
    (defaultUser.copy(password = "passwor"), "Stanby: Yamada NG"),
    (defaultUser.copy(name = "Tanaka", password = "passwor"), "Stanby: Tanaka NG"),
    (defaultUser.copy(campanyName = "BizReach"), "BizReach: Yamada OK"),
    (defaultUser.copy(campanyName = ""), "Yamada OK")
  )

  "パスワードが8文字以上のとき" should "user.hasValidPassword = true" in {
    val user = new User("Yamada", "Stanby", "stanby@gmail.com", "password")
    user.hasValidPassword shouldEqual true
  }

  "パスワードが7文字以下のとき" should "user.hasValidPassword = false" in {
    val user = new User("Yamada", "Stanby", "stanby@gmail.com", "passwor")
    user.hasValidPassword shouldEqual false
  }

  "署名" should "会社名: 名前 OK/NG" in {
    dataTable.foreach{
      case (user, expected) => user.getSign shouldEqual expected
    }
  }

}
