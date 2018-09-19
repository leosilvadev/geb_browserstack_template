package com.github.leosilvadev.geb.browserstack

import com.fasterxml.jackson.databind.ObjectMapper
import com.mashape.unirest.http.Unirest

class Builds {

    private static final String URL_BUILDS = 'https://api.browserstack.com/automate/builds.json'
    private static final ObjectMapper mapper = new ObjectMapper()


    static Map currentBuild() {
        def json = Unirest.get(URL_BUILDS)
                .basicAuth(System.getenv('BROWSERSTACK_USERNAME'), System.getenv('BROWSERSTACK_ACCESS_KEY'))
                .asString()
                .body

        def builds = mapper.readValue(json, List)
        builds ? builds.head() : [:]
    }

}
