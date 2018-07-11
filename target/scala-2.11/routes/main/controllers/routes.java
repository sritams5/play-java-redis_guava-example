
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/shamodi/Downloads/workspace/play-java-redis_guava-example/conf/routes
// @DATE:Wed Jun 13 11:52:45 IST 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseProductsController ProductsController = new controllers.ReverseProductsController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseProductsController ProductsController = new controllers.javascript.ReverseProductsController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
  }

}
