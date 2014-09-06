package pmsoft.scala.game.impli

import scala.language.implicitConversions

/**
 * Date: 2014-09-06
 */
object SimpleDirectImplicit {

  implicit def baseToView(base: BaseSimple) = new ShowImplicitObject("SimpleDirectImplicit.baseToView")

  def showImplicitParameterUse()(implicit view: ShowWhereTheImplicitIsFound) = view.whereYouAre

  implicit lazy val aObjectImplicitInstance = new ShowImplicitObject("SimpleDirectImplicit.aObjectImplicitInstance")
}

class BaseSimple

trait ShowWhereTheImplicitIsFound {
  def whereYouAre: String
}


class ShowImplicitObject(val whereYouAre: String) extends ShowWhereTheImplicitIsFound {

}
