package com.github.leosilvadev.geb.browserstack

import com.fasterxml.jackson.databind.ObjectMapper
import com.mashape.unirest.http.Unirest
import com.github.leosilvadev.geb.browserstack.config.BrowserstackConfig as config

import static java.lang.String.format

class Sessions {

  private static final String URL_GET_SESSIONS = config.urlFor('/builds/%s/sessions.json')
  private static final String URL_ONE_SESSION = config.urlFor('/sessions/%s.json')
  private static final ObjectMapper mapper = new ObjectMapper()

  static Map currentSession() {
    def build = Builds.currentBuild()

    def json = Unirest.get(format(URL_GET_SESSIONS, build.automation_build.hashed_id))
      .basicAuth(config.username(), config.accessKey())
      .asString()
      .body

    def sessions = mapper.readValue(json, List)
    sessions ? sessions.head() : [:]
  }

  static void setSessionName(final String name) {
    def id = currentSession().automation_session.hashed_id
    Unirest.put(format(URL_ONE_SESSION, id))
      .header('Content-Type', 'application/json')
      .basicAuth(config.username(), config.accessKey())
      .body(mapper.writeValueAsString([name: name]))
      .asString()
      .body
  }

  static void failCurrentSession(Throwable ex) {
    def id = currentSession().automation_session.hashed_id
    Unirest.put(format(URL_ONE_SESSION, id))
      .header('Content-Type', 'application/json')
      .basicAuth(config.username(), config.accessKey())
      .body(mapper.writeValueAsString([status: 'failed', reason: ex.message]))
      .asString()
      .body
  }
}
