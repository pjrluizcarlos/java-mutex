package com.example.javamutex;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class SequenceGeneratorTest {

    private static final Integer COUNT = 2_000_000;

    @InjectMocks private SequenceGenerator generator;

    @Test
    void givenUnsafeSequenceGenerator_whenRaceCondition_thenUnexpectedBehavior() throws Exception {
        Set<Integer> actual = getUniqueSequences(generator, 3);

        assertEquals(COUNT, actual.size());
    }

    private Set<Integer> getUniqueSequences(SequenceGenerator generator, int threads) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        Set<Integer> uniqueSequences = new LinkedHashSet<>();
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < COUNT; i++) {
            futures.add(executor.submit(generator::getNextSequence));
        }

        for (Future<Integer> future : futures) {
            uniqueSequences.add(future.get());
        }

        executorAwaitTermination(executor);
        executor.shutdown();

        return uniqueSequences;
    }

    private void executorAwaitTermination(ExecutorService executor) throws InterruptedException {
        while(executor.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("waiting for executor tasks termination");
        }
    }

}