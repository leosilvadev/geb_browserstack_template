package com.github.leosilvadev.geb.specs.google

import com.github.leosilvadev.geb.pages.google.GoogleResultsPage
import com.github.leosilvadev.geb.pages.google.GoogleSearchPage

class GoogleSearchSpec extends FeatureSpec {

  def 'Should search in googlea'() {
    given: 'a term'
    def term = 'Geb spock browserstack setup 1'

    when: 'the google page is opened'
    to(GoogleSearchPage)

    and: 'the term is set in the search input'
    at(GoogleSearchPage).searchFor(term)

    then: 'ten results should be shown'
    at(GoogleResultsPage).hasResults(10)
  }

  def 'Should search in google and fail'() {
    given: 'a term'
    def term = 'Geb spock browserstack setup 2'

    when: 'the google page is opened'
    to(GoogleSearchPage)

    and: 'the term is set in the search input'
    at(GoogleSearchPage).searchFor(term)

    then: 'ten results should be shown'
    at(GoogleResultsPage).hasResults(9)
  }

}
