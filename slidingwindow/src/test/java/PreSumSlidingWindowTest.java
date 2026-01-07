import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.PreSumSlidingWindow;

public class PreSumSlidingWindowTest {
    @Test
    public void testPreSumSlidingWindowSumInt() {
        Integer[] data = {1, 2, 3, 4, 5};
        PreSumSlidingWindow<Integer> window = new PreSumSlidingWindow<>(data, 3);
        assertEquals(6, window.getSum());
    }

    @Test
    public void testPreSumSlidingWindowAdvance() {
        Integer[] data = {1, 2, 3, 4, 5};
        PreSumSlidingWindow<Integer> window = new PreSumSlidingWindow<>(data, 3);
        assertEquals(true, window.advance());
        assertEquals(9, window.getSum());
    }

    @Test
    public void testPreSumSlidingWindowAdvanceX() {
        Integer[] data = {1, 2, 3, 4, 5};
        PreSumSlidingWindow<Integer> window = new PreSumSlidingWindow<>(data, 3);
        window.advance(2);
        assertEquals(12, window.getSum());
        window.advance(2);
        assertEquals(5, window.getSum());
        assertEquals(false, window.advance());
    }
}