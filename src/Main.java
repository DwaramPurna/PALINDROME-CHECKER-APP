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

    // ================= UC11: Count palindrome words in a sentence =================
    public static void countPalindromeWords(String sentence) {
        String[] words = sentence.toLowerCase().split("\\s+");
        int count = 0;

        for (String word : words) {
            String reversed = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                reversed += word.charAt(i);
            }
            if (word.equals(reversed)) {
                count++;
                System.out.println("Palindrome word: " + word);
            }
        }

        System.out.println("UC11: Total palindrome words in sentence: " + count);
        System.out.println("UC11 Completed Successfully.\n");
    }

    public static void main(String[] args) {

        // ================= UC1 =================
        System.out.println("=====================================");
        System.out.println("       Palindrome Checker App");
        System.out.println("       Version 1.0");
        System.out.println("=====================================");
        System.out.println("Welcome to the Palindrome Checker Application!");
        System.out.println("This application validates whether a given string is a palindrome.");
        System.out.println("-------------------------------------");
        System.out.println("UC1 Completed Successfully.\n");

        // ================= UC2 =================
        String uc2Word = "level";

        String reversed = "";
        for(int i = uc2Word.length()-1; i >= 0; i--){
            reversed += uc2Word.charAt(i);
        }

        if(uc2Word.equals(reversed))
            System.out.println("UC2: " + uc2Word + " is Palindrome");
        else
            System.out.println("UC2: " + uc2Word + " is NOT Palindrome");

        System.out.println("UC2 Completed Successfully.\n");

        // ================= UC3 =================
        String uc3Word = "Level";

        reversed = "";
        for(int i = uc3Word.length()-1; i >= 0; i--){
            reversed += uc3Word.charAt(i);
        }

        if(uc3Word.equalsIgnoreCase(reversed))
            System.out.println("UC3: " + uc3Word + " is Palindrome (Case Insensitive)");
        else
            System.out.println("UC3: " + uc3Word + " is NOT Palindrome");

        System.out.println("UC3 Completed Successfully.\n");

        // ================= UC4 =================
        String uc4Word = "Level";
        char[] arr = uc4Word.toLowerCase().toCharArray();

        int start = 0;
        int end = arr.length-1;
        boolean isPalindrome = true;

        while(start < end){
            if(arr[start] != arr[end]){
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if(isPalindrome)
            System.out.println("UC4: " + uc4Word + " is Palindrome (Char Array)");
        else
            System.out.println("UC4: " + uc4Word + " is NOT Palindrome");

        System.out.println("UC4 Completed Successfully.\n");

        // ================= UC5 (Stack) =================
        String uc5Word = "Level".toLowerCase();

        Stack<Character> stack = new Stack<>();

        for(char c : uc5Word.toCharArray()){
            stack.push(c);
        }

        reversed = "";
        while(!stack.isEmpty()){
            reversed += stack.pop();
        }

        if(uc5Word.equals(reversed))
            System.out.println("UC5: Palindrome using Stack");
        else
            System.out.println("UC5: NOT Palindrome using Stack");

        System.out.println("UC5 Completed Successfully.\n");

        // ================= UC6 (Queue + Stack) =================
        String uc6Word = "Level".toLowerCase();

        Stack<Character> s = new Stack<>();
        Queue<Character> q = new LinkedList<>();

        for(char c : uc6Word.toCharArray()){
            s.push(c);
            q.add(c);
        }

        boolean result = true;

        while(!q.isEmpty()){
            if(q.remove() != s.pop()){
                result = false;
                break;
            }
        }

        if(result)
            System.out.println("UC6: Palindrome using Stack + Queue");
        else
            System.out.println("UC6: NOT Palindrome");

        System.out.println("UC6 Completed Successfully.\n");

        // ================= UC7 (Deque) =================
        String uc7Word = "Level".toLowerCase();

        Deque<Character> deque = new LinkedList<>();

        for(char c : uc7Word.toCharArray()){
            deque.add(c);
        }

        boolean isDequePalindrome = true;

        while(deque.size() > 1){
            char first = deque.removeFirst();
            char last = deque.removeLast();

            if(first != last){
                isDequePalindrome = false;
                break;
            }
        }

        if(isDequePalindrome)
            System.out.println("UC7: Palindrome using Deque");
        else
            System.out.println("UC7: NOT Palindrome");

        System.out.println("UC7 Completed Successfully.\n");

        // ================= UC8 (Linked List) =================
        String uc8Word = "level".toLowerCase();

        Node head = null, tail = null;

        for(char c : uc8Word.toCharArray()){
            Node newNode = new Node(c);

            if(head == null){
                head = tail = newNode;
            }else{
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node current = slow;

        while(current != null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        Node firstHalf = head;
        Node secondHalf = prev;

        boolean isLinkedPalindrome = true;

        while(secondHalf != null){
            if(firstHalf.data != secondHalf.data){
                isLinkedPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        if(isLinkedPalindrome)
            System.out.println("UC8: Palindrome using Linked List");
        else
            System.out.println("UC8: NOT Palindrome");

        System.out.println("UC8 Completed Successfully.\n");

        // ================= UC11 =================
        System.out.println("\nUC11: Enter a sentence to count palindrome words:");
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        countPalindromeWords(sentence);
    }
}