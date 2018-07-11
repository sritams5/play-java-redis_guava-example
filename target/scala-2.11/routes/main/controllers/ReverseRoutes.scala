
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/shamodi/Downloads/workspace/play-java-redis_guava-example/conf/routes
// @DATE:Wed Jun 13 11:52:45 IST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:9
  class ReverseProductsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def getProducts(productName:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "products/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("productName", productName)))
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def stats(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "stats")
    }
  
    // @LINE:6
    def index(agent:String = "DESKTOP"): Call = {
      
      Call("GET", _prefix + play.core.routing.queryString(List(if(agent == "DESKTOP") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("agent", agent)))))
    }
  
    // @LINE:7
    def products(prd:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "product/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("prd", prd)))
    }
  
  }


}
