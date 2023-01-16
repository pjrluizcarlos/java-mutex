package com.example.javamutex;

import java.util.concurrent.locks.ReentrantLock;

public class SequenceGeneratorUsingReentrantLock extends SequenceGenerator {
    
    private final ReentrantLock mutex = new ReentrantLock();

    @Override
    public int getNextSequence() {
        try {
            mutex.lock();
            return super.getNextSequence();
        } finally {
            mutex.unlock();
        }
    }

}