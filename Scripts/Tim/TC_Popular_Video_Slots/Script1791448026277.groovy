import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://behemoth-w1n.nomlaterla.com/')
WebUI.click(findTestObject('Tim/Home/btn_Close_Home_Popup'))

CustomKeywords.'tim.katalon.verifyLoginPopupOnPlay'(
    findTestObject('Tim/Home/btn_Play_Popular_Video_Slots'),
    findTestObject('Tim/Home/popup_Please_Login_First'))

WebUI.closeBrowser()