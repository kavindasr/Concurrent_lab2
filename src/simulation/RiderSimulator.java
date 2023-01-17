package simulation;

import models.BoardingArea;
import models.Rider;

public class RiderSimulator extends Simulator{
    private static final int RIDER_MEAN_ARRIVAL_TIME = 3*1000; //30 * 1000;;
    public RiderSimulator(BoardingArea boardingArea) {
        super(RIDER_MEAN_ARRIVAL_TIME, boardingArea);
    }

    @Override
    protected Runnable getRunnable(int id, BoardingArea boardingArea) {
        return new Rider(id, boardingArea);
    }
}
