package pmsoft.scala.game.impli

import org.scalatest.{Matchers, FunSuite}


/**
 * Date: 2014-09-06
 */
class SimpleDirectImplicitTest extends FunSuite with Matchers {

  test("Direct implicit conversion - in scope") {
    import scala.language.implicitConversions
    implicit def localBaseToView(base: BaseSimple) = new ShowImplicitObject("here local")
    val base = new BaseSimple
    base.whereYouAre should be eq ("here local")
  }

  test("Direct implicit conversion - Explicit import") {
    import SimpleDirectImplicit.baseToView
    val base = new BaseSimple
    base.whereYouAre should be eq ("SimpleDirectImplicit.baseToView")
  }

  test("Direct implicit conversion - Wildcard import") {
    import SimpleDirectImplicit._
    val base = new BaseSimple
    base.whereYouAre should be eq ("SimpleDirectImplicit.baseToView")
  }

  test("Direct implicit parameter - in scope") {
    implicit val param = new ShowImplicitObject("in local scope")
    SimpleDirectImplicit.showImplicitParameterUse() should be eq ("in local scope")
  }

  test("Direct implicit parameter - Explicit import") {
    import SimpleDirectImplicit.aObjectImplicitInstance
    SimpleDirectImplicit.showImplicitParameterUse() should be eq ("SimpleDirectImplicit.aObjectImplicitInstance")
  }

  test("Direct implicit parameter - Wildcard import") {
    import SimpleDirectImplicit._
    SimpleDirectImplicit.showImplicitParameterUse() should be eq ("SimpleDirectImplicit.aObjectImplicitInstance")
  }
}
