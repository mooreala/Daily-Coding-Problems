package January;

public class P394 {
    
    public void printDescription() {
        System.out.println("Given a binary tree and an integer k, return whether there exists a root-to-leaf path that sums up to k.");
    }

    public static void main(String[] args) {
        int sum = 18;

        // example binary tree:
        //           8
        //          / \
        //         4   13
        //        / \   \
        //        2   6   19

        P394 p = new P394();
        p.printDescription();

        // construct above tree
        Node root = p.new Node(8);
        root.left = p.new Node(4);
        root.left.left = p.new Node(2);
        root.left.right = p.new Node(6);
        root.right = p.new Node(13);
        root.right.right = p.new Node(19);

        BinaryTree tree = p.new BinaryTree(root);

        boolean result = tree.hasPathToSum(tree.root, sum);

        if (result == true) System.out.println("true");
        else System.out.println("false");
    }

    private class Node {
        int value;
        Node left;
        Node right;

        Node (int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private class BinaryTree {
        Node root;

        BinaryTree(Node root) {
            this.root = root;
        }

        public boolean hasPathToSum(Node node, int sum) {
            boolean ans = false;

            int subSum = sum - node.value;

            // check if sub-sum is 0 at a leaf node
            if (subSum == 0 && node.left == null && node.right == null) {
                return true;
            } if (node.left != null) {
                ans = ans || hasPathToSum(node.left, subSum);  
            } if (node.right != null) {
                ans = ans || hasPathToSum(node.right, subSum);
            }
            return ans;
        }
    }
}
