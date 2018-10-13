package com.github.leosilvadev.geb.modules.awful_valentine

import com.github.leosilvadev.geb.pages.awful_valentine.CartPage
import geb.Module
import geb.navigator.Navigator

class AddProductModal extends Module {

    static content = {
        container { $('#fancybox-content') }

        confirmAddButton(to: CartPage) { $('#fancybox-content input[type=submit]') }
    }

    boolean isDisplayed() {
        waitFor { container.displayed }
    }

    Navigator confirm() {
        interact {
            click confirmAddButton
        }
    }

}
