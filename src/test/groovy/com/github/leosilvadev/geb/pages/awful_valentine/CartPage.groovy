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

        item_containers { $('#viewCartTable > tbody > tr').not('.subtotal, .shipping, .tax-row, .total') }
    }

    boolean has_no_items() {
        empty_card_container.displayed
    }

    int items(number) {
        item_containers.size()
    }

    int item_quantity(item_index) {
        def item_quantity_inputs = item_containers*.find('.itemQuantity')

        if (item_index >= item_quantity_inputs.size()) {
            throw new IllegalArgumentException("Invalid Item. There are only ${item_quantity_inputs.size()} items but you are requesting the item at index $item_index")
        }

        item_quantity_inputs[item_index].value().toInteger()
    }

}
