package com.github.leosilvadev.geb.modules.awful_valentine

import geb.Module
import geb.navigator.Navigator

class SpecialItemsMenu extends Module {

    static content = {
        itemContainers { $('#special-items > .special-item') }

        addToCartButtons { $('#special-items > .special-item .add-to-cart') }
    }

    Navigator addToCart(itemIndex) {
        waitFor {
            addToCartButtons[itemIndex].click()
        }
    }

}
