package _24.recursion.intermediate;

public class FirstAndLastOccurrenceOfString {
    public static int firstOccurrence = -1;
    public static int lastOccurrence = -1;

    public static void main(String[] args) {

        String str = "Somanth";
        firstAndLastOccurrenceOfString(str, 0, 'a');
    }

    private static void firstAndLastOccurrenceOfString(String s, int i, char cuuChar) {
        if (i == s.length()) {
            System.out.println("firstOccurrence " + firstOccurrence);
            System.out.println("lastOccurrence " + lastOccurrence);
            return;
        }

        if (cuuChar == s.charAt(i)) {
            if (firstOccurrence == -1) {
                firstOccurrence = i;
                lastOccurrence = i;
            } else {
                lastOccurrence = i;
            }
        }
        firstAndLastOccurrenceOfString(s, i + 1, cuuChar);
    }
}
