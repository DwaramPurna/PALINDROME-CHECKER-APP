public class Main {

    // Application constants
    private static final String APP_NAME = "Palindrome Checker App";
    private static final String VERSION = "Version 1.0";

    public static void main(String[] args) {

        // ================= UC1: Application Entry & Welcome Message =================
        System.out.println("=====================================");
        System.out.println("      " + APP_NAME);
        System.out.println("      " + VERSION);
        System.out.println("=====================================");
        System.out.println("Welcome to the Palindrome Checker Application!");
        System.out.println("This application validates whether a given string is a palindrome.");
        System.out.println("-------------------------------------");
        System.out.println("UC1 Completed Successfully.");
        System.out.println();

        // ================= UC2: Hardcoded Palindrome Check =================
        String uc2Word = "level";  // Hardcoded string for UC2

        // Reverse string (UC2 logic)
        String uc2Reversed = "";
        for (int i = uc2Word.length() - 1; i >= 0; i--) {
            uc2Reversed = uc2Reversed + uc2Word.charAt(i);
        }

        // Check palindrome (case-sensitive)
        if (uc2Word.equals(uc2Reversed)) {
            System.out.println("UC2: The word \"" + uc2Word + "\" is a Palindrome.");
        } else {
            System.out.println("UC2: The word \"" + uc2Word + "\" is NOT a Palindrome.");
        }
        System.out.println("UC2 Completed Successfully.");
        System.out.println("-------------------------------------");
        System.out.println();

        // ================= UC3: Palindrome Check Using String Reverse =================
        String uc3Word = "Level"; // Hardcoded string for UC3 (mixed case)

        // Reverse string using loop
        String uc3Reversed = "";
        for (int i = uc3Word.length() - 1; i >= 0; i--) {
            uc3Reversed = uc3Reversed + uc3Word.charAt(i);
        }

        // Compare original and reversed using equalsIgnoreCase (case-insensitive)
        if (uc3Word.equalsIgnoreCase(uc3Reversed)) {
            System.out.println("UC3: The word \"" + uc3Word + "\" is a Palindrome (Case-Insensitive).");
        } else {
            System.out.println("UC3: The word \"" + uc3Word + "\" is NOT a Palindrome.");
        }
        System.out.println("UC3 Completed Successfully.");
        System.out.println("-------------------------------------");
        System.out.println();

        // ================= UC4: Character Array Based Palindrome Check =================
        String uc4Word = "Level"; // Hardcoded string for UC4 (mixed case)
        char[] charArray = uc4Word.toLowerCase().toCharArray(); // Convert to lowercase for case-insensitive check

        boolean isPalindrome = true;
        int start = 0;
        int end = charArray.length - 1;

        // Two-pointer technique
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Display result
        if (isPalindrome) {
            System.out.println("UC4: The word \"" + uc4Word + "\" is a Palindrome (Using char array).");
        } else {
            System.out.println("UC4: The word \"" + uc4Word + "\" is NOT a Palindrome (Using char array).");
        }
        System.out.println("UC4 Completed Successfully.");
        System.out.println("-------------------------------------");
    }
}