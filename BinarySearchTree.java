import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private Node root;

    private static class Node {
        String data;
        Node left;
        Node right;

        Node(String data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public void insert(String data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, String data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public boolean search(String data) {
        Node result = searchRec(root, data);
        return result != null;
    }

    private Node searchRec(Node root, String data) {
        if (root == null || root.data.equals(data)) {
            return root;
        }
        if (data.compareTo(root.data) < 0) {
            return searchRec(root.left, data);
        }
        return searchRec(root.right, data);
    }

    public void delete(String data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node root, String data) {
        if (root == null) {
            return root;
        }
        if (data.compareTo(root.data) < 0) {
            root.left = deleteRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = deleteRec(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private String minValue(Node root) {
        String minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }
}
