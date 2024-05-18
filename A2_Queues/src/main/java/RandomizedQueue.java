import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        items = (Item[]) new Object[1];
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() { return size == 0; }

    // return the number of items on the randomized queue
    public int size() { return size; }

    // resize the items array
    private void resize(int newSize) {
        Item[] newItems = (Item[]) new Object[newSize];
        System.arraycopy(items, 0, newItems, 0, newSize);
        items = newItems;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException("enqueue(): item can't be null");

        if (size == items.length)
            resize(items.length * 2);
        items[size++] = item;
    }

    // remove and return a random item
    public Item dequeue()

    // return a random item (but do not remove it)
    public Item sample()

    // return an independent iterator over items in random order
    public Iterator<Item> iterator()

    // unit testing (required)
    public static void main(String[] args)
}
