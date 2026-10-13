import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

CustomKeywords.'jovita.CommonKeyword.goToHomePage'()

'Call reusable Custom Keyword for Popular Games Play Button check'
CustomKeywords.'jovita.GameKeyword.verifyLoginPopupOnPlayGame'(findTestObject('Object Repository/Jovita/Game_Popular_Play_Button'))
