package com.example.unittestpracticing.utils

class Helper {

    fun isPalindrome(inputStr: String): Boolean {
        var i = 0
        var j = inputStr.length - 1
        var result = true

        while (i < j) {
            if (inputStr[i] != inputStr[j]) {
                result = false
                break
            }

            i++
            j--
        }
        return result
    }
}