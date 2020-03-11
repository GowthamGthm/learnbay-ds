
/*
ref- https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/trees.html
*/

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

    public Node<T> insertWithRecursion(T value) {
        return null;
    }

    public void preOrderTraversal(Node<T> root) {

        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }


    public boolean search(T value) {
        return search(root, value) != null;
    }

    private Node<T> search(Node<T> root, T value) {
        Node<T> temp = root;
        while (temp != null) {
            if (temp.value.compareTo(value) > 0) {
                temp = temp.left;
            } else if (temp.value.compareTo(value) < 0) {
                temp = temp.right;
            } else {
                break;
            }

        }
        return temp;
    }

    public void postOrderTraversal(Node<T> root) {

        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value);

    }

    public void inOrderTraversal(Node<T> root) {

        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }

    public boolean deleteANodeInBinaryTree(T value) {

        return deleteNode(root, value) != null;

    }

    /*
     * Case 1: Node to be deleted has is a leaf node (no children).
     * Node to be deleted has one child (eight left or right child node).
     * Case 3: Node to be deleted has two nodes.*/

    Node<T> deleteNode(Node<T> root, T key) {
        if (root == null) {
            return null;
        }

        Node<T> currNode = root;
        Node<T> parent = null;
        while (currNode != null && currNode.value.compareTo(key) != 0) {
            parent = currNode;
            if (currNode.value.compareTo(key) > 0) {
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }

        if (currNode == null) {
            return root;
        }
        boolean isLeftNode = false;
        if (parent != null && parent.left == currNode) {
            isLeftNode = true;
        }


        // case 1 if No chilld
        Node<T> temp = null;
        if (currNode.left == null && currNode.right == null) {
            // if root node
            if (parent == null) {
                this.root = null;
            } else if (isLeftNode) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return root;
        }


        //	case 2 a)  has one right child

        else if (currNode.left == null) {
            temp = currNode.right;
            // if root node
            if (parent == null) {
                this.root = temp;
            } else if (isLeftNode) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
            return root;
        }

        //	case 3 a)  has one left child

        else if (currNode.right == null) {
            temp = currNode.left;
            // if root node
            if (parent == null) {
                this.root = temp;
            } else if (isLeftNode) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
            return root;
        }


        //	case 3 has 2 child

        else {
            Node<T> child = currNode.left;
            parent = null;
            while (child.right != null) {
                parent = child;
                child = child.right;
            }
            currNode.value = child.value;
            if (parent == null) {
                currNode.left = child.left;

            } else {
                parent.right = child.left;

            }
            child.left = null;
            return root;
        }

    }




    public static void main(String[] args) {
        BinarySearchTreeOperations<Integer> binarySearchTreeOperations = new BinarySearchTreeOperations<>();
        //84 42 49 24 25 73 23 55 36 22 58 66 48
        binarySearchTreeOperations.insert(84);
        binarySearchTreeOperations.insert(42);
        binarySearchTreeOperations.insert(49);
        binarySearchTreeOperations.insert(24);
        binarySearchTreeOperations.insert(25);
        binarySearchTreeOperations.insert(73);
        binarySearchTreeOperations.insert(23);
        binarySearchTreeOperations.insert(55);
        binarySearchTreeOperations.insert(36);
        binarySearchTreeOperations.insert(22);
        binarySearchTreeOperations.insert(58);
        binarySearchTreeOperations.insert(66);
        binarySearchTreeOperations.insert(48);
        binarySearchTreeOperations.preOrderTraversal(binarySearchTreeOperations.root);
        System.out.println("...................................................");
        binarySearchTreeOperations.postOrderTraversal(binarySearchTreeOperations.root);
        System.out.println("...................................................");
        binarySearchTreeOperations.inOrderTraversal(binarySearchTreeOperations.root);
        System.out.println("...................................................");
        System.out.println(binarySearchTreeOperations.search(10));
        System.out.println("...................................................");
        System.out.println(binarySearchTreeOperations.search(100));
        System.out.println("...................................................");
        System.out.println(binarySearchTreeOperations.deleteANodeInBinaryTree(84));
        System.out.println("...................................................");
        binarySearchTreeOperations.inOrderTraversal(binarySearchTreeOperations.root);
        System.out.println("...................................................");
        // System.out.println(binarySearchTreeOperations.deleteANodeInBinaryTree(10));


    }

}

