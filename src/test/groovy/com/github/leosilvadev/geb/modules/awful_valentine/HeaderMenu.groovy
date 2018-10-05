package com.github.leosilvadev.geb.modules.awful_valentine

import com.github.leosilvadev.geb.pages.awful_valentine.CartPage
import com.github.leosilvadev.geb.pages.awful_valentine.ContactPage
import com.github.leosilvadev.geb.pages.awful_valentine.HomePage
import geb.Module
import geb.navigator.Navigator
import org.openqa.selenium.interactions.Actions

class HeaderMenu extends Module {

    static content = {
        active_button { $('#secondary-menu .current_page_item > a') }

        home_button(to: HomePage) { $('#secondary-menu a') }
        code_button { $('#secondary-menu > li.page-item-38 > a') }
        contact_button(to: ContactPage) { $('#secondary-menu > li.page-item-59 > a') }
        purchase_button { $('#secondary-menu > li.page-item-68 > a') }
        store_button { $('#secondary-menu > li.page-item-5 > a') }

        cart_button(to: CartPage) { $('#secondary-menu li.page-item-6 > a') }
    }

    Navigator get_current_page_button() {
        active_button
    }

    Navigator go_to_cart() {
        interact {
            moveToElement store_button
            cart_button.displayed
            click cart_button   
        }
    }

}
