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

    int item_quantity(item_index) {
        def item_quantity_inputs = itemContainers*.find('td', 1)

        if (item_index >= item_quantity_inputs.size()) {
            throw new IllegalArgumentException("Invalid Item. There are only ${item_quantity_inputs.size()} items but you are requesting the item at index $item_index")
        }

        item_quantity_inputs[item_index].value().toInteger()
    }

}
