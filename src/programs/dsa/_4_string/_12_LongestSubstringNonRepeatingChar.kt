package programs.dsa._4_string

fun main() {
    //abcabcbb -> abc
    val str = "abcaabcbb"
    print(longestSubstringNonRepeatingChar(str))
}

fun longestSubstringNonRepeatingChar(str: String): String {

    var left = 0
    val set = mutableSetOf<Char>()
    var result = ""

    for (index in str.indices) {
        while (str[index] in set) {
            set.remove(str[left])
            left++
        }

        set.add(str[index])

        if (set.size > result.length) {
            result = str.substring(left, index + 1)
        }
    }
    return result
}

