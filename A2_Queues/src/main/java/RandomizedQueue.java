import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int size = 0;
    private int n = 1;

    // construct an empty randomized queue
    public RandomizedQueue() { items = (Item[]) new Object[n]; }

    // is the randomized queue empty?
    public boolean isEmpty() { return size == 0; }

    // return the number of items on the randomized queue
    public int size()

    // add the item
    public void enqueue(Item item)

    // remove and return a random item
    public Item dequeue()

    // return a random item (but do not remove it)
    public Item sample()

    // return an independent iterator over items in random order
    public Iterator<Item> iterator()

    // unit testing (required)
    public static void main(String[] args)
}
