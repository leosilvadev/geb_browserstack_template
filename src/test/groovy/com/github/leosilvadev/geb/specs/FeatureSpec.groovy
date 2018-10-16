package com.github.leosilvadev.geb.specs

import com.github.leosilvadev.geb.browserstack.Sessions
import com.github.leosilvadev.geb.browserstack.config.BrowserStackConfig
import geb.driver.CachingDriverFactory
import geb.spock.GebSpec
import spock.lang.Stepwise
import spock.lang.Unroll

class FeatureSpec extends GebSpec {

  def cleanup() {
    if (BrowserStackConfig.browser()) {
      updateSessionInBrowserStack()
    }
  }

  def cleanupSpec() {
    def stepwise = getSpecificationContext().currentSpec.getAnnotation(Stepwise)
    def unroll = getSpecificationContext().currentSpec.getAnnotation(Unroll)
    if (BrowserStackConfig.isModeSessionPerSpec() || stepwise || unroll) {
      Sessions.setSessionName(getSpecificationContext().currentSpec.name)
    }
    CachingDriverFactory.clearCacheAndQuitDriver()
  }

  private void updateSessionInBrowserStack() {
    def stepwise = getSpecificationContext().currentSpec.getAnnotation(Stepwise)
    def unroll = getSpecificationContext().currentSpec.getAnnotation(Unroll)
    if (BrowserStackConfig.isModeSessionPerSpec() || stepwise || unroll) {
      return
    }

    Sessions.setSessionName(sessionName())
    CachingDriverFactory.clearCacheAndQuitDriver()
  }

  private String sessionName() {
    def specName = getSpecificationContext().currentSpec.name
    def featureName = getSpecificationContext().currentFeature.name
    "${specName}: ${featureName}"
  }

}
