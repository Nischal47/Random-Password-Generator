import java.security.SecureRandom

fun main(){
    for(i in 0..10000){
        val passwordGeneration = PasswordGeneration()
        passwordGeneration.generatePassword()
    }
}