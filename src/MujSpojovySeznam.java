import java.util.Iterator;
import java.util.NoSuchElementException;

public class MujSpojovySeznam implements Iterable<Integer> {

    private Node head;
    private Node tail;
    private int size;

    public MujSpojovySeznam() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public int getIndex(int index) {
        Node cur = head;
        for (int i = 1; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    public int indexOf(int value) {
        Node cur = head;
        int index = 1;
        while (cur != null) {
            if (cur.value == value) return index;
            cur = cur.next;
            index++;
        }
        return -1;
    }

    public int deleteLast() {
        if (head == null) throw new NoSuchElementException();

        if (head == tail) { // jen jeden prvek
            int val = head.value;
            head = tail = null;
            size--;
            return val;
        }

        Node cur = head;
        while (cur.next != tail) {
            cur = cur.next;
        }

        int val = tail.value;
        tail = cur;
        tail.next = null;
        size--;
        return val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean contains(int value) {
        Node cur = head;
        while (cur != null) {
            if (cur.value == value) return true;
            cur = cur.next;
        }
        return false;
    }

    public int deleteFirst() {
        if (head == null) throw new NoSuchElementException();
        int val = head.value;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return val;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String text = "";
        Node curr = head;
        while (curr != null) {
            text += curr.value + " --> ";
            curr = curr.next;
        }
        return text;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator(head);
    }

    private class LinkedListIterator implements Iterator<Integer> {
        private Node current;

        public LinkedListIterator(Node startNode) {
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


    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
