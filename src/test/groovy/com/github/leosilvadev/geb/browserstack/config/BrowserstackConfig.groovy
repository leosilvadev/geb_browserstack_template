package com.github.leosilvadev.geb.browserstack

class BrowserstackConfig {

  static String username() {
    System.getenv('BROWSERSTACK_USERNAME')
  }

  static String buildName() {
    System.getenv('GEB_BROWSERSTACK_BUILD') ?: 'Default build'
  }

}
