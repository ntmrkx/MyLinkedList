import java.util.NoSuchElementException;

public class Iterator implements java.util.Iterator<Integer> {
    private Node current;

    public Iterator(Node startNode) {
        this.current = startNode;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Integer next() {
        if (current == null) {
            throw new NoSuchElementException();
        }
        int val = current.value;
        current = current.next;
        return val;
    }
}



public class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}