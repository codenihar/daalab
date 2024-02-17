import java.util.Scanner;
public class hsp {

    // Preprocessing function to create a bad character table
    private static int[] preprocessBadCharacterTable(String pattern) {
        int patternLength = pattern.length();
        int[] badCharTable = new int[256]; // Assuming ASCII characters

        // Initialize the table with the default value (pattern length)
        for (int i = 0; i < 256; i++) {
            badCharTable[i] = patternLength;
        }

        // Fill the table with the actual values from the pattern
        for (int i = 0; i < patternLength - 1; i++) {
            badCharTable[pattern.charAt(i)] = patternLength - 1 - i;
        }

        return badCharTable;
    }

    // Horspool search algorithm
    public static int search(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();

        if (patternLength == 0) {
            return 0; // Pattern is empty
        }

        int[] badCharTable = preprocessBadCharacterTable(pattern);

        int i = patternLength - 1;
        while (i < textLength) {
            int j = 0;

            while (j < patternLength && pattern.charAt(patternLength - 1 - j) == text.charAt(i - j)) {
                j++;
            }

            if (j == patternLength) {
                // Pattern found at index (i - patternLength + 1)
                return i - patternLength + 1;
            }

            i += badCharTable[text.charAt(i)];
        }

        return -1; // Pattern not found in the text
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = scanner.nextLine();

        System.out.print("Enter the pattern: ");
        String pattern = scanner.nextLine();
        int index = search(text, pattern);

        if (index != -1) {
            System.out.println("Pattern found at index: " + index);
        } else {
            System.out.println("Pattern not found in the text.");
        }
    }
}