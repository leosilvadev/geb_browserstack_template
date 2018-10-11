package com.github.leosilvadev.geb.pages.awful_valentine

import com.github.leosilvadev.geb.modules.awful_valentine.HeaderMenu
import geb.Page
import geb.navigator.Navigator
import geb.navigator.NonEmptyNavigator

class ContactPage extends Page {

    static url = 'http://awful-valentine.com/contact-us/'

    static at = {
        headerMenu.getCurrentPageButton().text() == 'Contact Us'
    }

    static content = {
        headerMenu { module HeaderMenu }

        nameInput { $('input[name=your-name]') }
        nameAlert { $('span.your-name > span[role=alert]') }

        emailInput { $('input[name=your-email]') }
        emailAlert { $('span.your-email > span[role=alert]') }

        subjectInput { $('input[name=your-subject]') }
        messageInput { $('textarea[name=your-message]') }
        submitButton { $('input[type=submit]') }

        alertContainer { $('div[role=alert]') }
    }

    Navigator setName(String name) {
        NonEmptyNavigator
        nameInput.value(name)
    }

    Navigator setEmail(String email) {
        emailInput.value(email)
    }

    Navigator setSubject(String subject) {
        subjectInput.value(subject)
    }

    Navigator setMessage(String message) {
        messageInput.value(message)
    }

    Navigator submit() {
        submitButton.click()
    }

    boolean hasAlertFor(String element) {
        switch (element) {
            case 'name': return waitFor { nameAlert.displayed }
            case 'email': return waitFor { emailAlert.displayed }
            default: return false
        }
    }
}
