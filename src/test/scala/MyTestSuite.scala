import cats.effect.Resource
import monix.eval.Task
import weaver.monixcompat.{GlobalRead, TaskSuite}

class MyTestSuite(global: GlobalRead) extends TaskSuite{
  override type Res = String

  override def sharedResource: Resource[Task, String] =
    global.getOrFailR[String]()

  test("I can use the global resource") { resource =>
    Task(expect(resource == "HelloWorld"))
  }

}
