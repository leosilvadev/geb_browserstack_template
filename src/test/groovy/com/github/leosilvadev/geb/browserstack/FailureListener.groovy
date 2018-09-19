package com.github.leosilvadev.geb.browserstack

import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.model.ErrorInfo

class FailureListener extends AbstractRunListener {

    @Override
    void error(ErrorInfo error) {
        Sessions.failCurrentSession(error.exception)
    }
}
