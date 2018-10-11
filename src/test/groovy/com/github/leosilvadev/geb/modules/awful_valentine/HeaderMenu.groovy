package com.github.leosilvadev.geb.modules.awful_valentine

import com.github.leosilvadev.geb.pages.awful_valentine.CartPage
import com.github.leosilvadev.geb.pages.awful_valentine.ContactPage
import com.github.leosilvadev.geb.pages.awful_valentine.HomePage
import geb.Module
import geb.navigator.Navigator
import org.openqa.selenium.interactions.Actions

class HeaderMenu extends Module {

    static content = {
        activeButton { $('#secondary-menu .current_page_item > a') }

        homeButton(to: HomePage) { $('#secondary-menu a') }
        codeButton { $('#secondary-menu > li.page-item-38 > a') }
        contactButton(to: ContactPage) { $('#secondary-menu > li.page-item-59 > a') }
        purchaseButton { $('#secondary-menu > li.page-item-68 > a') }
        storeButton { $('#secondary-menu > li.page-item-5 > a') }

        cartButton(to: CartPage) { $('#secondary-menu li.page-item-6 > a') }
    }

    Navigator getCurrentPageButton() {
        activeButton
    }

    Navigator goToCart() {
        interact {
            moveToElement storeButton
            cartButton.displayed
            click cartButton
        }
    }

}
