package com.github.leosilvadev.geb.specs

import geb.spock.GebReportingSpec

class FeatureSpec extends GebReportingSpec {

  def cleanup() {
    System.setProperty('geb.browserstack.test.name', "Test name")
  }

}
