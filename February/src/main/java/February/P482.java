package February;

public class P482 {
    public static void main(String[] args) {
        printDesc();

        /* build example tree */
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(10);

        //      5
        //    /   \
        //   3     8
        //  / \   / \
        // 2   4 6   10

        System.out.println("Sum of range [4, 9]: " + sumTree(root, 4, 9));
    }

    public static void printDesc() {
        System.out.println("Given a binary search tree and a range [a, b] (inclusive), return the sum of the elements of the binary search tree within the range.");
    }

    public static int sumTree(Node root, int start, int end) {
        int sum = 0;
        // base case:
        if (root == null) {
            return 0;
        }
        // check start of range for left child
        if (root.data > start) {
            sum += sumTree(root.left, start, end);
        }
        // check end of range for right child
        if (root.data < end) {
            sum += sumTree(root.right, start, end);
        }
        // check root
        if (root.data >= start && root.data <= end) {
            sum += root.data;
        }

        return sum;
    }

    public static class Node {
        public int data;
        public Node left;
        public Node right;

        Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
