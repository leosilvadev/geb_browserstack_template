package com.github.leosilvadev.geb.pages.google

import geb.Page

class GoogleSearchPage extends Page {

    static url = 'https://google.com'

    static at = { title == 'Google' }

    static content = {
        txtSearch { $('#lst-ib') }
        btnSearch(to: GoogleResultsPage) { $('input[name=btnK]') }
    }

    def searchFor(String text) {
        txtSearch.value(text)
        waitFor { btnSearch.displayed }
        btnSearch.click()
    }
}
