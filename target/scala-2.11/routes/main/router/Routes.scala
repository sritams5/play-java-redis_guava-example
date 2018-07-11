
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/shamodi/Downloads/workspace/play-java-redis_guava-example/conf/routes
// @DATE:Wed Jun 13 11:52:45 IST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:9
  ProductsController_1: controllers.ProductsController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:9
    ProductsController_1: controllers.ProductsController
  ) = this(errorHandler, HomeController_0, ProductsController_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, ProductsController_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index(agent:String ?= "DESKTOP")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product/""" + "$" + """prd<[^/]+>""", """controllers.HomeController.products(prd:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """stats""", """controllers.HomeController.stats"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products/""" + "$" + """productName<[^/]+>""", """controllers.ProductsController.getProducts(productName:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Seq(classOf[String]),
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_products1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product/"), DynamicPart("prd", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_products1_invoker = createInvoker(
    HomeController_0.products(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "products",
      Seq(classOf[String]),
      "GET",
      this.prefix + """product/""" + "$" + """prd<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_stats2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("stats")))
  )
  private[this] lazy val controllers_HomeController_stats2_invoker = createInvoker(
    HomeController_0.stats,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "stats",
      Nil,
      "GET",
      this.prefix + """stats""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_ProductsController_getProducts3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products/"), DynamicPart("productName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductsController_getProducts3_invoker = createInvoker(
    ProductsController_1.getProducts(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductsController",
      "getProducts",
      Seq(classOf[String]),
      "GET",
      this.prefix + """products/""" + "$" + """productName<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call(params.fromQuery[String]("agent", Some("DESKTOP"))) { (agent) =>
        controllers_HomeController_index0_invoker.call(HomeController_0.index(agent))
      }
  
    // @LINE:7
    case controllers_HomeController_products1_route(params@_) =>
      call(params.fromPath[String]("prd", None)) { (prd) =>
        controllers_HomeController_products1_invoker.call(HomeController_0.products(prd))
      }
  
    // @LINE:8
    case controllers_HomeController_stats2_route(params@_) =>
      call { 
        controllers_HomeController_stats2_invoker.call(HomeController_0.stats)
      }
  
    // @LINE:9
    case controllers_ProductsController_getProducts3_route(params@_) =>
      call(params.fromPath[String]("productName", None)) { (productName) =>
        controllers_ProductsController_getProducts3_invoker.call(ProductsController_1.getProducts(productName))
      }
  }
}
