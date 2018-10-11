package com.github.leosilvadev.geb.pages.awful_valentine

import com.github.leosilvadev.geb.modules.awful_valentine.AddProductModal
import com.github.leosilvadev.geb.modules.awful_valentine.HeaderMenu
import com.github.leosilvadev.geb.modules.awful_valentine.SpecialItemsMenu
import geb.Page

class HomePage extends Page {

    static url = 'http://awful-valentine.com/'

    static at = {
        headerMenu.getCurrentPageButton().text() == 'Home'
    }

    static content = {
        topColorStripes { $('#color-stripes') }

        headerMenu { module HeaderMenu }
        specialItemsMenu { module SpecialItemsMenu }
        addProductModal { module AddProductModal }

        offersContainer { $('#top-area .container') }
        mainContainer { $('#main-content-area.container') }
        footerContainer { $('#footer-bottom .container') }
    }

}
