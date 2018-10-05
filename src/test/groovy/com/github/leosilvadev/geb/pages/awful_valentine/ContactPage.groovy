package com.github.leosilvadev.geb.pages.awful_valentine

import geb.Page
import geb.navigator.Navigator

class ContactPage extends Page {

    static url = 'http://awful-valentine.com/contact-us/'

    static at = {

    }

    static content = {
        name_input { $('input[name=your-name]') }
        name_alert { $('span.your-name > span[role=alert]') }

        email_input { $('input[name=your-email]') }
        email_alert { $('span.your-email > span[role=alert]') }

        subject_input { $('input[name=your-subject]') }
        message_input { $('input[name=your-message]') }
        submit_button { $('input[type=submit]') }

        alert_container { $('div[role=alert]') }
    }

    Navigator setName(String name) {
        name_input.value(name)
    }

    Navigator setEmail(String email) {
        email_input.value(email)
    }

    Navigator setSubject(String subject) {
        subject_input.value(subject)
    }

    Navigator setMessage(String message) {
        message_input.value(message)
    }

    Navigator submit() {
        submit_button.click()
    }

}
