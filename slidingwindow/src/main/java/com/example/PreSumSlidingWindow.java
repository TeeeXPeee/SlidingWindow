package com.example;


final public class PreSumSlidingWindow<T extends Number> extends SlidingWindow<T> {

    private double sum;

    public PreSumSlidingWindow(T data[], int width) {
        super(data, width);
        sum = computeSum();
    }
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

    private double computeSum() {
        T[] windowData = super.data();
        double total = 0;
        for(T n : windowData) {
            total += n.doubleValue();
        }
        return total;
       }

    public double average() {
        return sum / super.getWidth();
    }

    public double getSum() {
        return sum;
    }
}