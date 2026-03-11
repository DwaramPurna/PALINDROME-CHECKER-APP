import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {

    // Application constants
    private static final String APP_NAME = "Palindrome Checker App";
    private static final String VERSION = "Version 1.0";

    public static void main(String[] args) {

        // ================= UC1 =================
        System.out.println("=====================================");
        System.out.println("      " + APP_NAME);
        System.out.println("      " + VERSION);
        System.out.println("=====================================");
        System.out.println("Welcome to the Palindrome Checker Application!");
        System.out.println("-------------------------------------");
        System.out.println("UC1 Completed Successfully.\n");

        // ================= UC2 =================
        String uc2Word = "level";
        String uc2Reversed = "";

        for (int i = uc2Word.length() - 1; i >= 0; i--) {
            uc2Reversed += uc2Word.charAt(i);
        }

        System.out.println("UC2: " + (uc2Word.equals(uc2Reversed)
                ? "Palindrome"
                : "Not Palindrome"));
        System.out.println("UC2 Completed Successfully.\n");

        // ================= UC3 =================
        String uc3Word = "Level";
        String uc3Reversed = "";

        for (int i = uc3Word.length() - 1; i >= 0; i--) {
            uc3Reversed += uc3Word.charAt(i);
        }

        System.out.println("UC3: " + (uc3Word.equalsIgnoreCase(uc3Reversed)
                ? "Palindrome (Case-Insensitive)"
                : "Not Palindrome"));
        System.out.println("UC3 Completed Successfully.\n");

        // ================= UC4 =================
        String uc4Word = "Level";
        char[] charArray = uc4Word.toLowerCase().toCharArray();

        boolean isPalindromeUC4 = true;
        int start = 0, end = charArray.length - 1;

        while (start < end) {
            if (charArray[start] != charArray[end]) {
                isPalindromeUC4 = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("UC4: " + (isPalindromeUC4
                ? "Palindrome (Using char array)"
                : "Not Palindrome"));
        System.out.println("UC4 Completed Successfully.\n");

        // ================= UC5 =================
        String uc5Word = "Level";
        String lowerCaseUC5 = uc5Word.toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : lowerCaseUC5.toCharArray()) {
            stack.push(ch);
        }

        String uc5Reversed = "";
        while (!stack.isEmpty()) {
            uc5Reversed += stack.pop();
        }

        System.out.println("UC5: " + (lowerCaseUC5.equals(uc5Reversed)
                ? "Palindrome (Using Stack)"
                : "Not Palindrome"));
        System.out.println("UC5 Completed Successfully.\n");

        // ================= UC6 =================
        String uc6Word = "Level";
        String lowerCaseUC6 = uc6Word.toLowerCase();

        Stack<Character> uc6Stack = new Stack<>();
        Queue<Character> uc6Queue = new LinkedList<>();

        for (char ch : lowerCaseUC6.toCharArray()) {
            uc6Stack.push(ch);
            uc6Queue.add(ch);
        }

        boolean isPalindromeUC6 = true;

        while (!uc6Queue.isEmpty()) {
            if (!uc6Queue.remove().equals(uc6Stack.pop())) {
                isPalindromeUC6 = false;
                break;
            }
        }

        System.out.println("UC6: " + (isPalindromeUC6
                ? "Palindrome (Using Queue + Stack)"
                : "Not Palindrome"));
        System.out.println("UC6 Completed Successfully.\n");

        // ================= UC7 =================
        String uc7Word = "Level";
        String lowerCaseUC7 = uc7Word.toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters
        for (char ch : lowerCaseUC7.toCharArray()) {
            deque.addLast(ch);
        }

        boolean isPalindromeUC7 = true;

        // Compare front & rear
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindromeUC7 = false;
                break;
            }
        }

        System.out.println("UC7: " + (isPalindromeUC7
                ? "Palindrome (Using Deque)"
                : "Not Palindrome"));
        System.out.println("UC7 Completed Successfully.\n");

        System.out.println("All Use Cases Completed Successfully.");
    }
}