package tdd20180913

import org.scalatest.{FlatSpec, Matchers}

class UserSpec extends FlatSpec with Matchers {
  "氏名、会社名、メールアドレス、パスワード" should "あること" in {
    val user = new User("Yamada", "Stanby", "stanby@gmail.com", "password")
    user.name shouldEqual "Yamada"
    user.campanyName shouldEqual "Stanby"
    user.mailAddress shouldEqual "stanby@gmail.com"
    user.password shouldEqual "password"

//    Hello.greeting shouldEqual "hello"
  }

  val dataTable = Seq(
    (new User("Yamada", "Stanby", "stanby@gmail.com", "password"), "Stanby: Yamada OK"),
    (new User("Yamada", "Stanby", "stanby@gmail.com", "passwor"), "Stanby: Yamada NG")

  )

  "パスワード" should "8文字以上" in {
    val user = new User("Yamada", "Stanby", "stanby@gmail.com", "password")
    user.hasValidPassword shouldEqual true
  }

  "パスワード" should "7文字以下ときにエラーになる" in {
    val user = new User("Yamada", "Stanby", "stanby@gmail.com", "passwor")
    user.hasValidPassword shouldEqual false
  }

  "署名" should "返される" in {
    dataTable.foreach(t => {
      val user = t._1
      val expected = t._2
      user.getSign shouldEqual expected
    })
  }

  "会社名がないとき" should "氏名のみ表示される" in {
    val user = new User("Yamada", "", "stanby@gmail.com", "password")
    user.getSign shouldEqual "Yamada OK"
  }

}
