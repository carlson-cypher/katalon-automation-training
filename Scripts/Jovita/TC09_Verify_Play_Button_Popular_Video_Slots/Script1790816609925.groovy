import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import CustomKeywords

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

'Call reusable Custom Keyword for Popular Video Slots Play Button check'
CustomKeywords.'jovita.GameKeyword.verifyLoginPopupOnPlayGame'(findTestObject('Object Repository/Jovita/Game_Popular_Video_Slots_Play_Button'))

WebUI.closeBrowser()
