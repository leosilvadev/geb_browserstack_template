package com.github.leosilvadev.geb.pages.google

import geb.Page

class GoogleResultsPage extends Page {

    static at = {
        waitFor {
            txtSearch.displayed && boxResults*.displayed
        }
    }

    static content = {
        txtSearch { $('#lst-ib') }
        boxResults { $('.g') }
    }

    def hasResults(int number) {
        boxResults.size() == number
    }
}
