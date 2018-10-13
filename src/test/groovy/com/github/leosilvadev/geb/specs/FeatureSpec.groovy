package com.github.leosilvadev.geb.specs

import com.github.leosilvadev.geb.browserstack.Sessions
import com.github.leosilvadev.geb.browserstack.config.BrowserStackConfig
import geb.driver.CachingDriverFactory
import geb.spock.GebSpec

class FeatureSpec extends GebSpec {

  def cleanup() {
    if (BrowserStackConfig.browser()) {
      updateSessionInBrowserStack()
    }
  }

  private void updateSessionInBrowserStack() {
    def specName = specificationContext.currentSpec.name
    if (BrowserStackConfig.isModeSessionPerSpec()) {
      Sessions.setSessionName(specName)

    } else {
      Sessions.setSessionName(sessionName())
      CachingDriverFactory.clearCacheAndQuitDriver()
    }
  }

  private String sessionName() {
    def specName = specificationContext.currentSpec.name
    def featureName = specificationContext.currentFeature.name
    "${specName}: ${featureName}"
  }

}
