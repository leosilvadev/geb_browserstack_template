package com.github.leosilvadev.geb.modules.awful_valentine

import com.github.leosilvadev.geb.pages.awful_valentine.CartPage
import com.github.leosilvadev.geb.pages.awful_valentine.HomePage
import geb.Module
import org.openqa.selenium.interactions.Actions

class HeaderMenu extends Module {

    static content = {
        active_button { $('#secondary-menu .current_page_item > a') }

        home_button(to: HomePage) { $('#secondary-menu a', 0)}
        code_button { $('#secondary-menu > li > a', 1)}
        contact_button { $('#secondary-menu > li > a', 2)}
        purchase_button { $('#secondary-menu > li > a', 3)}
        store_button { $('#secondary-menu > li > a', 4)}

        cart_button(to: CartPage) { $('#secondary-menu li.page-item-6 > a') }
    }

    def get_current_page_button() {
        active_button
    }

    def go_to_cart() {
        interact {
            moveToElement store_button
            waitFor { cart_button.displayed }
            click cart_button
        }
    }

}
