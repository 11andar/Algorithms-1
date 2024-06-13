import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

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
}
