package com.github.leosilvadev.geb.specs

import com.github.leosilvadev.geb.browserstack.Sessions
import com.github.leosilvadev.geb.browserstack.config.BrowserstackConfig
import geb.driver.CachingDriverFactory
import geb.spock.GebReportingSpec
import geb.spock.GebSpec

class FeatureSpec extends GebSpec {

  def cleanup() {
    def specName = specificationContext.currentSpec.name
    if (BrowserstackConfig.isModeSessionPerSpec()) {
      Sessions.setSessionName(specName)

    } else {
      def featureName = specificationContext.currentFeature.name
      Sessions.setSessionName("${specName}: ${featureName}")
      CachingDriverFactory.clearCacheAndQuitDriver()
    }
  }

}
