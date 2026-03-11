import java.util.*;

public class Main {

    // ================= UC8 Linked List Node =================
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // ================= UC12 Strategy Pattern =================
    interface PalindromeStrategy {
        boolean isPalindrome(String input);
    }

    static class StackStrategy implements PalindromeStrategy {
        @Override
        public boolean isPalindrome(String input) {
            input = input.toLowerCase();
            Stack<Character> stack = new Stack<>();
            for (char c : input.toCharArray()) stack.push(c);

            String reversed = "";
            while (!stack.isEmpty()) reversed += stack.pop();

            return input.equals(reversed);
        }
    }

    static class DequeStrategy implements PalindromeStrategy {
        @Override
        public boolean isPalindrome(String input) {
            input = input.toLowerCase();
            Deque<Character> deque = new LinkedList<>();
            for (char c : input.toCharArray()) deque.add(c);

            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) return false;
            }
            return true;
        }
    }

    static class PalindromeChecker {
        private PalindromeStrategy strategy;

        public PalindromeChecker(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean check(String input) {
            return strategy.isPalindrome(input);
        }
    }

    // ================= UC11: Count palindrome words =================
    public static void countPalindromeWords(String sentence) {
        String[] words = sentence.toLowerCase().split("\\s+");
        int count = 0;
        for (String word : words) {
            String reversed = "";
            for (int i = word.length() - 1; i >= 0; i--) reversed += word.charAt(i);
            if (word.equals(reversed)) {
                count++;
                System.out.println("Palindrome word: " + word);
            }
        }
        System.out.println("UC11: Total palindrome words in sentence: " + count);
        System.out.println("UC11 Completed Successfully.\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ================= UC1 =================
        System.out.println("=====================================");
        System.out.println("       Palindrome Checker App");
        System.out.println("       Version 1.0");
        System.out.println("=====================================");
        System.out.println("Welcome to the Palindrome Checker Application!");
        System.out.println("This application validates whether a given string is a palindrome.");
        System.out.println("-------------------------------------");
        System.out.println("UC1 Completed Successfully.\n");

        // ================= UC2 Example =================
        String uc2Word = "level";
        String reversed = "";
        for (int i = uc2Word.length() - 1; i >= 0; i--) reversed += uc2Word.charAt(i);
        System.out.println("UC2: " + uc2Word + " is " + (uc2Word.equals(reversed) ? "Palindrome" : "NOT Palindrome"));
        System.out.println("UC2 Completed Successfully.\n");

        // ================= UC3 Example =================
        String uc3Word = "Level";
        reversed = "";
        for (int i = uc3Word.length() - 1; i >= 0; i--) reversed += uc3Word.charAt(i);
        System.out.println("UC3: " + uc3Word + " is " + (uc3Word.equalsIgnoreCase(reversed) ? "Palindrome (Case Insensitive)" : "NOT Palindrome"));
        System.out.println("UC3 Completed Successfully.\n");

        // ================= UC4: Char Array =================
        String uc4Word = "Level";
        char[] arr = uc4Word.toLowerCase().toCharArray();
        boolean isPalindrome = true;
        int start = 0, end = arr.length - 1;
        while (start < end) {
            if (arr[start] != arr[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        System.out.println("UC4: " + uc4Word + " is " + (isPalindrome ? "Palindrome (Char Array)" : "NOT Palindrome"));
        System.out.println("UC4 Completed Successfully.\n");

        // ================= UC5: Stack =================
        String uc5Word = "Level".toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : uc5Word.toCharArray()) stack.push(c);
        reversed = "";
        while (!stack.isEmpty()) reversed += stack.pop();
        System.out.println("UC5: " + (uc5Word.equals(reversed) ? "Palindrome using Stack" : "NOT Palindrome using Stack"));
        System.out.println("UC5 Completed Successfully.\n");

        // ================= UC6: Queue + Stack =================
        String uc6Word = "Level".toLowerCase();
        Stack<Character> s = new Stack<>();
        Queue<Character> q = new LinkedList<>();
        for (char c : uc6Word.toCharArray()) {
            s.push(c);
            q.add(c);
        }
        boolean result = true;
        while (!q.isEmpty()) {
            if (q.remove() != s.pop()) {
                result = false;
                break;
            }
        }
        System.out.println("UC6: " + (result ? "Palindrome using Stack + Queue" : "NOT Palindrome"));
        System.out.println("UC6 Completed Successfully.\n");

        // ================= UC7: Deque =================
        String uc7Word = "Level".toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char c : uc7Word.toCharArray()) deque.add(c);
        boolean isDequePalindrome = true;
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                isDequePalindrome = false;
                break;
            }
        }
        System.out.println("UC7: " + (isDequePalindrome ? "Palindrome using Deque" : "NOT Palindrome"));
        System.out.println("UC7 Completed Successfully.\n");

        // ================= UC8: Linked List =================
        String uc8Word = "level".toLowerCase();
        Node head = null, tail = null;
        for (char c : uc8Word.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) head = tail = newNode;
            else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null, current = slow;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        Node firstHalf = head, secondHalf = prev;
        boolean isLinkedPalindrome = true;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isLinkedPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        System.out.println("UC8: " + (isLinkedPalindrome ? "Palindrome using Linked List" : "NOT Palindrome"));
        System.out.println("UC8 Completed Successfully.\n");

        // ================= UC11 =================
        System.out.println("\nUC11: Enter a sentence to count palindrome words:");
        String sentence = sc.nextLine();
        countPalindromeWords(sentence);

        // ================= UC12 =================
        System.out.println("\nUC12: Enter a word to check using Strategy Pattern:");
        String uc12Word = sc.nextLine();

        // Choose strategy at runtime
        PalindromeChecker checker = new PalindromeChecker(new StackStrategy());
        System.out.println("Using StackStrategy: " + (checker.check(uc12Word) ? "Palindrome" : "NOT Palindrome"));

        checker.setStrategy(new DequeStrategy());
        System.out.println("Using DequeStrategy: " + (checker.check(uc12Word) ? "Palindrome" : "NOT Palindrome"));
    }
}