import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

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
        System.arraycopy(items, 0, newItems, 0, size);
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
    public Item dequeue() {
        if (size == 0)
            throw new NoSuchElementException("dequeue(): queue is empty");

        int randomIndex = StdRandom.uniformInt(size);
        Item randomItem = items[randomIndex];
        items[randomIndex] = items[--size];
        items[size] = null;
        return randomItem;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size == 0)
            throw new NoSuchElementException("sample(): queue is empty");

        return items[StdRandom.uniformInt(size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() { return new QueueIterator(); }

    private class QueueIterator<Item> implements Iterator<Item> {
        private int currentIndex = 0;
        private final Item[] iteratorItems;

        public QueueIterator() {
            iteratorItems = (Item[]) new Object[size];
            for (int i = 0; i < size; i++)
                iteratorItems[i] = (Item) items[i];
            StdRandom.shuffle(iteratorItems);
        }

        @Override
        public boolean hasNext() { return currentIndex < iteratorItems.length; }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("No more elements");
            return iteratorItems[currentIndex++];
        }
    }

    public void printQueue() {
        Iterator<Item> iter = iterator();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");
        System.out.println();
    }

    // unit testing (required)
    public static void main(String[] args) {}
}
