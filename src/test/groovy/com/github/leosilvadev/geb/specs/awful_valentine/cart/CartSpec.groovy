package com.github.leosilvadev.geb.specs.awful_valentine.cart

import com.github.leosilvadev.geb.pages.awful_valentine.CartPage
import com.github.leosilvadev.geb.pages.awful_valentine.HomePage
import com.github.leosilvadev.geb.specs.FeatureSpec
import spock.lang.Ignore

class CartSpec extends FeatureSpec {

    def 'Customer should go to home page, then go to cart page and see an empty cart'() {
        when: 'the customer goes to the home page'
        to(HomePage)

        and:
        at(HomePage).special_items_menu.add_to_cart(0)

        then:
        at(HomePage).add_product_modal.displayed

        when:
        at(HomePage).add_product_modal.confirm()

        then: 'he should be redirected to the cart page and see no item on it'
        at(CartPage).items() == 1

        and:
        at(CartPage).item_quantity(0) == 1
    }

}
