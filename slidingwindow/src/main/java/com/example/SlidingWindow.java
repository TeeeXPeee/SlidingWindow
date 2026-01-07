package com.example;

import java.lang.reflect.Array;

public class SlidingWindow<T> {

    private T data[];
    private int dataSize;
    private int width;
    private int index;

    public SlidingWindow(T data[], int width) {
        this.data = data;
        this.width = width;
        this.index = 0;
        this.dataSize = data.length;
    }

    public SlidingWindow(T data[], int width, int startingIndex){
        this.data = data;
        this.width = width;
        this.index = startingIndex;
        this.dataSize = data.length;
    }

    public boolean advance() {
        if (index + 1 < dataSize) {
            index++;
            return true;
        }
        return false;  
    }

    public boolean advance(int step) {
        if (index + step < dataSize) {
            index += step;
            return true;
        }
        return false;  
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int maxIndex = Math.min(index + width, dataSize);
        for(int i = index; i < maxIndex; i++) {
            sb.append(data[i].toString());
        }
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public T[] data() {
        T[] windowData = (T[]) Array.newInstance(data.getClass().componentType(), width);
        System.arraycopy(data, index, windowData, 0, width);
        return windowData;
    }

    public int getIndex() {
        return index;
    }

    public int getWidth() {
        return width;
    }

    public int getDataSize() {
        return dataSize;
    }
    
    public T getValueAt(int index) {
        return data[index];
    }
}