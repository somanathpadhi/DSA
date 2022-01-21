package _24.recursion.intermediate;

public class MoveAllXToEndOfTheString {
    public static void main(String[] args) {
        String str = "ahxjjx";
        moveAllXToEndOfTheString(str, 0, 0, "");
    }

    private static void moveAllXToEndOfTheString(String str, int idx, int count, String newStr) {

        if (idx == str.length()) {
            for (int i = 0; i < count; i++) {
                newStr += 'x';
            }
            System.out.println(newStr);
            return;
        }

        if (str.charAt(idx) != 'x') {
            newStr += str.charAt(idx);
            moveAllXToEndOfTheString(str, idx + 1, count, newStr);
        } else {
            count++;
            moveAllXToEndOfTheString(str, idx + 1, count, newStr);
        }
    }
}
