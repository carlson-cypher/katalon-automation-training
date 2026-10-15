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

WebUI.click(findTestObject('Object Repository/Alfred/Page_testing only/Login_Button'))

//verify username and password field are showing
WebUI.waitForElementVisible(findTestObject('Object Repository/Alfred/Page_testing only/Login_Username_Field'), 10, FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementVisible(findTestObject('Object Repository/Alfred/Page_testing only/Login_Password_Field'), 10, FailureHandling.STOP_ON_FAILURE)

//enter invalid username and password
WebUI.setText(findTestObject('Object Repository/Alfred/Page_testing only/Login_Username_Field'), 'wrongtest1')
WebUI.setText(findTestObject('Object Repository/Alfred/Page_testing only/Login_Password_Field'), 'test123')

WebUI.click(findTestObject('Object Repository/Alfred/Page_testing only/LoginForm_Login_Submit_Button'))

WebUI.waitForPageLoad(10)

//verify Invalid Error Message is shown
WebUI.verifyElementVisible(findTestObject('Object Repository/Alfred/Page_testing only/Login_Invalid_Error'))

//continue on Level 3_Bonus
WebUI.callTestCase(findTestCase('Test Cases/Alfred/Level3_Bonus/TC_Reused_Login'), [('username'):'wrongtest2', ('password'):'test123'], FailureHandling.STOP_ON_FAILURE)

//continue on error verification
WebUI.verifyElementVisible(findTestObject('Object Repository/Alfred/Page_testing only/Login_Invalid_Error'))

WebUI.closeBrowser()