import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

String ErrMessage = ''
boolean IsFailed = false

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.MembersiteURL)
WebUI.maximizeWindow()

'Handle optional announcement / popup dialogs'
WebUI.waitForElementPresent(findTestObject('Object Repository/Jovita/General_Button_Popup_Close'), 2, FailureHandling.OPTIONAL)
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Jovita/General_Button_Popup_Close'), 1, FailureHandling.OPTIONAL)) {
	if (WebUI.verifyElementVisible(findTestObject('Object Repository/Jovita/General_Button_Popup_Close'), FailureHandling.OPTIONAL)) {
		WebUI.click(findTestObject('Object Repository/Jovita/General_Button_Popup_Close'), FailureHandling.OPTIONAL)
	}
}

WebUI.waitForElementPresent(findTestObject('Object Repository/Jovita/Footer_AboutUs_Link'), 10, FailureHandling.OPTIONAL)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Jovita/Footer_AboutUs_Link'), 5, FailureHandling.OPTIONAL)) {
	if (WebUI.verifyElementVisible(findTestObject('Object Repository/Jovita/Footer_AboutUs_Link'), FailureHandling.OPTIONAL)) {
		WebUI.click(findTestObject('Object Repository/Jovita/Footer_AboutUs_Link'), FailureHandling.OPTIONAL)
		
		int waitCounter = 0
		String currentUrl = WebUI.getUrl()
		while (!currentUrl.contains('about') && waitCounter < 5) {
			WebUI.sleep(1000)
			currentUrl = WebUI.getUrl()
			waitCounter++
		}

		if (!currentUrl.contains('about') && !currentUrl.contains('info')) {
			ErrMessage += 'URL did not match Footer About Us page. Actual URL: ' + currentUrl + '\n'
			IsFailed = true
		}
	} else {
		ErrMessage += 'Footer About Us Link is not visible.\n'
		IsFailed = true
	}
} else {
	ErrMessage += 'Footer About Us Link is not present.\n'
	IsFailed = true
}

WebUI.closeBrowser()

if (IsFailed || ErrMessage != '') {
	KeywordUtil.markFailed(ErrMessage)
} else {
	KeywordUtil.logInfo('Success: Navigated to Footer link page successfully.')
}
