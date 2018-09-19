package com.github.leosilvadev.geb.browserstack

import org.spockframework.runtime.extension.IGlobalExtension
import org.spockframework.runtime.model.SpecInfo

class GlobalSpecExtension implements IGlobalExtension {
    @Override
    void start() {

    }

    @Override
    void visitSpec(SpecInfo spec) {
        spec.addListener(new FailureListener())
    }

    @Override
    void stop() {

    }
}
