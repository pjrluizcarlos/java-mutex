package com.example.javamutex;

public class SequenceGeneratorUsingSynchronizedBlock extends SequenceGenerator {
    
    private final Object mutex = new Object();

    @Override
    public int getNextSequence() {
        synchronized (mutex) {
            return super.getNextSequence();
        }
    }

}