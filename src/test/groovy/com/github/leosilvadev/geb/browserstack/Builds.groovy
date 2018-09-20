package com.github.leosilvadev.geb.browserstack

import com.fasterxml.jackson.databind.ObjectMapper
import com.mashape.unirest.http.Unirest
import com.github.leosilvadev.geb.browserstack.config.BrowserstackConfig as config

class Builds {

  private static final String URL_BUILDS = config.urlFor('/builds.json')
  private static final ObjectMapper mapper = new ObjectMapper()

  static Map currentBuild() {
    def json = Unirest.get(URL_BUILDS)
      .basicAuth(config.username(), config.accessKey())
      .asString()
      .body

    mapper.readValue(json, List).find {
      config.buildName() == it?.automation_build?.name
    } ?: [:]
  }

}
