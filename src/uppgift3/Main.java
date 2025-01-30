package uppgift3;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        SLinkedList<String> l = new SLinkedList<>();
        for (int i = 0; i < 4; i++) l.add("e" + i);
        Iterator<String> iter = l.iterator();

        

        iter.remove();
        System.out.println(l);
    }
}
