package modularization.features.onboardingtest

import org.junit.Assert
import org.junit.Before
import org.junit.Test
/**
 * @author Anand M Joseph (anandmampuzhakal@hotmail.com)
 */
class UserRegistrationFragmentTest {

    lateinit var userRegistrationFragment :UserRegistrationFragment
      @Before
    fun setUp() {
        userRegistrationFragment = UserRegistrationFragment()
    }

    @Test
    fun testTheSingleDigitToWords() {
        //given
         var amount = 1
        //when
        var result = userRegistrationFragment.toWords(amount).trim()
        //then
         Assert.assertEquals(result,"One dollar")
    }
    @Test
    fun testTheSingleDigitGreaterOneToWords() {
        //given
        var amount = 3
        //when
        var result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Three dollars")
    }

    @Test
    fun testTheDoubleDigitsToWords() {
        //given
        var amount = 11
        //when
        var result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Eleven dollars")
    }

    @Test
    fun testTheDoubleDigitsMaxToWords() {
        //given
        var amount = 99
        //when
        var result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Ninety-Nine dollars")
    }


    @Test
    fun testTheThreeDigitsLeastToWords() {
        //given
        var amount = 100
        //when
        var result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"One Hundred dollars")
    }

    @Test
    fun testTheThreeDigitsMaxToWords() {
        //given
        var amount = 999
        //when
        var result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Nine Hundred  AND Ninety-Nine dollars")
    }

    @Test
    fun testTheFourDigitsLeastToWords() {
        //given
        var amount = 1000
        //when
        var result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"One Thousand dollars")
    }

    @Test
    fun testTheFiveDigitsMaxToWords() {
        //given
        var amount = 9999
        //when
        var result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Nine Thousand Nine Hundred  AND Ninety-Nine dollars")
    }

    @Test
    fun testTheFiveDigitsMaxtToWords() {
        //given
        var amount = 9999
        //when
        var result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Nine Thousand Nine Hundred  AND Ninety-Nine dollars")
    }

    @Test
    fun testTheSixDigitsLeastToWords() {
        //given
        var amount = 100000
        //when
        var result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"One Lakh dollars")
    }

    @Test
    fun testTheSixDigitsMaxWords() {
        //given
        var amount = 999999
        //when
        var result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Nine Lakh  Ninety Nine Thousand Nine Hundred  AND Ninety-Nine dollars")
    }

    @Test
    fun testTheEightDigitsLeastWords() {
        //given
        var amount = 10000000
        //when
        var result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"One Crore dollars")
    }

    @Test
    fun testTheEightDigitsMaxWords() {
        //given
        var amount = 99999999
        //when
        var result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Nine Crore  Ninety Nine Lakh  Ninety Nine Thousand Nine Hundred  AND Ninety-Nine dollars")
    }


    @Test
    fun testGetIntegerPart() {
        //given
        var amount = "10.01"
        val indexOfDecimal: Int = amount.indexOf(".")
        //when
        var result = userRegistrationFragment.getIntegerPart(amount, indexOfDecimal)
        //then
        Assert.assertEquals(10,result)
    }

    @Test
    fun testDecimalPart() {
        //given
        var amount = "10.01"
        val indexOfDecimal: Int = amount.indexOf(".")
        //when
        var result = userRegistrationFragment.getDecimalPart(amount, indexOfDecimal)
        //then
        Assert.assertEquals(1,result)
    }

    @Test
    fun testTheProcessingInputNumberOnlyWithIntegerPart() {
        //given
        var amount = "143"
        //when
        var result = userRegistrationFragment.processingInputNumber(amount).trim()
        //then
        Assert.assertEquals(result,"ONE HUNDRED AND FORTY-THREE DOLLARS")
    }


    @Test
    fun testTextModifyLogicWithHyphen() {
        //given
        var amount = 23
        //when
        var result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Twenty-Three dollars")
    }

    @Test
    fun testTextModifyLogicWitOutHyphen() {
        //given
        var amount = 20
        //when
        var result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Twenty dollars")

        // "ONE HUNDRED AND TWENTY-THREE DOLLARS AND FORTY-FIVE CENTS"
    }

    @Test
    fun testTheProcessingInputNumberOnlyWithIntegerAndDecimalPPart() {
        //given
        var amount = "123.45"
        //when
        var result = userRegistrationFragment.processingInputNumber(amount).trim()
        //then
        Assert.assertEquals(result,"ONE HUNDRED AND TWENTY-THREE DOLLARS AND FORTY-FIVE CENTS")
    }


}