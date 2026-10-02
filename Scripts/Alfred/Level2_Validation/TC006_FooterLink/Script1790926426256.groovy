import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.llm.keyword.LlmKeywords as LLM
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://behemoth-w1n.nomlaterla.com/')

WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Alfred/Page_testing only/Popup_OK_Button'), FailureHandling.STOP_ON_FAILURE)

//scroll to Footer section
WebUI.scrollToElement(findTestObject('Object Repository/Alfred/Page_testing only/Footer_Policy_Section'), 10)

WebUI.click(findTestObject('Object Repository/Alfred/Page_testing only/Footer_PolicyInfo_1'))

int waited = 0

while(!WebUI.getUrl().contains('desktop/info/page') && waited < 10) {
	WebUI.delay(1)
	waited++
}

String currentUrl = WebUI.getUrl()

WebUI.verifyMatch(currentUrl, '.*/desktop/info/page*', true)

WebUI.closeBrowser()
