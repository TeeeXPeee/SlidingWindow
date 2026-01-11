import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.BigDecimalSlidingWindow;
import java.math.BigDecimal;

public class BigDecimalSlidingWindowTest {

    @Test
    public void testBigDecimalSlidingWindowSum() {
        Double[] data = { 1.5, 2.5, 3.5, 4.5, 5.5 };
        BigDecimalSlidingWindow<Double> window = new BigDecimalSlidingWindow<>(data, 3);
        assertEquals(new BigDecimal("7.5"), window.getSum());
    }

    @Test
    public void testBigDecimalSlidingWindowAdvance() {
        Double[] data = { 1.5, 2.5, 3.5, 4.5, 5.5 };
        BigDecimalSlidingWindow<BigDecimal> window = new BigDecimalSlidingWindow<>(data, 3);
        assertEquals(true, window.advance());
        assertEquals(new BigDecimal("10.5"), window.getSum());
    }

    @Test
    public void testBigDecimalSlidingWindowAdvanceX() {
        Double[] data = { 1.5, 2.5, 3.5, 4.5, 5.5 };
        BigDecimalSlidingWindow<BigDecimal> window = new BigDecimalSlidingWindow<>(data, 3);
        window.advance(2);
        assertEquals(new BigDecimal("13.5"), window.getSum());
        window.advance(2);
        assertEquals(new BigDecimal("5.5"), window.getSum());
        assertEquals(false, window.advance());
    }
}
