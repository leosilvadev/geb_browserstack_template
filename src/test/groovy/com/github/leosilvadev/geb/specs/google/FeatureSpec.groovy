package com.github.leosilvadev.geb.specs.google

import com.github.leosilvadev.geb.browserstack.Sessions
import com.github.leosilvadev.geb.browserstack.config.BrowserstackConfig
import geb.driver.CachingDriverFactory
import geb.spock.GebReportingSpec

class FeatureSpec extends GebReportingSpec {

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
