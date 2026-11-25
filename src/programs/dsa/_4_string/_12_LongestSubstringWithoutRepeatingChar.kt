package programs.dsa._4_string

fun main() {
    //abcabcbb -> abc
    val str = "abcaabcbb"
    print(longestSubstringWithoutRepeatingChar(str))
}

// Approach: Sliding Window + HashSet
// 1. Initialize left pointer, empty set and empty result.
// 2. Iterate through the string using index as the right pointer.
// 3. If a duplicate character is found, remove characters from
//    the left and increment left until the duplicate is removed.
// 4. Add the current character to the set.
// 5. If the current window is larger than the result,
//    update the result using substring(left, index + 1).
// 6. Return the longest substring.
//
// Example: "abcaabcbb" -> "abc"

fun longestSubstringWithoutRepeatingChar(str: String): String {

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





//other approaches
//------------------


fun longestSubstring2(s: String): String {
    val count = IntArray(256) { 0 }
    var l = 0
    var r = 0
    var bestStart = 0
    var bestLen = 0

    while (r < s.length) {
        count[s[r].code]++

        while (count[s[r].code] > 1) {
            count[s[l].code]--
            l++
        }

        if (r - l + 1 > bestLen) {
            bestLen = r - l + 1
            bestStart = l
        }

        r++
    }

    var result = ""
    for (i in bestStart until bestStart + bestLen) {
        result += s[i]
    }

    return result
}

fun longestSubS(s: String): String {
    val seen = HashMap<Char, Int>()
    var startIndex = 0
    var bestStart = 0
    var bestLength = 0

    for (endIndex in s.indices) {
        val char = s[endIndex]
        val lastSeen = seen.getOrDefault(char, -1)

        if (lastSeen >= startIndex) {
            startIndex = lastSeen + 1
        }

        seen[char] = endIndex

        if (endIndex - startIndex + 1 > bestLength) {
            bestLength = endIndex - startIndex + 1
            bestStart = startIndex
        }
    }
    var result = ""
    for (i in bestStart..<bestStart + bestLength) {
        result = result + s[i]
    }
    return result
}

fun longestSubstring(s: String): String {
    val seen = HashMap<Char, Int>()
    var start = 0
    var bestStart = 0
    var bestLen = 0

    for (end in s.indices) {
        val c = s[end]

        // getOrDefault avoids !! operator
        val lastIndex = seen.getOrDefault(c, -1)

        if (lastIndex >= start) {
            start = lastIndex + 1
        }

        seen[c] = end

        if (end - start + 1 > bestLen) {
            bestLen = end - start + 1
            bestStart = start
        }
    }

    var result = ""
    for (i in bestStart until bestStart + bestLen) {
        result += s[i]
    }
    return result
}




