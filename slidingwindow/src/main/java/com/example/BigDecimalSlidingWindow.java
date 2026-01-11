package com.example;
import java.math.BigDecimal;

public class BigDecimalSlidingWindow<T extends Number> extends SlidingWindow { 

    private BigDecimal sum;

    /**
     * BigDecimal Sliding Window Constructor
     * @param data data array
     * @param width width of the sliding window
     */
    public BigDecimalSlidingWindow(Number data[], int width) {
        super(data, width);
        sum = computeSum();
    }

    /**
     * Advance the sliding window by one position
     * @return boolean indicating if advance was successful
     */
    @Override
    public boolean advance() {
        boolean advanced = super.advance();
        if(advanced) {
            int indexToRemove = getIndex() - 1;
            sum = sum.subtract(new BigDecimal(super.getValueAt(indexToRemove).toString()));
            sum = sum.add(new BigDecimal(super.getValueAt(indexToRemove + super.getWidth()).toString()));
        }
        return advanced;
    }

    /**
     * Advance the sliding window by {step} number of positions
     * @param step int number of positions to advance
     * @return boolean indicating if advance was successful
     */
    @Override
    public boolean advance(int step) {
        boolean advanced = super.advance(step);
        int maxIndex = super.getDataSize();
        int index = super.getIndex();
        int width = super.getWidth();
        if(advanced) {
            for(int i = index-step; i < index; i++) {
                sum = sum.subtract(new BigDecimal(super.getValueAt(i).toString()));
                if(i + width < maxIndex)
                    sum = sum.add(new BigDecimal(super.getValueAt(i + width).toString()));
            }
        }
        return advanced;
    }

    /**
     * Compute the sum of the current window
     * @return BigDecimal sum of the current window
     */
    private BigDecimal computeSum() {
        Object[] windowData = super.data();
        BigDecimal total = BigDecimal.ZERO;
        for(Object n : windowData) {
            total = total.add(new BigDecimal(n.toString()));
        }
        return total;
       }

    /**
     * Compute the average of the current window
     * @return BigDecimal average of the current window
     */
    public BigDecimal average() {
        return sum.divide(BigDecimal.valueOf(super.getWidth()));
    }

    /**
     * Get the sum of the current window
     * @return BigDecimal sum of the current window
     */
    public BigDecimal getSum() {
        return sum;
    }

}
