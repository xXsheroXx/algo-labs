package uppgift2;

import java.util.Iterator;

public class Main_2 {
    public static void main(String[] args) {

        SingleLinkedList<String> l = new SingleLinkedList<>();
        for (int i = 0; i < 4; i++) l.add("e" + i);

        
        l.remove(3);
        l.add(0,"först");
        l.add("sist");
        System.out.println(l);

    }
}