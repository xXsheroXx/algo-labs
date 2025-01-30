package uppgift2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList <T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> next;
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public SingleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    public void add(int index, T item){
        if (index > size || index<0) {
            throw new IndexOutOfBoundsException(Integer.toString(index)); // check if the index is in the inbound.
        }else if (index == 0){
            addFirst(item); // if the index is zero so this item is going to be the head.
        }else if (index == size){
            addToTail(item); // this method add the item to the list tail.

        }

        else {
            Node <T> node = getNode(index-1);
            node.next = new Node<T>(item, node.next);
            size++;
        }
    }

    public boolean add(T item){
        add(size,item);
        return true;
    }

    private void addFirst(T item){
        head = new Node<T>(item,head);
        if(size == 0){
            tail = head;
        }
        size++;
    }

    private void addToTail(T item){
        Node<T> node = tail;
        tail = new Node<>(item,null);
        node.next = tail;
        size++;
    }

    private Node<T> getNode(int index){
        Node<T> node = head;
        if (index > size || index<0) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        else if(index == size-1){
            return tail;
        }
        for (int i = 0; i < index && node!=null; i++){
            node = node.next;
        }
        return node;
    }

    public T get(int index){
        if (index > size-1 || index<0) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<T> node = getNode(index);
        return node.data;
    }

    public T getTail() {
        return tail.data;
    }

    public T remove(int index){
        T removedElement = null;
        if (index > size || index<0) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (size==0) {
            head= null;
            tail= null;
        } else if(index == 0){
            removedElement  = head.data;
            head = head.next;
            size--;
        }else if(index == size-1){
            removedElement = getTail();
            tail = getNode(size-2);
            tail.next = null;
            size--;
        }else {
            removedElement = delete(index);
        }
        return removedElement;
    }

    private T delete(int index){
        Node<T> prevNode = getNode(index-1);
        T removedData = prevNode.next.data;
        prevNode.next = prevNode.next.next;
        size--;
        return removedData;
    }
    public boolean isEmpty(){
        if (head == null)
            return true;
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                sb.append(" ==> ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }
}