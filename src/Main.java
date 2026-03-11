import java.util.*;

public class Main {

    // UC9 – Recursive Palindrome Function
    static boolean recursivePalindrome(String str, int start, int end) {
        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return recursivePalindrome(str, start + 1, end - 1);
    }

    // Node class for UC8 Linked List
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

        System.out.println("Palindrome Checker App");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // UC2 Basic
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println("UC2 Basic: " + input.equals(reversed));

        // UC3 Case Insensitive
        System.out.println("UC3 Case Insensitive: " +
                input.equalsIgnoreCase(reversed));

        // UC4 Character Array
        char[] arr = input.toCharArray();
        boolean isPal = true;

        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                isPal = false;
                break;
            }
        }

        System.out.println("UC4 Char Array: " + isPal);

        // UC5 Stack
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray())
            stack.push(c);

        String stackRev = "";
        while (!stack.isEmpty())
            stackRev += stack.pop();

        System.out.println("UC5 Stack: " + input.equals(stackRev));

        // UC6 Queue + Stack
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack2 = new Stack<>();

        for (char c : input.toCharArray()) {
            queue.add(c);
            stack2.push(c);
        }

        boolean qsPal = true;
        while (!queue.isEmpty()) {
            if (queue.remove() != stack2.pop()) {
                qsPal = false;
                break;
            }
        }

        System.out.println("UC6 Queue + Stack: " + qsPal);

        // UC7 Deque
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray())
            deque.add(c);

        boolean dqPal = true;

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                dqPal = false;
                break;
            }
        }

        System.out.println("UC7 Deque: " + dqPal);

        // UC8 Linked List
        System.out.println("UC8 Linked List: " + linkedListPalindrome(input));

        // UC9 Recursion
        boolean recPal = recursivePalindrome(input, 0, input.length() - 1);
        System.out.println("UC9 Recursion: " + recPal);

        sc.close();
    }
}