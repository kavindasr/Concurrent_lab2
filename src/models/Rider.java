package models;

public class Rider implements Runnable{
    private final int id;
    private final BoardingArea boardingArea;

    public Rider(int id, BoardingArea boardingArea) {
        this.id = id;
        this.boardingArea = boardingArea;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public void run() {
        try {
            // Wait until the boarding area opens
            boardingArea.blockBoardingArea();
            // Release boarding area
            boardingArea.openBoardingArea();
            boardingArea.enterBoardingArea(this);
            boardBus();
            boardingArea.releaseBoarded();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void boardBus() {
        System.out.printf("Rider:%d Boarded to the bus\n", id);
    }
}
