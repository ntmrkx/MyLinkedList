import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MujSpojovySeznam seznam = new MujSpojovySeznam();
        seznam.addFirst(3);
        seznam.addFirst(4);
        seznam.addFirst(1);
        seznam.addFirst(2);
        seznam.addLast(7);
        System.out.println(seznam);
        System.out.println(seznam.getIndex(3));
        System.out.println(seznam.deleteFirst());
        System.out.println(seznam.deleteLast());
        System.out.println(seznam.indexOf(4));
        System.out.println(seznam.contains(10));
        System.out.println(seznam);



    }
}