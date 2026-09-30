import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

String ErrMessage = ''
boolean IsFailed = false

String siteUrl = 'https://behemoth-w1n.nomlaterla.com/'

WebUI.openBrowser('')
WebUI.navigateToUrl(siteUrl)
WebUI.maximizeWindow()

'Handle optional announcement / popup dialogs'
WebUI.waitForElementPresent(findTestObject('Object Repository/Jovita/General_Button_Popup_Close'), 10, FailureHandling.OPTIONAL)
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Jovita/General_Button_Popup_Close'), 1, FailureHandling.OPTIONAL)) {
	if (WebUI.verifyElementVisible(findTestObject('Object Repository/Jovita/General_Button_Popup_Close'), FailureHandling.OPTIONAL)) {
		WebUI.click(findTestObject('Object Repository/Jovita/General_Button_Popup_Close'), FailureHandling.OPTIONAL)
	}
}

WebUI.waitForElementPresent(findTestObject('Object Repository/Jovita/Header_Sports_Button'), 10, FailureHandling.OPTIONAL)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Jovita/Header_Sports_Button'), 5, FailureHandling.OPTIONAL)) {
	if (WebUI.verifyElementVisible(findTestObject('Object Repository/Jovita/Header_Sports_Button'), FailureHandling.OPTIONAL)) {
		WebUI.click(findTestObject('Object Repository/Jovita/Header_Sports_Button'), FailureHandling.OPTIONAL)
		
		int waitCounter = 0
		String currentUrl = WebUI.getUrl()
		while (!currentUrl.contains('sport') && waitCounter < 5) {
			WebUI.sleep(1000)
			currentUrl = WebUI.getUrl()
			waitCounter++
		}

		if (!currentUrl.contains('desktop/sport') && !currentUrl.contains('sport')) {
			ErrMessage += 'URL did not match Sports page. Actual URL: ' + currentUrl + '\n'
			IsFailed = true
		}
	} else {
		ErrMessage += 'Header Sports Button element is not visible.\n'
		IsFailed = true
	}
} else {
	ErrMessage += 'Header Sports Button element is not present.\n'
	IsFailed = true
}

WebUI.closeBrowser()

if (IsFailed || ErrMessage != '') {
	KeywordUtil.markFailed(ErrMessage)
} else {
	KeywordUtil.logInfo('Success: Navigated to Sports page successfully.')
}
