package com.github.leosilvadev.geb.pages.awful_valentine

import com.github.leosilvadev.geb.modules.awful_valentine.HeaderMenu
import geb.Page

class HomePage extends Page {

    static url = 'http://awful-valentine.com/'

    static at = {
        header.get_current_page_button().text() == 'Home'
    }

    static content = {
        top_color_stripes { $('#color-stripes') }

        header { module HeaderMenu }

        offers_container { $('#top-area .container') }
        main_container { $('#main-content-area.container') }
        footer_container { $('#footer-bottom .container') }
    }

}
