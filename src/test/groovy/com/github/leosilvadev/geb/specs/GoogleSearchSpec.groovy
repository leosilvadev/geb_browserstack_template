package com.github.leosilvadev.geb.specs

import com.github.leosilvadev.geb.pages.GoogleResultsPage
import com.github.leosilvadev.geb.pages.GoogleSearchPage
import geb.spock.GebReportingSpec

class GoogleSearchSpec extends GebReportingSpec {

    def 'Should search in google'() {
        given: 'a term'
        def term = 'Geb spock browserstack setup'

        when: 'the google page is opened'
        to(GoogleSearchPage)

        and: 'the term is set in the search input'
        at(GoogleSearchPage).searchFor(term)

        then: 'ten results should be shown'
        at(GoogleResultsPage).hasResults(10)
    }

}
