import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.SlidingWindow;

public class SlidingWindowTest{
    @Test
    public void testSlidingWindowIntToString() {
        Integer[] data = {1, 2, 3, 4, 5};
        SlidingWindow<Integer> window = new SlidingWindow<>(data, 3);
        assertEquals("123", window.toString());
        window.advance();
        assertEquals("234", window.toString());
        window.advance(2);
        assertEquals("45", window.toString());
    }

    @Test
    public void testSlidingWindowCharToString() {
        Character[] data = {'a', 'b', 'c', 'd', 'e'};
        SlidingWindow<Character> window = new SlidingWindow<>(data, 3);
        assertEquals("abc", window.toString());
        window.advance();
        assertEquals("bcd", window.toString());
        window.advance(2);
        assertEquals("de", window.toString());
    }

    @Test
    public void testSlidingWindowDoubleToString() {
        Double[] data = {1.1, 2.2, 3.3, 4.4, 5.5};
        SlidingWindow<Double> window = new SlidingWindow<>(data, 3);
        assertEquals("1.12.23.3", window.toString());
        window.advance();
        assertEquals("2.23.34.4", window.toString());
        window.advance(2);
        assertEquals("4.45.5", window.toString());
    }

    @Test
    public void testSlidingWindowAdvanceAndGetIndex() {
        Integer[] data = {1, 2, 3, 4};
        SlidingWindow<Integer> window = new SlidingWindow<>(data, 2);
        //Outide data range - index stays at 0
        assertEquals(false, window.advance(4));
        assertEquals(0, window.getIndex());
        //Advance by 2 - index moves to 2
        assertEquals(true, window.advance(2));
        assertEquals(2, window.getIndex());
        //Advance by 1 - index moves to 3
        assertEquals(true, window.advance());
        //Advance fails trying to move outside range - index stays at 3
        assertEquals(false, window.advance());
        assertEquals(3, window.getIndex());
    }

    @Test
    public void testSlidingWindowData() {
        Integer[] data = {1, 2, 3, 4};
        SlidingWindow<Integer> window = new SlidingWindow<>(data, 2);
        Integer[] windowData = window.data();
        assertEquals(2, windowData.length);
        assertEquals(1, windowData[0]);
        assertEquals(2, windowData[1]);
        window.advance(2);
        windowData = window.data();
        assertEquals(3, windowData[0]);
        assertEquals(4, windowData[1]);
    }
}