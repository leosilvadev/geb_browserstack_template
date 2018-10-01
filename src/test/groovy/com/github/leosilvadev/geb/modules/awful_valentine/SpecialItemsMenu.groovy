package com.github.leosilvadev.geb.modules.awful_valentine

import geb.Module
import geb.navigator.Navigator

class SpecialItemsMenu extends Module {

    static content = {
        item_containers { $('#special-items > .special-item') }
    }

    Navigator add_to_cart(item_index) {
        def button = item_containers[item_index].find('a.add-to-cart')
        button.click()
    }

}
