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
        productsContainer { $('#main-products') }

        header { module HeaderMenu }

        emptyCardContainer(required: false){ $('#emptyCartMsg') }

        itemContainers(required: false) { $('#viewCartTable > tbody > tr').not('.subtotal, .shipping, .tax-row, .total') }

        continueShoppingButton(to: HomePage) { $('#continueShopping') }
        checkoutButton(to: CheckoutPage) { $('#Cart66CheckoutButton') }
    }

    boolean has_no_items() {
        waitFor { emptyCardContainer.displayed }
    }

    boolean hasItems(number) {
        waitFor { itemContainers.size() == number }
    }

    boolean hasQuantity(itemIndex, quantity) {
        def item_quantity_inputs = itemContainers*.find('.itemQuantity')

        if (itemIndex >= item_quantity_inputs.size()) {
            throw new IllegalArgumentException("Invalid Item. There are only ${item_quantity_inputs.size()} items but you are requesting the item at index $item_index")
        }

        waitFor { item_quantity_inputs[itemIndex].value().toInteger() == quantity }
    }

    Navigator continue_shopping() {
        continueShoppingButton.click()
    }

    Navigator checkout() {
        checkoutButton.click()
    }

}
