import geb.driver.BrowserStackDriverFactory
import geb.report.ReportState
import geb.report.Reporter
import geb.report.ReportingListener

//baseUrl = "https://***.net"

waiting {
    timeout = 10
}

reportingListener = new ReportingListener() {
    void onReport(Reporter reporter, ReportState reportState, List<File> reportFiles) {
        reportFiles.each {
            println "[[ATTACHMENT|$it.absolutePath]]"
        }
    }
}

def browserStackBrowser = System.getProperty("geb.browserstack.browser")
if (browserStackBrowser) {
    driver = {
        def username = System.getenv("GEB_BROWSERSTACK_USERNAME")
        assert username
        def accessKey = System.getenv("GEB_BROWSERSTACK_AUTHKEY")
        assert accessKey
        new BrowserStackDriverFactory().create(browserStackBrowser, username, accessKey)
    }
}