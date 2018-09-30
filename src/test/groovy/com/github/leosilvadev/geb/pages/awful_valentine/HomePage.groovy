package com.github.leosilvadev.geb.pages.awful_valentine

import com.github.leosilvadev.geb.modules.awful_valentine.AddProductModal
import com.github.leosilvadev.geb.modules.awful_valentine.HeaderMenu
import com.github.leosilvadev.geb.modules.awful_valentine.SpecialItemsMenu
import geb.Page

class HomePage extends Page {

    static url = 'http://awful-valentine.com/'

    static at = {
        header_menu.get_current_page_button().text() == 'Home'
    }

    static content = {
        top_color_stripes { $('#color-stripes') }

        header_menu { module HeaderMenu }
        special_items_menu { module SpecialItemsMenu }
        add_product_modal { module AddProductModal }

        offers_container { $('#top-area .container') }
        main_container { $('#main-content-area.container') }
        footer_container { $('#footer-bottom .container') }
    }

}
