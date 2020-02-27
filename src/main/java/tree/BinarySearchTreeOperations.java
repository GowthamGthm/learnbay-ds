
/*
ref- https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/trees.html
*/

import java.util.Comparator;

public class BinarySearchTreeOperations<T extends Comparable<T>> {

    private Node<T> root;

    BinarySearchTreeOperations() {
        this.root = null;
    }

    private static class Node<T> {
        private T value;
        private Node<T> left, right;

        public Node(T data) {
            this.value = data;
            left = right = null;
        }
    }

    public void insert(T value) {
        if (root == null) {
            root = new Node<T>(value);
            return;
        }
        Node<T> temp = root;
        Node<T> insertAtNode = temp;
        while (temp != null) {
            insertAtNode = temp;
            if (value.compareTo(temp.value) > 0) {

                temp = temp.right;
            } else if (value.compareTo(temp.value) < 0) {
                temp = temp.left;

            } else {
                // duplicate element
                return;
            }


        }
        if (insertAtNode.value.compareTo(value) > 0) {
            insertAtNode.left = new Node<>(value);
        } else {
            insertAtNode.right = new Node<>(value);
        }

    }

    public void levelOrderTraversal(Node<T> root) {

        if (root == null) {
            return;
        }

        Node<T> left = root.left;
        Node<T> right = root.right;
        System.out.println(root.value);
        levelOrderTraversal(left);
        levelOrderTraversal(right);

    }

    public static void main(String[] args) {
        BinarySearchTreeOperations<Integer> binarySearchTreeOperations = new BinarySearchTreeOperations<>();
        binarySearchTreeOperations.insert(10);
        binarySearchTreeOperations.insert(20);
        binarySearchTreeOperations.insert(21);
        binarySearchTreeOperations.insert(11);
        binarySearchTreeOperations.insert(15);
        binarySearchTreeOperations.insert(30);
        binarySearchTreeOperations.levelOrderTraversal(binarySearchTreeOperations.root);

    }

}

