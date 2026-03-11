import java.util.*;

public class Main {

    // UC9 Recursive Palindrome
    static boolean recursivePalindrome(String str, int start, int end) {
        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return recursivePalindrome(str, start + 1, end - 1);
    }

    // UC8 Linked List Node
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node createLinkedList(String str) {
        Node head = null, temp = null;

        for (char c : str.toCharArray()) {
            Node newNode = new Node(c);

            if (head == null) {
                head = newNode;
                temp = head;
            } else {
                temp.next = newNode;
                temp = temp.next;
            }
        }
        return head;
    }

    static boolean linkedListPalindrome(String str) {
        Node head = createLinkedList(str);

        String original = "";
        Node temp = head;

        while (temp != null) {
            original += temp.data;
            temp = temp.next;
        }

        String reversed = new StringBuilder(original).reverse().toString();

        return original.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // UC1 Welcome Message
        System.out.println("===== Palindrome Checker App =====");

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // UC2 Basic Palindrome
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println("UC2 Basic Palindrome: " + input.equals(reversed));

        // UC3 Case Insensitive Palindrome
        System.out.println("UC3 Case Insensitive: " + input.equalsIgnoreCase(reversed));

        // UC4 Character Array Method
        char[] arr = input.toCharArray();
        boolean charArrayPalindrome = true;

        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                charArrayPalindrome = false;
                break;
            }
        }

        System.out.println("UC4 Character Array: " + charArrayPalindrome);

        // UC5 Stack Method
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        String stackReverse = "";

        while (!stack.isEmpty()) {
            stackReverse += stack.pop();
        }

        System.out.println("UC5 Stack: " + input.equals(stackReverse));

        // UC6 Queue + Stack
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack2 = new Stack<>();

        for (char c : input.toCharArray()) {
            queue.add(c);
            stack2.push(c);
        }

        boolean queueStackPalindrome = true;

        while (!queue.isEmpty()) {
            if (queue.remove() != stack2.pop()) {
                queueStackPalindrome = false;
                break;
            }
        }

        System.out.println("UC6 Queue + Stack: " + queueStackPalindrome);

        // UC7 Deque Method
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.add(c);
        }

        boolean dequePalindrome = true;

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                dequePalindrome = false;
                break;
            }
        }

        System.out.println("UC7 Deque: " + dequePalindrome);

        // UC8 Linked List
        System.out.println("UC8 Linked List: " + linkedListPalindrome(input));

        // UC9 Recursion
        boolean recursiveResult = recursivePalindrome(input, 0, input.length() - 1);
        System.out.println("UC9 Recursion: " + recursiveResult);

        // UC10 Ignore Spaces and Case
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        String normalizedReverse = new StringBuilder(normalized).reverse().toString();

        boolean uc10Palindrome = normalized.equals(normalizedReverse);

        System.out.println("UC10 Ignore Spaces & Case: " + uc10Palindrome);

        sc.close();
    }
}