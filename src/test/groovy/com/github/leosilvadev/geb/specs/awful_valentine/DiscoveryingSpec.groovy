package com.github.leosilvadev.geb.specs.awful_valentine

import com.github.leosilvadev.geb.pages.awful_valentine.CartPage
import com.github.leosilvadev.geb.pages.awful_valentine.HomePage
import com.github.leosilvadev.geb.specs.FeatureSpec

class DiscoveryingSpec extends FeatureSpec {

    def 'Customer should go to home page, then go to cart page and see an empty cart'() {
        when:
        to(HomePage)

        and:
        at(HomePage).header.go_to_cart()


        then:
        at(CartPage).has_no_items()
    }

}
