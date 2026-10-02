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

//------------------ Homepage popup checking---------------------//
if (WebUI.verifyElementVisible(
	findTestObject('ObjectRepository_KaiJun/Pop_Up/Homepage_Popup'),
	FailureHandling.OPTIONAL)) {


WebUI.click(findTestObject('ObjectRepository_KaiJun/Pop_Up/Homepage_Popup_Ok_button'))
}
//------------------ Homepage popup checking---------------------//

//Press Login button visible
WebUI.click(findTestObject('Object Repository/ObjectRepository_KaiJun/Login/Login_Button'))

WebUI.delay(2)

//Verify Login form is it visible
WebUI.verifyElementVisible(findTestObject('Object Repository/ObjectRepository_KaiJun/Login/Login_Form'))

WebUI.setText(findTestObject('Object Repository/ObjectRepository_KaiJun/Login/Login_Form_Username_Field'),'wronguser123')

WebUI.setText(findTestObject('Object Repository/ObjectRepository_KaiJun/Login/Login_Form_Password_Field'),'wrongpassword123')

// Click Login
WebUI.click(findTestObject('Object Repository/ObjectRepository_KaiJun/Login/Login_Form_Button'))

// Verify Invalid username or password display
WebUI.verifyElementVisible(findTestObject('Object Repository/ObjectRepository_KaiJun/Login/Login_Invalid_Username_Password'))

// Close browser
WebUI.closeBrowser()