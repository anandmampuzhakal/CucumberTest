package modularization.features.onboardingtest

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class UserRegistrationFragment : Fragment() {

    lateinit var amountEditText: EditText
    lateinit var userName: EditText
    lateinit var numberToWords: String
    private var integerPart: Int = 0
    private var decimalPart: Int = 0
    private lateinit var integerPartInWords: String
    private lateinit var decimalPartInWords: String


    private val numbers: HashMap<Int, String>
        get() = hashMapOf(
            0 to "",
            1 to "One",
            2 to "Two",
            3 to "Three",
            4 to "Four",
            5 to "Five",
            6 to "Six",
            7 to "Seven",
            8 to "Eight",
            9 to "Nine",
            10 to "Ten",
            11 to "Eleven",
            12 to "Twelve",
            13 to "Thirteen",
            14 to "Fourteen",
            15 to "Fifteen",
            16 to "Sixteen",
            17 to "Seventeen",
            18 to "Eighteen",
            19 to "Nineteen",
            20 to "Twenty",
            30 to "Thirty",
            40 to "Forty",
            50 to "Fifty",
            60 to "Sixty",
            70 to "Seventy",
            80 to "Eighty",
            90 to "Ninety"
        )

    private val tens: HashMap<Int, String>  get()  =
        hashMapOf(0 to "", 3 to "Hundred ", 4 to "Thousand ", 6 to "Lakh ", 8 to "Crore ")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_registration, container, false)

        amountEditText = view.findViewById<EditText>(R.id.amount)
        userName = view.findViewById<EditText>(R.id.username)
        setTextWatcher(amountEditText)
        view.findViewById<Button>(R.id.button_register).setOnClickListener {
            if(userName.text.isNotEmpty() && amountEditText.text.toString().isNotEmpty()) {
                activity?.intent?.putExtra("userName", userName.text.toString())
                activity?.intent?.putExtra("numberToWords", numberToWords)
                findNavController().navigate(R.id.action_user_registration_to_result_Fragment)
            }else{
                Toast.makeText(activity,getString(R.string.inputs_error),Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }


    private fun setTextWatcher(view: View) {
        amountEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(amount: CharSequence, start: Int, before: Int, count: Int) {

                numberToWords = processingInputNumber(amount.toString())
            }
        })
    }


    fun processingInputNumber(amount: String): String {
        val numberInWords = StringBuilder()
        resetValues()
        when {
            amount.contains(".") -> {
                val indexOfDecimal: Int = amount.indexOf(".")
                when {
                    amount[0].toString().trim() != "." -> {
                        integerPart = getIntegerPart(amount, indexOfDecimal)
                    }
                }
                decimalPart = getDecimalPart(amount, indexOfDecimal)
                decimalPartInWords = toWords(decimalPart)
            }
            else -> {
                integerPart = getIntegerPart(amount, amount.length)
            }
        }

        when {
            integerPart > 0 -> {
                integerPartInWords = toWords(integerPart)
                numberInWords.append(integerPartInWords)
            }
        }

        when {
            decimalPartInWords.trim().isNotEmpty() -> { decimalPartInWords = decimalPartInWords.replace("dollars", "")
                if(integerPart > 0 ){
                    numberInWords.append(" and ")
                }
                numberInWords.append(decimalPartInWords).append("CENTS")
            }
        }

        return formatString(numberInWords)
    }

    private fun resetValues() {
        numberToWords = ""
        integerPartInWords = ""
        decimalPartInWords = ""
        integerPart = 0
        decimalPart = 0
    }

    private fun formatString(numberInWords: StringBuilder): String {
        var finalString = numberInWords.trim().toString()
        finalString = finalString.replace("  ", " ")
        return finalString.toUpperCase()
    }

    fun getIntegerPart(amount: String, indexOfDecimal: Int): Int {
            return when {
                amount.isNotEmpty() && amount != "." -> amount.substring(0, indexOfDecimal).toInt()
                else -> 0
            }
    }

    fun getDecimalPart(amount: String, indexOfDecimal: Int): Int {
        return if( (amount.length - indexOfDecimal ) > 1)
            amount.substring(indexOfDecimal).replace(".", "").trim().toInt()
        else 0
    }

    fun toWords(amount: Int): String {
        val stringAmount = amount.toString()
        var numberInWords = ""
        var length = stringAmount.length
        var nLength: Int
        var ch: Char
        var needToAddText: Boolean = false

        while (length > 0) {
            ch = stringAmount[stringAmount.length - length]
            when {
                ch != '0' -> {
                    //Checks if ch has '1' and i is at odd place(greater than 3rd) or at 2nd place
                    when {
                        ch == '1' && (length > 3 && length % 2 != 0 || length == 2) -> {
                            //For adding 'TEEN' numbers, Eg: Thirteen
                            nLength = stringAmount.substring(
                                stringAmount.length - length,
                                stringAmount.length - --length + 1
                            ).toInt()
                            numberInWords += numbers[nLength].toString() + " "
                        }
                        else -> {
                            //Checks if 'i' is at odd place(greater than 3rd) or at 2nd place
                            when {
                                length % 2 != 0 && length > 3 || length == 2 -> {
                                    //For adding 'RTY' numbers, Eg: Forty
                                    when {
                                        needToAddText -> {
                                            numberInWords = numberInWords.replace(" AND ", " ")
                                            numberInWords += " AND "
                                        }
                                    }
                                    numberInWords += numbers[Character.getNumericValue(ch) * 10].toString() + " "

                                    when (length) {
                                        2 -> if (stringAmount.last() == '0') {
                                            numberInWords.trim()
                                        } else {
                                            val sb = StringBuilder()
                                            sb.append(numberInWords.trim()).append("-")
                                            numberInWords = sb.toString()
                                        }
                                    }

                                    length--
                                }
                            }
                            //For adding single numbers Eg: Four
                            numberInWords.trim()
                            numberInWords += numbers[Character.getNumericValue(stringAmount[stringAmount.length - length])].toString() + " "

                        }
                    }
                    //For adding tens, Eg: Thousand
                    tens[length].toString().let {
                        when {
                            length > 2 -> {
                                needToAddText = true
                            }
                        }
                        when {
                            !tens[length].isNullOrEmpty() -> {
                                numberInWords += tens[length].toString()
                            }
                        }
                    }
                }
            }
            length--
        }

        return when {
            numberInWords.trim() == "One" -> {
                "${numberInWords.trim()} dollar"
            }
            else -> {
                "${numberInWords.trim()} dollars "
            }
        }

    }


}