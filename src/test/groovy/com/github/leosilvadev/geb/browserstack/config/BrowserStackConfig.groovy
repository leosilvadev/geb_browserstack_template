package com.github.leosilvadev.geb.browserstack.config

import java.util.concurrent.atomic.AtomicReference

class BrowserStackConfig {

  private static ThreadLocal threadLocal = new ThreadLocal<>()

  private static AtomicReference<SessionMode> modeRef

  static {
    modeRef = new AtomicReference<>(SessionMode.SESSION_PER_METHOD)
  }

  static String initSession() {
    final String uuid = UUID.randomUUID().toString().replaceAll('-', '')
    println("Initializing session with uuid $uuid, previous value was ${threadLocal.get()}")
    threadLocal.set(uuid)
    uuid
  }

  static String sessionUuid() {
    threadLocal.get()
  }

  static void setMode(final SessionMode mode) {
    modeRef.set(mode)
  }

  static String browser() {
    System.getProperty('geb.browserstack.browser')
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

  static boolean isModeSessionPerSpec() {
    modeRef.get() == SessionMode.SESSION_PER_SPEC
  }

  static enum SessionMode {
    SESSION_PER_SPEC,
    SESSION_PER_METHOD
  }

}
