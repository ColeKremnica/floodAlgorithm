package code;

/**
 * Represents a linked grid of nodes, each containing a random value.
 * Supports flooding (changing connected values) and checking for a win condition.
 */
public class LinkedGrid {

    /**
     * Generates a random integer between 1 and 6.
     * The loop runs 100 times but only the last generated number is used.
     * @return A random number between 1 and 6.
     */
    public static int RNG() {
        int random = 0;
        int min = 1;
        int max = 6;

            random = (int) (Math.random() * (max - min + 1) + min); // RNG logic

        return random;
    }

    static Node start; // Starting node of the grid

    /**
     * Constructs a linked grid of given size, filling it with random values.
     * @param size The size of the grid (square grid of size x size).
     */
    public LinkedGrid(int size) {
        if (size > 0) {
            start = new Node(RNG());
            Node temp = start;
            Node row = start;

            // Create the first row
            for (int x = 0; x < size - 1; x++) {
                temp.setRight(new Node(RNG()));
                temp.getRight().setLeft(temp);
                temp = temp.getRight();
            }

            // Create remaining rows and link them
            for (int x = 0; x < size - 1; x++) {
                row.setDown(new Node(RNG()));
                row.getDown().setUp(row);
                row = row.getDown();
                temp = row;

                for (int y = 0; y < size - 1; y++) {
                    temp.setRight(new Node(RNG()));
                    temp.getRight().setLeft(temp);
                    temp.getRight().setUp(temp.getUp().getRight());
                    temp.getRight().getUp().setDown(temp.getRight());
                    temp = temp.getRight();
                }
            }
        }
    }

    /**
     * Displays the grid in a structured format.
     */
    public void display() {
        Node temp = start;
        Node marker = start;

        while (marker != null) {
            while (temp != null) {
                System.out.print(temp.getData() + "  ");
                temp = temp.getRight();
            }
            System.out.println();
            temp = marker.getDown();
            marker = temp;
        }
    }

    /**
     * Checks if all nodes in the grid contain the same value.
     * @param color The target value to check for.
     * @return true if all nodes match the given value, false otherwise.
     */
    public boolean winCheck(int color) {
        Node temp = start;
        Node marker = start;

        while (marker != null) {
            while (temp != null) {
                if (temp.getData() != color) {
                    return false;
                }
                temp = temp.getRight();
            }
            temp = marker.getDown();
            marker = temp;
        }
        return true;
    }

    /**
     * Initiates a flood fill operation, changing connected nodes with the same value.
     * @param data The new value to assign to the flooded region.
     */
    public void flood(int data) {
        floodNode(data, start, 0);
        display();
    }

    /**
     * Recursively changes connected nodes with the same value to the given value.
     * @param data The new value to assign.
     * @param temp The current node being checked.
     * @param old The original value to be replaced.
     */
    public void floodNode(int data, Node temp, int old) {
        old = temp.getData();
        temp.setData(data);
        temp.setSame(true);

        if (temp.getUp() != null && temp.getUp().getData() == old) {
            floodNode(data, temp.getUp(), old);
        }
        if (temp.getRight() != null && temp.getRight().getData() == old) {
            floodNode(data, temp.getRight(), old);
        }
        if (temp.getDown() != null && temp.getDown().getData() == old) {
            floodNode(data, temp.getDown(), old);
        }
        if (temp.getLeft() != null && temp.getLeft().getData() == old) {
            floodNode(data, temp.getLeft(), old);
        }
    }
}
