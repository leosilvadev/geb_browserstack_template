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

        continueShoppingButton(to: HomePage) { $('.Cart66CartContinueShopping') }
        checkoutButton(to: CheckoutPage) { $('#Cart66CheckoutButton') }
    }

    boolean hasNoItems() {
        emptyCardContainer.displayed
    }

    boolean hasItems(number) {
        itemContainers.size() == number
    }

    boolean hasQuantity(itemIndex, quantity) {
        def itemQuantityInputs = itemContainers*.find('.itemQuantity')

        if (itemIndex >= itemQuantityInputs.size()) {
            throw new IllegalArgumentException("Invalid Item. There are only ${itemQuantityInputs.size()} items but you are requesting the item at index $item_index")
        }

        waitFor { itemQuantityInputs[itemIndex].value().toInteger() == quantity }
    }

    Navigator continueShopping() {
        waitFor {
            continueShoppingButton.click()
        }
    }

    Navigator checkout() {
        waitFor {
            checkoutButton.click()
        }
    }

}
