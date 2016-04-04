package com.lihaoyi.workbench

import akka.actor.ActorRefFactory
import spray.routing._
import spray.routing.directives.ContentTypeResolver
import spray.util.LoggingContext

trait Routing {
  def route(app: Directives)
           (implicit
            settings: RoutingSettings,
            resolver: ContentTypeResolver,
            refFactory: ActorRefFactory,
            log: LoggingContext): Route
}

object DefaultRouting extends Routing {
  def route(app: Directives)
           (implicit
            settings: RoutingSettings,
            resolver: ContentTypeResolver,
            refFactory: ActorRefFactory,
            log: LoggingContext): Route = {
    app.getFromDirectory(".")
  }
}
