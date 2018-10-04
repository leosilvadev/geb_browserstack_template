package com.github.leosilvadev.geb.specs.awful_valentine.cart

import com.github.leosilvadev.geb.pages.awful_valentine.CartPage
import com.github.leosilvadev.geb.pages.awful_valentine.HomePage
import com.github.leosilvadev.geb.specs.FeatureSpec

class EmptyCartSpec extends FeatureSpec {

    def 'Customer have an empty Cart before adding any product'() {
        when: 'the customer goes to the home page'
        to(HomePage)

        and: 'he clicks on "Cart" link'
        at(HomePage).header_menu.go_to_cart()

        then: 'he should be redirected to the cart page and see no item on it'
        at(CartPage).has_no_items()
    }

}
