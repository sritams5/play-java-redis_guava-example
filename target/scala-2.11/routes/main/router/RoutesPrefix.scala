
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/shamodi/Downloads/workspace/play-java-redis_guava-example/conf/routes
// @DATE:Wed Jun 13 11:52:45 IST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
