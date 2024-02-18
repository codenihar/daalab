import java.util.*;

class TreeNode {
    int key;
    TreeNode left, right;
    public TreeNode(int key) { this.key = key; }
}

public class BST {
    TreeNode root;

    public void insert(int key) {
        System.out.println("inserting "+ key );
        root = insertRec(root, key);
    }

    public TreeNode insertRec(TreeNode root, int key) {
        if (root == null) return new TreeNode(key);
        if (key < root.key) root.left = insertRec(root.left, key);
        else if (key > root.key) root.right = insertRec(root.right, key);
        return root;
    }

    public void delete(int key) {
        System.out.println("deleting "+ key );
        root = deleteRec(root, key);
    }

    public TreeNode deleteRec(TreeNode root, int key) {
        if (root == null) return root;
        if (key < root.key) root.left = deleteRec(root.left, key);
        else if (key > root.key) root.right = deleteRec(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    public int minValue(TreeNode root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    public void printInOrder() {
        System.out.print("In-order traversal: ");
        printInOrderRec(root);
        System.out.println();
    }

    public void printInOrderRec(TreeNode root) {
        if (root != null) {
            printInOrderRec(root.left);
            System.out.print(root.key + " ");
            printInOrderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.printInOrder();
        tree.delete(10);
        tree.printInOrder();
    }
}
