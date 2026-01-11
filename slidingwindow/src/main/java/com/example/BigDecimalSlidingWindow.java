package com.example;
import java.math.BigDecimal;

public class BigDecimalSlidingWindow<T extends Number> extends SlidingWindow { 

    private BigDecimal sum;

    public BigDecimalSlidingWindow(Number data[], int width) {
        super(data, width);
        sum = computeSum();
    }

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

    private BigDecimal computeSum() {
        Object[] windowData = super.data();
        BigDecimal total = BigDecimal.ZERO;
        for(Object n : windowData) {
            total = total.add(new BigDecimal(n.toString()));
        }
        return total;
       }

    public BigDecimal average() {
        return sum.divide(BigDecimal.valueOf(super.getWidth()));
    }

    public BigDecimal getSum() {
        return sum;
    }

}
