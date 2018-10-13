package com.github.leosilvadev.geb.browserstack

import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.model.ErrorInfo

class BrowserStackFailureListener extends AbstractRunListener {

    @Override
    void error(ErrorInfo error) {
        def specName = error.method.feature.spec.name
        def featureName = error.method.feature.name
        Sessions.failCurrentSession("${specName}: ${featureName}", error.exception)
    }
}
