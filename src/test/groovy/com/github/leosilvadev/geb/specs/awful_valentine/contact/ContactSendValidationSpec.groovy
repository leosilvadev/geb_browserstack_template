package com.github.leosilvadev.geb.specs.awful_valentine.contact

import com.github.leosilvadev.geb.pages.awful_valentine.ContactPage
import com.github.leosilvadev.geb.specs.FeatureSpec
import spock.lang.Unroll

@Unroll
class ContactSendValidationSpec extends FeatureSpec {

    def '''
        Customer must not be able to send contact passing name as #name, email as #email and message as #message.
        An error must be shown in element #element'''(name, email, subject, message, element) {
        when: 'the customer goes to the contact page'
        to(ContactPage)

        and: 'set the name as #name'
        at(ContactPage).setName(name)

        and: 'set the email as #email'
        at(ContactPage).setEmail(email)

        and: 'set the subject as #subject'
        at(ContactPage).setSubject(subject)

        and: 'set the message as #message'
        at(ContactPage).setMessage(message)

        and: 'submit the contact'
        at(ContactPage).submit()

        then: 'the element #element must show a validation error'
        at(ContactPage).hasAlertFor(element)

        where:
        name    | email               | subject   | message                     | element
        ''      | 'dummy@email.com'   | 'hello'   | 'Hello! Can you help me?'   | 'name'
        'name'  | ''                  | 'hello'   | 'Hello! Can you help me?'   | 'email'
        'name'  | 'dummynoemail'      | 'hello'   | 'Hello! Can you help me?'   | 'email'
    }

}
