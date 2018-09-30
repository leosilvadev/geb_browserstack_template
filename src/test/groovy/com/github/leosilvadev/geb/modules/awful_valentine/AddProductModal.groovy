package com.github.leosilvadev.geb.modules.awful_valentine

import com.github.leosilvadev.geb.pages.awful_valentine.CartPage
import geb.Module

class AddProductModal extends Module {

    static content = {
        container { $('#fancybox-content') }

        confirm_add_button(to: CartPage) { $('#fancybox-content input[type=submit]') }
    }

    boolean isDisplayed() {
        container.displayed
    }

    def confirm() {
        confirm_add_button.click()
    }

}
