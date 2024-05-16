import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int elementsNum;

    private class Node {
        Item data;
        Node next;
    }

    // construct an empty deque
    public Deque() {
        first = last = null;
    }

    // is the deque empty?
    public boolean isEmpty() { return first == null && last == null; }

    // return the number of items on the deque
    public int size() { return elementsNum; }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Item can't be null");

        Node newNode = new Node();
        newNode.data = item;
        newNode.next = first;

        if (this.isEmpty())
            last = newNode;
        first = newNode;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Item can't be null");

        Node newNode = new Node();
        newNode.data = item;
        newNode.next = null;

        if (this.isEmpty()) {
            last = newNode;
            first = last;
        } else {
            last.next = newNode;
            last = last.next;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (this.isEmpty())
            throw new NoSuchElementException("Can't remove item from an empty deque");

        Item itemToRemove = first.data;
        first = first.next;
        return itemToRemove;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (this.isEmpty())
            throw new NoSuchElementException("Can't remove item from an empty deque");

        Node currentNode = first;
        while (currentNode.next.next != null)
            currentNode = currentNode.next;

        Item itemToRemove = last.data;
        last = currentNode;
        return itemToRemove;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() { return new ListIterator(); }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() { return current != null; }

        public Item next() {
            Item data = current.data;
            current = current.next;
            return data;
        }
    }

    // unit testing (required)
    public static void main(String[] args)

}
