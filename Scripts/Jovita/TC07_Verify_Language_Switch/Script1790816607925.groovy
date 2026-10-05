import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

WebUI.waitForElementPresent(findTestObject('Object Repository/Jovita/Header_Language_Dropdown'), 10, FailureHandling.OPTIONAL)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Jovita/Header_Language_Dropdown'), 5, FailureHandling.OPTIONAL)) {
	'Click Language Dropdown'
	WebUI.click(findTestObject('Object Repository/Jovita/Header_Language_Dropdown'), FailureHandling.OPTIONAL)
	
	'Select Indonesian Option'
	WebUI.waitForElementPresent(findTestObject('Object Repository/Jovita/Header_Language_Option_Indonesian'), 5, FailureHandling.OPTIONAL)
	WebUI.click(findTestObject('Object Repository/Jovita/Header_Language_Option_Indonesian'), FailureHandling.OPTIONAL)
	
	WebUI.sleep(1500)
	
	'Verify page language changed to Indonesian'
	boolean isIndoVerified = WebUI.verifyElementPresent(findTestObject('Object Repository/Jovita/Header_Language_Dropdown'), 5, FailureHandling.OPTIONAL)
	if (!isIndoVerified) {
		ErrMessage += 'Failed to verify page language switched to Indonesian.\n'
		IsFailed = true
	}
	
	'Switch back to English'
	WebUI.click(findTestObject('Object Repository/Jovita/Header_Language_Dropdown'), FailureHandling.OPTIONAL)
	WebUI.waitForElementPresent(findTestObject('Object Repository/Jovita/Header_Language_Option_English'), 5, FailureHandling.OPTIONAL)
	WebUI.click(findTestObject('Object Repository/Jovita/Header_Language_Option_English'), FailureHandling.OPTIONAL)
	
	WebUI.sleep(1500)
	
	'Verify page language switched back to English'
	boolean isEngVerified = WebUI.verifyElementPresent(findTestObject('Object Repository/Jovita/Header_Language_Dropdown'), 5, FailureHandling.OPTIONAL)
	if (!isEngVerified) {
		ErrMessage += 'Failed to verify page language switched back to English.\n'
		IsFailed = true
	}
} else {
	ErrMessage += 'Header Language Dropdown is not present.\n'
	IsFailed = true
}

WebUI.closeBrowser()

if (IsFailed || ErrMessage != '') {
	KeywordUtil.markFailed(ErrMessage)
} else {
	KeywordUtil.logInfo('Success: Language switched to Indonesian and back to English successfully.')
}
