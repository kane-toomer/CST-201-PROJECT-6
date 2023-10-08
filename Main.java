import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Read the file and insert each word into the BST
        try (BufferedReader br = new BufferedReader(new FileReader("text.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.length() > 0) {
                        bst.insert(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the contents of the tree using an in-order traversal
        System.out.println("Contents of the BST (in-order traversal):");
        bst.inorder();
        System.out.println("\n");

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a word to search or 'exit' to quit:");
            String word = sc.next().toLowerCase();

            if (word.equals("exit")) {
                break;
            }

            if (bst.search(word)) {
                System.out.println(word + " is present in the BST.");
            } else {
                System.out.println(word + " is not present in the BST.");
            }
        }

        while (true) {
            System.out.println("Enter a word to delete or 'exit' to quit:");
            String word = sc.next().toLowerCase();

            if (word.equals("exit")) {
                break;
            }

            if (bst.search(word)) {
                bst.delete(word);
                System.out.println(word + " has been deleted from the BST.");
                System.out.println("Updated BST:");
                bst.inorder();
                System.out.println();
            } else {
                System.out.println(word + " is not present in the BST.");
            }
        }
        sc.close();
    }
}
