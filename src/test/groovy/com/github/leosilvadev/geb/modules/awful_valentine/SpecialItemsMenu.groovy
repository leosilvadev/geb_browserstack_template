package com.github.leosilvadev.geb.modules.awful_valentine

import geb.Module
import geb.navigator.Navigator

class SpecialItemsMenu extends Module {

    static content = {
        itemContainers { $('#special-items > .special-item') }
    }

    Navigator addToCart(itemIndex) {
        def button = itemContainers[itemIndex].find('a.add-to-cart')
        button.click()
    }

}
