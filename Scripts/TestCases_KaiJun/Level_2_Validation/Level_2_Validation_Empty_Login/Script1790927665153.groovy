import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
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

WebUI.navigateToUrl(GlobalVariable.homeUrl)

CustomKeywords.'common.PopupKeywords.closeHomepagePopup'()

//Press Login button visible
WebUI.click(findTestObject('Object Repository/ObjectRepository_KaiJun/Login/Login_Button'))

WebUI.delay(2)

//Verify Login form is it visible
WebUI.verifyElementVisible(findTestObject('Object Repository/ObjectRepository_KaiJun/Login/Login_Form'))

// Click Login Without entering username/password
WebUI.click(findTestObject('Object Repository/ObjectRepository_KaiJun/Login/Login_Form_Button'))

// Verify required error for username
WebUI.verifyElementVisible(findTestObject('Object Repository/ObjectRepository_KaiJun/Login/Empty_Login_Username_Validation'))

// Verify required error for password
WebUI.verifyElementVisible(findTestObject('Object Repository/ObjectRepository_KaiJun/Login/Empty_Login_Password_Validation'))

// Close browser
WebUI.closeBrowser()