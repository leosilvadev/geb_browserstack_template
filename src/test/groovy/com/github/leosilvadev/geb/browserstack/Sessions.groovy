package com.github.leosilvadev.geb.browserstack

import com.fasterxml.jackson.databind.ObjectMapper
import com.mashape.unirest.http.Unirest

class Sessions {

    private static final String URL_GET_SESSIONS = 'https://api.browserstack.com/automate/builds/%s/sessions.json'
    private static final String URL_UPDATE_SESSION = 'https://api.browserstack.com/automate/sessions/%s.json'
    private static final ObjectMapper mapper = new ObjectMapper()

    static Map currentSession() {
        def build = Builds.currentBuild()
        def json = Unirest.get(String.format(URL_GET_SESSIONS, build.automation_build.hashed_id))
                .basicAuth(System.getenv('BROWSERSTACK_USERNAME'), System.getenv('BROWSERSTACK_ACCESS_KEY'))
                .asString()
                .body

        def sessions = mapper.readValue(json, List)
        sessions ? sessions.head() : [:]
    }


    static void failCurrentSession(Throwable ex) {
        def id = currentSession().automation_session.hashed_id
        println(String.format(URL_UPDATE_SESSION, id))
        def response = Unirest.put(String.format(URL_UPDATE_SESSION, id))
                .header('Content-Type', 'application/json')
                .basicAuth(System.getenv('BROWSERSTACK_USERNAME'), System.getenv('BROWSERSTACK_ACCESS_KEY'))
                .body(mapper.writeValueAsString([status: 'failed', reason: ex.message]))
                .asString()
                .body
        println(response)
    }
}
