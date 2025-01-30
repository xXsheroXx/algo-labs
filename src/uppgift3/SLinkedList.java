package uppgift3;

public class SLinkedList<T> {
    private Node<T> head;

    private int size;
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }


    public SLinkedList() {
        head = null;
        size = 0;
    }
    public void add(int index, T item){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0){
            addFirst(item);
        }else {
            Node<T> node = getNode(index - 1);
            addAfter(node,item);
        }
    }

    public void addFirst(T item){
        head = new Node<>(item,head);
        size++;
    }

    private void addAfter(Node<T> node, T item){
        node.next = new Node<>(item, node.next);
        size++;
    }

    private Node<T> getNode(int index){
        Node<T> node = head;
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        for (int i = 0; i < index && node!=null; i++){
            node = node.next;
        }
        return node;
    }

    public boolean add(T item){
        add(size,item);
        return true;
    }
    public T get(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<T> node = getNode(index);
        return node.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> item = head;
        if (item != null) {
            while (item.next != null) {
                sb.append(item.data.toString());
                sb.append(" , ");
                item = item.next;
            }
            sb.append(item.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }


    private class Iterator implements java.util.Iterator<T> {
        Node<T> current;
        private Node<T> previous;
        private Node<T> bPCurrent;
        private boolean removeCalled;

        public Iterator(Node<T> start) {
            current = start;
            previous = null;
            bPCurrent = null;
            removeCalled = false;
        }
        @Override
        public boolean hasNext() {
            return current!= null;
        }
        @Override
        public T next() {
            T returnValue = current.data;
            bPCurrent = previous;
            previous = current;
            current = current.next;
            removeCalled = false;
            return returnValue;
        }

        @Override
        public void remove() {
            if(previous == null || removeCalled ){
                throw new IllegalStateException();
            }
            if (bPCurrent == null){
                head = current;
            }else {
                bPCurrent.next = current;
                previous = bPCurrent;
            }
            size--;
            removeCalled = true;
        }
    }
    public java.util.Iterator<T> iterator(){
        return new Iterator(head);
    }
    public T remove(int index){
        T removedData;
        if (index < 0 || index > size-1){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if(index == 0){
            removedData = deleteFirst();
        }else {
            removedData = delete(index);
        }
        return removedData;
    }
    private T deleteFirst(){
        T removedData  = head.data;
        head = head.next;
        size--;
        return removedData;
    }

    private T delete(int index){
        Node<T> prevNode = getNode(index-1);
        T removedData = prevNode.next.data;
        prevNode.next = prevNode.next.next; //the  previous
        size--;
        return removedData;
    }

    public boolean isEmpty(){
        return head == null;
    }
    public int getSize(){
        return size;
    }
}
