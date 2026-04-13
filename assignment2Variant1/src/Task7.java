import java.util.Scanner;
import java.util.PriorityQueue;

public class Task7 {
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        // Edge case: no lists provided
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                (a, b) -> a.data - b.data
        );
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();

            tail.next = smallest;
            tail = tail.next;
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
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
        System.out.print("Enter the number of sorted linked lists (K): ");
        int k = scanner.nextInt();

        ListNode[] lists = new ListNode[k];
        for (int i = 0; i < k; i++) {
            System.out.print("Enter the number of elements in list " + (i + 1) + ": ");
            int n = scanner.nextInt();

            if (n <= 0) {
                lists[i] = null;
                continue;
            }

            System.out.println("Enter " + n + " sorted elements for list " + (i + 1) + ":");
            ListNode head = new ListNode(scanner.nextInt());
            ListNode tail = head;

            for (int j = 1; j < n; j++) {
                ListNode newNode = new ListNode(scanner.nextInt());
                tail.next = newNode;
                tail = newNode;
            }

            lists[i] = head;
        }
        System.out.println("\nInput lists:");
        for (int i = 0; i < k; i++) {
            System.out.print("  List " + (i + 1) + ": ");
            if (lists[i] == null) {
                System.out.println("(empty)");
            } else {
                printList(lists[i]);
            }
        }
        ListNode merged = mergeKLists(lists);
        System.out.print("\nMerged sorted list: ");
        if (merged == null) {
            System.out.println("(empty)");
        } else {
            printList(merged);
        }

        scanner.close();
    }
}
