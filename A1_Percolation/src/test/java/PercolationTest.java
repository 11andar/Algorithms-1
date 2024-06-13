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
}
