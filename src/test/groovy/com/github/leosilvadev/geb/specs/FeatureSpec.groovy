package com.github.leosilvadev.geb.specs

import com.github.leosilvadev.geb.browserstack.Sessions
import geb.spock.GebReportingSpec

class FeatureSpec extends GebReportingSpec {

  def cleanup() {
    def specName = specificationContext.currentSpec.name
    def featureName = specificationContext.currentFeature.name
    Sessions.setSessionName("${specName}: ${featureName}")
  }

}
