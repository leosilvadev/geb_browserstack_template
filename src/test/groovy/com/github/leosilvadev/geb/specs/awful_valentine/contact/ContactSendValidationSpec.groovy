package com.github.leosilvadev.geb.specs.awful_valentine.contact

import com.github.leosilvadev.geb.pages.awful_valentine.ContactPage
import com.github.leosilvadev.geb.specs.FeatureSpec
import geb.navigator.Navigator

class ContactSendValidationSpec extends FeatureSpec {

    def 'Customer must not be able to send contact without set his name'(String name, String email, String subject, String message, String class_name) {
        when: 'the customer goes to the contact page'
        to(ContactPage)

        and:
        at(ContactPage).setName(name)
        at(ContactPage).setEmail(email)
        at(ContactPage).setSubject(subject)
        at(ContactPage).setMessage(message)
        at(ContactPage).submit()

        then:
        at(ContactPage).hasAlertFor(class_name)

        where:
        name    | email               | subject   | message                     | class_name
        ''      | 'dummy@email.com'   | 'hello'   | 'Hello! Can you help me?'   | 'your-name'
        'name'  | ''                  | 'hello'   | 'Hello! Can you help me?'   | 'your-email'
        'name'  | 'dummynoemail'      | 'hello'   | 'Hello! Can you help me?'   | 'your-email'
    }

}
