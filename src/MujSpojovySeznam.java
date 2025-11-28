import org.w3c.dom.Node;

public class MujSpojovySeznam {

    private Node head;
    private Node tail;
    private int size;

    public MujSpojovySeznam(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(int value){
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if(tail == null){
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
    //indexuju od 1.
    public int getIndex(int index){
        Node newNode = head;
        for (int i = 1; i <index ; i++) {
            newNode=newNode.next;
        }
        return newNode.value;
    }
    public int indexOf(int value){
        int num=1;
        Node newNode = head;
        while  (newNode!=null){
            if (contains(value)) {
                if (newNode.value==value) {
                    return num;
                }
            }
            newNode=newNode.next;
            num++;

        }

        return -1;
    }

    public int deleteLast(){
        int num;
        Node newNode = head;
        num = tail.value;
        while(newNode.next.next!=null){
            newNode=newNode.next;
        }
        newNode.next = null;
        tail = newNode;
        return num;
    }

    public boolean isEmpty(){
        if (head==null){
            return true;
        }
        return false;
    }

    public boolean contains(int value){
        Node newNode = head;
        if (head.next.value==value){
            return true;
        }
        return false;
    }

    public int deleteFirst(){
        int num= head.value;
        head=head.next;
        return num;
    }


    public int count(){
        return size;
    }

    public String toString(){
        String text = "";
        Node curr = head;
        while(curr != null){
            text += curr.value + "--> ";
            curr = curr.next;
        }
        return text;
    }



    public int size(){
        return size;
    }

    private class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }


}