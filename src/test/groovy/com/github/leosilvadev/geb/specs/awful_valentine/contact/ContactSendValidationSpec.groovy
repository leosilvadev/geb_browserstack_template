package com.github.leosilvadev.geb.specs.awful_valentine.contact

import com.github.leosilvadev.geb.pages.awful_valentine.ContactPage
import com.github.leosilvadev.geb.specs.FeatureSpec

class ContactSendValidationSpec extends FeatureSpec {

    def 'Customer must not be able to send contact without set his name'(String name, String email, String subject, String message) {
        when: 'the customer goes to the contact page'
        to(ContactPage)

        and:
        at(ContactPage).setName(name)
        at(ContactPage).setEmail(email)
        at(ContactPage).setSubject(subject)
        at(ContactPage).setMessage(message)
        at(ContactPage).submit()

        then:
        at(ContactPage)

        where:
        name    | email               | subject   | message
        ''      | 'dummy@email.com'   | 'hello'   | 'Hello! Can you help me?'
    }

}
