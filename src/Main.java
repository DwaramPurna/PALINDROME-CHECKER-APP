import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

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
        String uc2Word = "level";

        String uc2Reversed = "";
        for (int i = uc2Word.length() - 1; i >= 0; i--) {
            uc2Reversed = uc2Reversed + uc2Word.charAt(i);
        }

        if (uc2Word.equals(uc2Reversed)) {
            System.out.println("UC2: The word \"" + uc2Word + "\" is a Palindrome.");
        } else {
            System.out.println("UC2: The word \"" + uc2Word + "\" is NOT a Palindrome.");
        }
        System.out.println("UC2 Completed Successfully.");
        System.out.println("-------------------------------------");
        System.out.println();

        // ================= UC3: Case-Insensitive Palindrome Check =================
        String uc3Word = "Level";

        String uc3Reversed = "";
        for (int i = uc3Word.length() - 1; i >= 0; i--) {
            uc3Reversed = uc3Reversed + uc3Word.charAt(i);
        }

        if (uc3Word.equalsIgnoreCase(uc3Reversed)) {
            System.out.println("UC3: The word \"" + uc3Word + "\" is a Palindrome (Case-Insensitive).");
        } else {
            System.out.println("UC3: The word \"" + uc3Word + "\" is NOT a Palindrome.");
        }
        System.out.println("UC3 Completed Successfully.");
        System.out.println("-------------------------------------");
        System.out.println();

        // ================= UC4: Character Array Based Palindrome Check =================
        String uc4Word = "Level";
        char[] charArray = uc4Word.toLowerCase().toCharArray();

        boolean isPalindromeUC4 = true;
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            if (charArray[start] != charArray[end]) {
                isPalindromeUC4 = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindromeUC4) {
            System.out.println("UC4: The word \"" + uc4Word + "\" is a Palindrome (Using char array).");
        } else {
            System.out.println("UC4: The word \"" + uc4Word + "\" is NOT a Palindrome (Using char array).");
        }
        System.out.println("UC4 Completed Successfully.");
        System.out.println("-------------------------------------");
        System.out.println();

        // ================= UC5: Stack-Based Palindrome Check =================
        String uc5Word = "Level";
        String lowerCaseUC5 = uc5Word.toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < lowerCaseUC5.length(); i++) {
            stack.push(lowerCaseUC5.charAt(i));
        }

        String uc5Reversed = "";
        while (!stack.isEmpty()) {
            uc5Reversed = uc5Reversed + stack.pop();
        }

        if (lowerCaseUC5.equals(uc5Reversed)) {
            System.out.println("UC5: The word \"" + uc5Word + "\" is a Palindrome (Using Stack).");
        } else {
            System.out.println("UC5: The word \"" + uc5Word + "\" is NOT a Palindrome (Using Stack).");
        }
        System.out.println("UC5 Completed Successfully.");
        System.out.println("-------------------------------------");
        System.out.println();

        // ================= UC6: Queue + Stack Based Palindrome Check =================
        String uc6Word = "Level";
        String lowerCaseUC6 = uc6Word.toLowerCase();

        Stack<Character> uc6Stack = new Stack<>();
        Queue<Character> uc6Queue = new LinkedList<>();

        // Enqueue and Push characters
        for (int i = 0; i < lowerCaseUC6.length(); i++) {
            char ch = lowerCaseUC6.charAt(i);
            uc6Stack.push(ch);      // LIFO
            uc6Queue.add(ch);       // FIFO
        }

        boolean isPalindromeUC6 = true;

        // Compare dequeue (FIFO) and pop (LIFO)
        while (!uc6Queue.isEmpty()) {
            char fromQueue = uc6Queue.remove();   // Dequeue
            char fromStack = uc6Stack.pop();      // Pop

            if (fromQueue != fromStack) {
                isPalindromeUC6 = false;
                break;
            }
        }

        if (isPalindromeUC6) {
            System.out.println("UC6: The word \"" + uc6Word + "\" is a Palindrome (Using Queue + Stack).");
        } else {
            System.out.println("UC6: The word \"" + uc6Word + "\" is NOT a Palindrome (Using Queue + Stack).");
        }

        System.out.println("UC6 Completed Successfully.");
        System.out.println("-------------------------------------");
    }
}