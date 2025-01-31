package code;

/**
 * Represents a node in a linked grid structure.
 * Each node has links to adjacent nodes (right, left, up, down)
 * and stores an integer value.
 */
public class Node {
    private int data;  // Stores the node's value
    private Node right; // Reference to the right node
    private Node left;  // Reference to the left node
    private Node up;    // Reference to the upper node
    private Node down;  // Reference to the lower node
    private boolean same; // A boolean flag (purpose unclear)

    /**
     * Constructor to initialize a node with a given value.
     * Links are initially set to null.
     */
    public Node(int data) {
        this.data = data;
        right = null;
        left = null;
        up = null;
        down = null;
    }

    // Getter and setter for same flag
    public boolean isSame() {
        return same;
    }
    public void setSame(boolean same) {
        this.same = same;
    }

    // Getter and setter for node data
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }

    // Getter and setter for right node
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }

    // Getter and setter for left node
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }

    // Getter and setter for upper node
    public Node getUp() {
        return up;
    }
    public void setUp(Node up) {
        this.up = up;
    }

    // Getter and setter for lower node
    public Node getDown() {
        return down;
    }
    public void setDown(Node down) {
        this.down = down;
    }
}
