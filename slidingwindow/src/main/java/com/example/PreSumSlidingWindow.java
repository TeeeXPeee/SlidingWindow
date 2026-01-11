package com.example;


final public class PreSumSlidingWindow<T extends Number> extends SlidingWindow<T> {

    private double sum;

    /**
     * PreSum Sliding Window Constructor
     * @param data[] data array
     * @param width width of the sliding window
     */
    public PreSumSlidingWindow(T data[], int width) {
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
            sum -= super.getValueAt(indexToRemove).doubleValue();
            sum += super.getValueAt(indexToRemove + super.getWidth()).doubleValue();
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
                sum -= super.getValueAt(i).doubleValue();
                if(i + width < maxIndex)
                    sum += super.getValueAt(i + width).doubleValue();
            }
        }
        return advanced;
    }

    /**
     * Compute the sum of the current window
     * @return double sum of the current window
     */
    private double computeSum() {
        T[] windowData = super.data();
        double total = 0;
        for(T n : windowData) {
            total += n.doubleValue();
        }
        return total;
       }

    /**
     * Compute the average of the current window
     * @return double average of the current window
     */
    public double average() {
        return sum / super.getWidth();
    }

    /**
     * Get the sum of the current window
     * @return double sum of the current window
     */
    public double getSum() {
        return sum;
    }
}