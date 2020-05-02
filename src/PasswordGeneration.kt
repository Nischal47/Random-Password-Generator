import java.lang.StringBuilder
import java.security.SecureRandom
import java.util.*


class PasswordGeneration {
    private val MIN_LENGTH = 10
    private val MAX_LENGTH = 16
    private val DIGITS = arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
    private val L_CASE = arrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
    private val U_CASE = arrayOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'M', 'N', 'O', 'p', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
    private val SYMBOLS = arrayOf('@', '#', '$', '%', '=', ':', '?', '.', '|', '~', '*', '(', ')')
    private var passwordLength:Int = 0
    private var digitCounter = 0
    private var lCaseCounter = 0
    private var uCaseCounter = 0
    private var symbolCounter = 0

    constructor(){
        passwordLength = SecureRandom.getInstance("SHA1PRNG").nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH
        digitCounter = SecureRandom.getInstance("SHA1PRNG").nextInt((passwordLength - 6) - 2  + 1) + 2
        lCaseCounter = SecureRandom.getInstance("SHA1PRNG").nextInt((passwordLength - digitCounter - 4) - 2  + 1) +2
        uCaseCounter = SecureRandom.getInstance("SHA1PRNG").nextInt((passwordLength - digitCounter - lCaseCounter -2) - 2 + 1) + 2
        symbolCounter = SecureRandom.getInstance("SHA1PRNG").nextInt((passwordLength - digitCounter - lCaseCounter -uCaseCounter) - 2  + 1) +2
    }

    fun generatePassword(){
        var tempPassword = String()
        var randomdigits = StringBuffer()
        var randomLCases = StringBuffer()
        var randomUCases = StringBuffer()
        var randomSymbols = StringBuffer()

        for(i in 0 until digitCounter){
            randomdigits.append(DIGITS.random().toString())
        }
        for(i in 0 until lCaseCounter){
            randomLCases.append(L_CASE.random().toString())
        }
        for(i in 0 until  uCaseCounter){
            randomUCases.append(U_CASE.random().toString())
        }
        for(i in 0 until symbolCounter){
            randomSymbols.append(SYMBOLS.random().toString())
        }
        tempPassword = randomdigits.toString() + randomLCases + randomUCases + randomSymbols
        println(shufflePassword(tempPassword))

    }

    private fun shufflePassword(tempPassword:String):String{
        var password:StringBuilder = StringBuilder(tempPassword)
        for (i in password.indices.reversed()){
            var j: Int = SecureRandom.getInstance("SHA1PRNG").nextInt(i + 1)
            var temp = password[i]
            password[i] = password[j]
            password[j] = temp
        }
        return "$password"
    }

}
