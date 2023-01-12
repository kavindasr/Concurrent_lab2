package models;

import java.util.concurrent.Semaphore;

public class BoardingArea {
    private int waiting;
    private final Semaphore mutexWaiting;
    private final Semaphore mutexBoardingArea;
    private final Semaphore busSem;
    private final Semaphore boarded;

    public BoardingArea() {
        waiting = 0;
        mutexWaiting = new Semaphore(1);
        mutexBoardingArea = new Semaphore(1);
        busSem = new Semaphore(0);
        boarded = new Semaphore(0);
    }

    public void enterBoardingArea(Rider rider) throws InterruptedException {
        mutexWaiting.acquire();
        waiting++;
        mutexWaiting.release();
        // Wait for the bus
        busSem.acquire();
    }

    public void releaseBoarded() {
        boarded.release();
    }

    public void boardRiders(Bus bus) throws InterruptedException {
        mutexWaiting.acquire();
        int n = Math.min(waiting, bus.getMaxLoad());
        for(int i=0; i<n; i++) {
            busSem.release();
            boarded.acquire();
        }

        waiting = Math.max(waiting-bus.getMaxLoad(), 0);
        mutexWaiting.release();
    }

    public void blockBoardingArea() throws InterruptedException {
        mutexBoardingArea.acquire();
    }

    public void openBoardingArea() {
        mutexBoardingArea.release();
    }

}
