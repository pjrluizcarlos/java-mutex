package com.example.javamutex;

public class SequenceGenerator {

    private int currentValue = 0;

    public int getNextSequence() {
        return currentValue++;
    }

}