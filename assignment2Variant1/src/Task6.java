import java.util.Scanner;

public class Task6 {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static TreeNode findLCA(TreeNode root, int p, int q) {
        TreeNode current = root;

        while (current != null) {
            if (p < current.value && q < current.value) {
                current = current.left;
            } else if (p > current.value && q > current.value) {
                current = current.right;
            } else {
                return current;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of nodes in the BST: ");
        int n = scanner.nextInt();
        System.out.println("Enter " + n + " values to insert into the BST:");
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            root = insert(root, value);
        }
        System.out.print("Enter the first node value (p): ");
        int p = scanner.nextInt();
        System.out.print("Enter the second node value (q): ");
        int q = scanner.nextInt();
        TreeNode lca = findLCA(root, p, q);
        if (lca != null) {
            System.out.println("Lowest Common Ancestor of " + p + " and " + q + " is: " + lca.value);
        } else {
            System.out.println("One or both values not found in the BST.");
        }

        scanner.close();
    }
}
