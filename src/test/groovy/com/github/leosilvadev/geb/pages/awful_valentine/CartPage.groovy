package com.github.leosilvadev.geb.pages.awful_valentine

import com.github.leosilvadev.geb.modules.awful_valentine.HeaderMenu
import geb.Page

class CartPage extends Page {

    static url = 'http://awful-valentine.com/store/cart/'

    static at = {
        title.startsWith 'Cart'
    }

    static content = {
        products_container { $('#main-products') }

        header { module HeaderMenu }

        empty_card_container(required: false){ $('#emptyCartMsg') }
    }

    def has_no_items() {
        empty_card_container.displayed
    }

}
