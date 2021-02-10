package modularization.features.onboardingtest

import org.junit.Assert
import org.junit.Before
import org.junit.Test
/**
 * @author Anand M Joseph (anandmampuzhakal@hotmail.com)
 */
class UserRegistrationFragmentTest {

    private lateinit var userRegistrationFragment :UserRegistrationFragment
      @Before
    fun setUp() {
        userRegistrationFragment = UserRegistrationFragment()
    }

    @Test
    fun testTheSingleDigitToWords() {
        //given
         val amount = 1
        //when
        val result = userRegistrationFragment.toWords(amount).trim()
        //then
         Assert.assertEquals(result,"One dollar")
    }
    @Test
    fun testTheSingleDigitGreaterOneToWords() {
        //given
        val amount = 3
        //when
        val result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Three dollars")
    }

    @Test
    fun testTheDoubleDigitsToWords() {
        //given
        val amount = 11
        //when
        val result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Eleven dollars")
    }

    @Test
    fun testTheDoubleDigitsMaxToWords() {
        //given
        val amount = 99
        //when
        val result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Ninety-Nine dollars")
    }


    @Test
    fun testTheThreeDigitsLeastToWords() {
        //given
        val amount = 100
        //when
        val result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"One Hundred dollars")
    }

    @Test
    fun testTheThreeDigitsMaxToWords() {
        //given
        val amount = 999
        //when
        val result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Nine Hundred  AND Ninety-Nine dollars")
    }

    @Test
    fun testTheFourDigitsLeastToWords() {
        //given
        val amount = 1000
        //when
        val result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"One Thousand dollars")
    }

    @Test
    fun testTheFiveDigitsMaxToWords() {
        //given
        val amount = 9999
        //when
        val result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Nine Thousand Nine Hundred  AND Ninety-Nine dollars")
    }

    @Test
    fun testTheFiveDigitsMaxtToWords() {
        //given
        val amount = 9999
        //when
        val result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Nine Thousand Nine Hundred  AND Ninety-Nine dollars")
    }

    @Test
    fun testTheSixDigitsLeastToWords() {
        //given
        val amount = 100000
        //when
        val result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"One Lakh dollars")
    }

    @Test
    fun testTheSixDigitsMaxWords() {
        //given
        val amount = 999999
        //when
        val result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Nine Lakh  Ninety Nine Thousand Nine Hundred  AND Ninety-Nine dollars")
    }

    @Test
    fun testTheEightDigitsLeastWords() {
        //given
        val amount = 10000000
        //when
        val result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"One Crore dollars")
    }

    @Test
    fun testTheEightDigitsMaxWords() {
        //given
        val amount = 99999999
        //when
        val result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Nine Crore  Ninety Nine Lakh  Ninety Nine Thousand Nine Hundred  AND Ninety-Nine dollars")
    }


    @Test
    fun testGetIntegerPart() {
        //given
        val amount = "10.01"
        val indexOfDecimal: Int = amount.indexOf(".")
        //when
        val result = userRegistrationFragment.getIntegerPart(amount, indexOfDecimal)
        //then
        Assert.assertEquals(10,result)
    }

    @Test
    fun testDecimalPart() {
        //given
        val amount = "10.01"
        val indexOfDecimal: Int = amount.indexOf(".")
        //when
        val result = userRegistrationFragment.getDecimalPart(amount, indexOfDecimal)
        //then
        Assert.assertEquals(1,result)
    }

    @Test
    fun testTheProcessingInputNumberOnlyWithIntegerPart() {
        //given
        val amount = "143"
        //when
        val result = userRegistrationFragment.processingInputNumber(amount).trim()
        //then
        Assert.assertEquals(result,"ONE HUNDRED AND FORTY-THREE DOLLARS")
    }


    @Test
    fun testTextModifyLogicWithHyphen() {
        //given
        val amount = 23
        //when
        val result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Twenty-Three dollars")
    }

    @Test
    fun testTextModifyLogicWitOutHyphen() {
        //given
        val amount = 20
        //when
        val result = userRegistrationFragment.toWords(amount).trim()
        //then
        Assert.assertEquals(result,"Twenty dollars")

        // "ONE HUNDRED AND TWENTY-THREE DOLLARS AND FORTY-FIVE CENTS"
    }

    @Test
    fun testTheProcessingInputNumberOnlyWithIntegerAndDecimalPPart() {
        //given
        val amount = "123.45"
        //when
        val result = userRegistrationFragment.processingInputNumber(amount).trim()
        //then
        Assert.assertEquals(result,"ONE HUNDRED AND TWENTY-THREE DOLLARS AND FORTY-FIVE CENTS")
    }


}