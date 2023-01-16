package com.example.javamutex;

public class SequenceGeneratorUsingSynchronizedMethod extends SequenceGenerator {
    
    @Override
    public synchronized int getNextSequence() {
        return super.getNextSequence();
    }

}