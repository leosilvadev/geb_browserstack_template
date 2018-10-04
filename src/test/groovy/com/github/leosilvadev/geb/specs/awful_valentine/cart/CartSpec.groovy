package com.github.leosilvadev.geb.specs.awful_valentine.cart

import com.github.leosilvadev.geb.pages.awful_valentine.CartPage
import com.github.leosilvadev.geb.pages.awful_valentine.CheckoutPage
import com.github.leosilvadev.geb.pages.awful_valentine.HomePage
import com.github.leosilvadev.geb.specs.FeatureSpec
import spock.lang.Stepwise

@Stepwise
class CartSpec extends FeatureSpec {

    def 'Customer should add a product in the Cart'() {
        when: 'the customer goes to the home page'
        to(HomePage)

        and: 'adds one item in the cart'
        at(HomePage).special_items_menu.add_to_cart(0)

        then: 'a confirmation modal should be shown'
        at(HomePage).add_product_modal.displayed

        when: 'the customer confirms that he wants this product'
        at(HomePage).add_product_modal.confirm()

        then: 'he should be redirected to the cart page and see one item on it'
        at(CartPage).items() == 1

        and: 'the item must have one unit'
        at(CartPage).item_quantity(0) == 1
    }

    def 'Customer should be able to search and add more products after having a cart with product'() {
        when: 'the customer clicks in the "continue shopping" button'
        at(CartPage).continue_shopping()

        then: 'the customer must be redirected to the home page'
        at(HomePage)

        when: 'customer adds a new product into the cart'
        at(HomePage).special_items_menu.add_to_cart(1)

        then: 'a confirmation modal should be shown'
        at(HomePage).add_product_modal.displayed

        when: 'the customer confirms that he wants this product'
        at(HomePage).add_product_modal.confirm()

        then: 'he should be redirected to the cart page and see two items on it'
        at(CartPage).items() == 2

        and: 'the both items must have one unit'
        at(CartPage).item_quantity(0) == 1
        at(CartPage).item_quantity(1) == 1
    }

    def 'Customer should be able to checkout his cart'() {
        when: 'the customer clicks in the "checkout" button'
        at(CartPage).checkout()

        then: 'he should be redirected to the checkout page'
        at(CheckoutPage)
    }

}
