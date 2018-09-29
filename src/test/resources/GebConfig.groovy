import com.github.leosilvadev.geb.browserstack.config.BrowserstackConfig
import geb.driver.BrowserStackDriverFactory
import com.github.leosilvadev.geb.browserstack.config.BrowserstackConfig as config
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver

waiting {
  timeout = 5
}

environments {
  chrome {
    atCheckWaiting = true
    driver = { new ChromeDriver() }
  }
  chrome_headless {
    atCheckWaiting = true
    driver = {
      ChromeOptions o = new ChromeOptions()
      o.addArguments('headless')
      new ChromeDriver(o)
    }
  }
  firefox {
    atCheckWaiting = true
    driver = { new FirefoxDriver() }
  }
}

def browserStackBrowser = System.getProperty('geb.browserstack.browser')
if (browserStackBrowser) {

  /**
   * Define the way you want to manager your browserstack sessions:
   * - SESSION_PER_SPEC:
   * create a new session in browserstack for each new specification and
   * record all the tests methods in this session.
   * This mode cleans the cache and close the browser after the method execution.
   *
   *
   * - SESSION_PER_METHOD:
   * create a new session for each method in each specification.
   * This mode keeps the cache and the opened browser for the whole specification.
   *
   * * Important:
   * SESSION_PER_METHOD mode adds some overhead in execution time, since it
   * clear the cache and close the browser after each method.
   **/
  BrowserstackConfig.setMode(BrowserstackConfig.SessionMode.SESSION_PER_METHOD)
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