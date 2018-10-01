package com.github.leosilvadev.geb.browserstack

import com.github.leosilvadev.geb.browserstack.config.BrowserStackConfig
import org.spockframework.runtime.extension.IGlobalExtension
import org.spockframework.runtime.model.SpecInfo

class GlobalSpecExtension implements IGlobalExtension {
    @Override
    void start() {

    }

    @Override
    void visitSpec(SpecInfo spec) {
        if (BrowserStackConfig.browser()) {
            spec.addListener(new BrowserStackFailureListener())
        }
    }

    @Override
    void stop() {

    }
}
