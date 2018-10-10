package com.github.leosilvadev.geb.specs.awful_valentine.contact

import com.github.leosilvadev.geb.pages.awful_valentine.ContactPage
import com.github.leosilvadev.geb.specs.FeatureSpec
import spock.lang.Unroll

class ContactSendValidationSpec extends FeatureSpec {

    @Unroll
    def '''
        Customer must not be able to send contact passing name as #name, email as #email and message as #message.
        An error must be shown in element #element'''(name, email, subject, message, element) {
        when: 'the customer goes to the contact page'
        to(ContactPage)

        and:
        at(ContactPage).setName(name)
        at(ContactPage).setEmail(email)
        at(ContactPage).setSubject(subject)
        at(ContactPage).setMessage(message)
        at(ContactPage).submit()

        then:
        at(ContactPage).hasAlertFor(element)

        where:
        name    | email               | subject   | message                     | element
        ''      | 'dummy@email.com'   | 'hello'   | 'Hello! Can you help me?'   | 'name'
        'name'  | ''                  | 'hello'   | 'Hello! Can you help me?'   | 'email'
        'name'  | 'dummynoemail'      | 'hello'   | 'Hello! Can you help me?'   | 'email'
    }

}
