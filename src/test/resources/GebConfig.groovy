import geb.driver.BrowserStackDriverFactory

waiting {
  timeout = 10
}

def browserStackBrowser = System.getProperty('geb.browserstack.browser')
if (browserStackBrowser) {
  driver = {
    def username = System.getenv('GEB_BROWSERSTACK_USERNAME')
    assert username
    def accessKey = System.getenv('GEB_BROWSERSTACK_AUTHKEY')
    assert accessKey

    def capabilities = [
      build  : System.getenv('GEB_BROWSERSTACK_BUILD') ?: 'Default build',
      name   : new Date().format("dd/MM/yyyy HH:mm:ss"),
      project: System.getenv('GEB_BROWSERSTACK_PROJECT') ?: 'Project Geb test'
    ]
    new BrowserStackDriverFactory().create(browserStackBrowser, username, accessKey, capabilities)
  }
}