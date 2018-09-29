package com.github.leosilvadev.geb.specs.awful_valentine

import com.github.leosilvadev.geb.pages.awful_valentine.CartPage
import com.github.leosilvadev.geb.pages.awful_valentine.HomePage
import com.github.leosilvadev.geb.specs.FeatureSpec

class DiscoveringSpec extends FeatureSpec {

    def 'Customer should go to home page, then go to cart page and see an empty cart'() {
        when: 'the customer goes to the home page'
        to(HomePage)

        and: 'he clicks on "Cart" link'
        at(HomePage).header.go_to_cart()

        then: 'he should be redirected to the cart page and see no item on it'
        at(CartPage).has_no_items()
    }

}
