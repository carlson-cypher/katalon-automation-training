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

WebUI.waitForElementPresent(findTestObject('Object Repository/Jovita/Home_Logo_Image'), 10, FailureHandling.OPTIONAL)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Jovita/Home_Logo_Image'), 5, FailureHandling.OPTIONAL)) {
	if (!WebUI.verifyElementVisible(findTestObject('Object Repository/Jovita/Home_Logo_Image'), FailureHandling.OPTIONAL)) {
		ErrMessage += 'Home Page Logo element is present but not visible.\n'
		IsFailed = true
	}
} else {
	ErrMessage += 'Home Page Logo element is not present.\n'
	IsFailed = true
}

WebUI.closeBrowser()

if (IsFailed || ErrMessage != '') {
	KeywordUtil.markFailed(ErrMessage)
} else {
	KeywordUtil.logInfo('Success: Home Page loaded and Logo is visible.')
}
