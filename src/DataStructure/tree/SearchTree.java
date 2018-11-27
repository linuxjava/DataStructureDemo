package DataStructure.tree;

/**
 * 搜索二叉树
 */
public class SearchTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    /**
     * 插入节点
     *
     * @param key
     */
    public void insert(int key) {
        Node newNode = new Node(key);

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parant;
            while (true) {
                parant = current;

                if (key <= current.data) {
                    current = current.left;
                    if (current == null) {
                        parant.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parant.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 查找节点
     *
     * @param key
     * @return
     */
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.data == key) {
                return current;
            } else if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    public void preTraversal(Node current) {
        if (current != null) {
            System.out.println(current.data);
            middleTraversal(current.left);
            middleTraversal(current.right);
        }
    }

    public void middleTraversal(Node current) {
        if (current != null) {
            middleTraversal(current.left);
            System.out.println(current.data);
            middleTraversal(current.right);
        }
    }

    public void afterTraversal(Node current) {
        if (current != null) {
            middleTraversal(current.left);
            middleTraversal(current.right);
            System.out.println(current.data);
        }
    }

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
}
