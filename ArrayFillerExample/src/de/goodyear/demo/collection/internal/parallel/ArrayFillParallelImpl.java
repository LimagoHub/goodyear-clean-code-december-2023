package de.goodyear.demo.collection.internal.parallel;

import de.goodyear.demo.collection.IntArrayFiller;
import de.goodyear.demo.collection.internal.sequentiell.ArrayFillerImpl;
import de.goodyear.demo.generator.Generator;
import de.goodyear.demo.generator.IntGenerator;
import de.goodyear.demo.generator.IntGeneratorBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArrayFillParallelImpl implements IntArrayFiller {

    private int feld[] = new int[1];
    private final int  runningThreads;
    private ExecutorService service;
    private final IntGeneratorBuilder generatorBuilder;

    public ArrayFillParallelImpl(final IntGeneratorBuilder generatorBuilder, final int runningThreads) {
        this.generatorBuilder = generatorBuilder;
        this.runningThreads = runningThreads;
    }

    @Override
    public void fillArray(int[] data) {
        this.feld = data;
        run();
    }

    private void run() {
        try {
            startThreadPoolForArrayFilling();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void startThreadPoolForArrayFilling() throws InterruptedException {
        service = Executors.newFixedThreadPool(runningThreads);
        startWorkerPerActiveThread();
        service.shutdown();
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
    }

    private void startWorkerPerActiveThread() {
        for (int actThread = 0; actThread < runningThreads; actThread++) {
            startSingleWorkerForSegment(actThread);
        }
    }

    private void startSingleWorkerForSegment(final int actThread) {

        // TODO separate Segment Logic or Spliterator
        final int segmentSize = feld.length/ runningThreads;
        final int start = actThread *segmentSize;
        final int end = start+segmentSize;
        service.execute(new FillSegmentWorker(start, end));
    }
    class FillSegmentWorker implements Runnable{

        private final int start;
        private final int end;

        public FillSegmentWorker(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            IntGenerator generator = generatorBuilder.create();
            for (int i = start; i < end; i++) {
                feld[i] = generator.next();
            }
        }
    }
}
