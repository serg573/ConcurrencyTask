package serg.runnable;

import serg.RunTask;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Sergey Vasiliev on 8/2/17.
 */
public class SeparateThread implements Runnable {

    private CountDownLatch countDownLatch;

    public SeparateThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i=0; i<RunTask.countForLoops; i++)
            RunTask.ourVariable++;

        countDownLatch.countDown();
    }
}
