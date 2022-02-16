import cats.effect.Resource
import monix.eval.Task
import weaver.monixcompat.{GlobalResource, GlobalWrite}

object MySharedGlobalResource extends GlobalResource {

  override def sharedResources(global: GlobalWrite): Resource[Task, Unit] =
    global.putR[String]("HelloWorld")

}
