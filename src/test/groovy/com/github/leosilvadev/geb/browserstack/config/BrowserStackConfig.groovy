package com.github.leosilvadev.geb.browserstack.config

import java.util.concurrent.atomic.AtomicReference

class BrowserStackConfig {

  private static AtomicReference<SessionMode> modeRef

  static {
    modeRef = new AtomicReference<>(SessionMode.SESSION_PER_METHOD)
  }

  static void setMode(final SessionMode mode) {
    modeRef.set(mode)
  }

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

  static boolean isModeSessionPerSpec() {
    modeRef.get() == SessionMode.SESSION_PER_SPEC
  }

  static enum SessionMode {
    SESSION_PER_SPEC,
    SESSION_PER_METHOD
  }

}
