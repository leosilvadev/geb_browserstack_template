package com.github.leosilvadev.geb.modules.awful_valentine

import com.github.leosilvadev.geb.pages.awful_valentine.CartPage
import geb.Module
import geb.navigator.Navigator

class AddProductModal extends Module {

    static content = {
        container { $('#fancybox-content') }

        confirm_add_button(to: CartPage) { $('#fancybox-content input[type=submit]') }
    }

    boolean isDisplayed() {
        container.displayed
    }

    Navigator confirm() {
        interact {
            click confirm_add_button
        }
    }

}
