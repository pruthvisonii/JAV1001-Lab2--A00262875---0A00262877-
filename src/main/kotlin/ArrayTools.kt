/*JAV1001 App Development for Android -- LAB 02

STUDENT NAME STUDENT ID

Pruthvi Soni - A00262875 - Mobile Application Development

Sakshi Sheth - A00262877 - Mobile Application Development*/


package prog

fun main(args: Array<String>) {

        //User Input For Caesar cipher

        println("Enter your text for Caesar cipher\n")
        val text = readLine()

        // Encryption of the inputted text
        val cipher = text?.let { encrypt (it, 5 ) }
        println("Cipher text is: $cipher")

        //Print the calculated avg of Array
        println("\nThe avg of array  (45.3, 67.5, -45.6, 20.34, 33.0, 45.6) is\n")
        println("${arrayAvg()}")

        //Input the Array call the contain function
        println("\nDoes the array (4, 7, 3, 5, 2) contain Search value?\n")
        var arrcontain = arrayOf(4, 7, 3, 5, 2)
        val searchvalue = 5
        println(arrayContains(arrcontain, searchvalue))

        //Input the array and reverse it
        println("\n Reverse of array (1, 2, 3, 4, 5) is\n")
        val arrreverse: Array<Int?> = arrayOf(1, 2, 3, 4, 5)
        reverse(arrreverse)
        println(arrreverse.contentToString())


}

//Caesar cipher

 fun encrypt( text: String, shift: Int ): String {

    var result = ""

    val firstCharCode = 'A'.toInt()
    val offset = ( 'z' - 'A' ) + 1

    for ( i in 0 until text.length ) {

        val oldCharCode = text[i].toInt()
        val oldIdxInAlphabet = oldCharCode - firstCharCode
        val newIdxInAlphabet = (oldIdxInAlphabet + shift) % offset

        val newChar = (firstCharCode + newIdxInAlphabet).toChar()
        result += newChar
    }

    return result
}

//Average

 fun arrayAvg(){
    val numArray = doubleArrayOf(45.3, 67.5, -45.6, 20.34, 33.0, 45.6)
    var sum = 0.0

    for (num in numArray) {
        sum += num
    }

    val average = sum / numArray.size
    println(": %.2f".format(average))

}

//Contains

fun <T> arrayContains(arr: Array<T>, target: T): Boolean {
    return arr.contains(target)
}

//Reverse

inline fun<reified T> reverse(arr: Array<T?>) {
    val temp = arrayOfNulls<T>(arr.size)
    for (i in arr.indices) {
        temp[arr.size - 1 - i] = arr[i]
    }
    for (i in arr.indices) {
        arr[i] = temp[i]
    }
}