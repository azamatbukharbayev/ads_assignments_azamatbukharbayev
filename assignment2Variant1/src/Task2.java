import java.util.Scanner;

public class Task2 {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("List is empty, nothing to reverse.");
            scanner.close();
            return;
        }
        System.out.println("Enter " + n + " elements:");
        Node head = new Node(scanner.nextInt());
        Node tail = head;

        for (int i = 1; i < n; i++) {
            Node newNode = new Node(scanner.nextInt());
            tail.next = newNode;
            tail = newNode;
        }
        System.out.print("Original list:  ");
        printList(head);
        head = reverseList(head);
        System.out.print("Reversed list:  ");
        printList(head);
        scanner.close();
    }
}
