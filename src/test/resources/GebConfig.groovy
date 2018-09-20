import geb.driver.BrowserStackDriverFactory
import com.github.leosilvadev.geb.browserstack.config.BrowserstackConfig as config

waiting {
  timeout = 10
}

def browserStackBrowser = System.getProperty('geb.browserstack.browser')
if (browserStackBrowser) {
  driver = {
    def capabilities = [
      build  : config.buildName(),
      name   : config.initialSessionName(),
      project: config.project()
    ]
    new BrowserStackDriverFactory().create(
      browserStackBrowser,
      config.username(),
      config.accessKey(),
      capabilities
    )
  }
}