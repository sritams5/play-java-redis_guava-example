
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/shamodi/Downloads/workspace/play-java-redis_guava-example/conf/routes
// @DATE:Wed Jun 13 11:52:45 IST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:9
  class ReverseProductsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def getProducts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductsController.getProducts",
      """
        function(productName0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "products/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("productName", productName0))})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def stats: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.stats",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "stats"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function(agent0) {
          return _wA({method:"GET", url:"""" + _prefix + """" + _qS([(agent0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("agent", agent0))])})
        }
      """
    )
  
    // @LINE:7
    def products: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.products",
      """
        function(prd0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("prd", prd0))})
        }
      """
    )
  
  }


}
