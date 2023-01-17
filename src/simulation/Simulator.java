package simulation;

import models.BoardingArea;

import java.util.Random;

public abstract class Simulator implements Runnable {
    private final float TIME_INTERVAL;
    protected final BoardingArea boardingArea;
    private final Random random;
    public Simulator(int TIME_INTERVAL, BoardingArea boardingArea) {
        this.TIME_INTERVAL = TIME_INTERVAL;
        this.boardingArea = boardingArea;
        this.random = new Random(10);
    }

    @Override
    public void run() {
        int id = 0;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Runnable runnableObj = getRunnable(id, boardingArea);
                (new Thread(runnableObj)).start();
                id++;
                //noinspection BusyWait
                Thread.sleep(getRandomTimeInterval());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private long getRandomTimeInterval() {
        float lambda = 1 / TIME_INTERVAL;
        return Math.round(Math.log(1 - random.nextFloat()) / (-lambda));
//        return TIME_INTERVAL;
    }
    protected abstract Runnable getRunnable(int id, BoardingArea boardingArea);
}
