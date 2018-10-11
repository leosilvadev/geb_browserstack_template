package com.github.leosilvadev.geb.pages.awful_valentine

import com.github.leosilvadev.geb.modules.awful_valentine.HeaderMenu
import geb.Page
import geb.navigator.Navigator

class CartPage extends Page {

    static url = 'http://awful-valentine.com/store/cart/'

    static at = {
        title.startsWith 'Cart'
    }

    static content = {
        products_container { $('#main-products') }

        header { module HeaderMenu }

        empty_card_container(required: false){ $('#emptyCartMsg') }

        item_containers(required: false) { $('#viewCartTable > tbody > tr').not('.subtotal, .shipping, .tax-row, .total') }

        continue_shopping_button(to: HomePage) { $('#continueShopping') }
        checkout_button(to: CheckoutPage) { $('#Cart66CheckoutButton') }
    }

    boolean has_no_items() {
        waitFor {empty_card_container.displayed}
    }

    boolean hasItems(number) {
        waitFor { item_containers.size() == number }
    }

    boolean hasQuantity(itemIndex, quantity) {
        def item_quantity_inputs = item_containers*.find('.itemQuantity')

        if (itemIndex >= item_quantity_inputs.size()) {
            throw new IllegalArgumentException("Invalid Item. There are only ${item_quantity_inputs.size()} items but you are requesting the item at index $item_index")
        }

        waitFor { item_quantity_inputs[itemIndex].value().toInteger() == quantity }
    }

    Navigator continue_shopping() {
        continue_shopping_button.click()
    }

    Navigator checkout() {
        checkout_button.click()
    }

}
