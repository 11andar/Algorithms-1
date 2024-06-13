import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PercolationTest {
    private final int gridSize = 4;
    private Percolation percolation;

    @BeforeEach
    public void setUp() {
        percolation = new Percolation(gridSize);
    }

    @Test
    public void testConstructorThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Percolation(0));
    }

    @Test
    public void testConstructorInitializesGrid() {
        for (int i = 1; i <= gridSize; i++)
            for (int j = 1; j <= gridSize; j++)
                assertFalse(percolation.isOpen(i, j));
    }

    @Test
    public void testOpen() {
        assertThrows(IllegalArgumentException.class, () -> percolation.open(-1, -1));
        percolation.open(2, 3);
        assertTrue(percolation.isOpen(2, 3));
        assertFalse(percolation.isOpen(1, 2));
    }

    @Test
    public void testIsOpen() {
        assertThrows(IllegalArgumentException.class, () -> percolation.isOpen(-1, -1));
        percolation.open(2, 3);
        assertTrue(percolation.isOpen(2, 3));
        assertFalse(percolation.isOpen(2, 1));
    }

    @Test
    public void testIsFull() {
        assertThrows(IllegalArgumentException.class, () -> percolation.isFull(-1, -1));
        percolation.open(1, 1);
        assertTrue(percolation.isFull(1, 1));
        assertFalse(percolation.isFull(2, 1));
    }

    @Test
    public void testNumberOfOpenSites() {
        assertEquals(0, percolation.numberOfOpenSites());
        percolation.open(1, 2);
        assertEquals(1, percolation.numberOfOpenSites());
        percolation.open(2, 3);
        assertEquals(2, percolation.numberOfOpenSites());
    }

    @Test
    public void testPercolates() {
        assertFalse(percolation.percolates());
        percolation.open(1, 1);
        assertFalse(percolation.percolates());
        percolation.open(2, 1);
        assertFalse(percolation.percolates());
        percolation.open(3, 1);
        assertFalse(percolation.percolates());
        percolation.open(4, 1);
        assertTrue(percolation.percolates());
    }
}
