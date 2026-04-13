import java.util.Scanner;
import java.util.Stack;

public class Task4 {
    static class MyQueue {
        private Stack<Integer> stackIn;
        private Stack<Integer> stackOut;
        public MyQueue() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        public void enqueue(int value) {
            stackIn.push(value);
            System.out.println("Enqueued: " + value);
        }

        private void transferIfNeeded() {
            if (stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
        }

        public int dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty! Cannot dequeue.");
            }
            transferIfNeeded();
            return stackOut.pop();
        }

        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty! Cannot peek.");
            }
            transferIfNeeded();
            return stackOut.peek();
        }

        public boolean isEmpty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }

        public int size() {
            return stackIn.size() + stackOut.size();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyQueue queue = new MyQueue();

        System.out.println("===== Queue Using Two Stacks =====");
        System.out.println("Commands: enqueue <value>, dequeue, peek, size, exit");
        while (true) {
            System.out.print("\nEnter command: ");
            String command = scanner.next().toLowerCase();

            if (command.equals("enqueue")) {
                int value = scanner.nextInt();
                queue.enqueue(value);

            } else if (command.equals("dequeue")) {
                try {
                    int value = queue.dequeue();
                    System.out.println("Dequeued: " + value);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }

            } else if (command.equals("peek")) {
                try {
                    int value = queue.peek();
                    System.out.println("Front element: " + value);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }

            } else if (command.equals("size")) {
                System.out.println("Queue size: " + queue.size());

            } else if (command.equals("exit")) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Unknown command. Try: enqueue, dequeue, peek, size, exit");
            }
        }

        scanner.close();
    }
}
