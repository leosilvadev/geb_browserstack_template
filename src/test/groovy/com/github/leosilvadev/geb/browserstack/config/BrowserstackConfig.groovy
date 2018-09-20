package com.github.leosilvadev.geb.browserstack.config

class BrowserstackConfig {

  static String urlFor(final String path) {
    "https://api.browserstack.com/automate$path"
  }

  static String username() {
    System.getenv('BROWSERSTACK_USERNAME')
  }

  static String accessKey() {
    System.getenv('BROWSERSTACK_ACCESS_KEY')
  }

  static String buildName() {
    System.getenv('GEB_BROWSERSTACK_BUILD') ?: 'Default build'
  }

  static String project() {
    System.getenv('GEB_BROWSERSTACK_PROJECT') ?: 'Project Geb test'
  }

  static String initialSessionName() {
    new Date().format("dd/MM/yyyy HH:mm:ss")
  }

}
