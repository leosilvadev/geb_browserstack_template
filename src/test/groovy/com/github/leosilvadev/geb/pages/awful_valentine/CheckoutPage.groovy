package com.github.leosilvadev.geb.pages.awful_valentine

import geb.Page

class CheckoutPage extends Page {

    static url = 'http://awful-valentine.com/store/checkout/'

    static at = {
        title.startsWith('Checkout ')
    }

    static content = {
        itemContainers { $('#viewCartTable > tbody > tr').not('.subtotal, .shipping, .tax-row, .total') }
    }

}
