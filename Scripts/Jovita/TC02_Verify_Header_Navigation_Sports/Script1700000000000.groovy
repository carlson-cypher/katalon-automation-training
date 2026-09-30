import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.navigateToUrl('https://behemoth-w1n.nomlaterla.com/')
WebUI.maximizeWindow()
WebUI.click(findTestObject('Object Repository/Jovita/Header_Sports_Button'))
WebUI.verifyMatch(WebUI.getUrl(), '.*desktop/sport.*', true)
WebUI.closeBrowser()
