package models;

public class Bus implements Runnable {
    private final int id;
    private final int maxLoad;
    private final BoardingArea boardingArea;
    public Bus(int id, int maxLoad, BoardingArea boardingArea) {
        this.id = id;
        this.maxLoad = maxLoad;
        this.boardingArea = boardingArea;
    }

    public int getId() {
        return this.id;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    @Override
    public void run() {
        try {
//            // Block new riders
//            boardingArea.blockBoardingArea();
            arrive();
            boardingArea.boardRiders(this);
            depart();
//            // Open boarding area
//            boardingArea.openBoardingArea();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void arrive() {
        System.out.printf("Bus:%d arrived\n", id);
    }

    public void depart() {
        System.out.printf("Bus:%d depart\n", id);
    }
}
