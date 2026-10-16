import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.navigateToUrl(GlobalVariable.baseUrl)

CustomKeywords.'tim.katalon.verifyLoginPopupOnPlay'(
    findTestObject('Tim/Home/btn_Play_Popular_Game'),
    findTestObject('Tim/Home/popup_Please_Login_First'),
    'Please login first')
