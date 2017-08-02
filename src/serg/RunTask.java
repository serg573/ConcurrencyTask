package serg;

import serg.runnable.SeparateThread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Sergey Vasiliev on 8/2/17.
 */
public class RunTask {

    public static int ourVariable = 0;
    public static final int countForLoops = 100;

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<SeparateThread> listOfThreads = new LinkedList<>();

        listOfThreads.add(new SeparateThread(countDownLatch));
        listOfThreads.add(new SeparateThread(countDownLatch));

        for (SeparateThread thred : listOfThreads) {
            executorService.execute(thred);
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        System.out.print("Our variable: "+ourVariable);

    }

}
