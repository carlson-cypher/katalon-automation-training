import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

class TL_Browser {

    @BeforeTestSuite
    def openBrowserOnce(TestSuiteContext testSuiteContext) {
        WebUI.openBrowser(GlobalVariable.baseUrl)
        WebUI.maximizeWindow()
    }

    @AfterTestSuite
    def closeBrowserOnce(TestSuiteContext testSuiteContext) {
        WebUI.closeBrowser()
    }
}