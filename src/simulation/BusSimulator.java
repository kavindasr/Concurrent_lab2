package simulation;

import models.BoardingArea;
import models.Bus;

public class BusSimulator extends Simulator{
    private static final int BUS_MEAN_ARRIVAL_TIME = 10*1000;//20 * 60 * 1000;
    private static final int BUS_MAX_LOAD = 50;
    private BoardingArea boardingArea;

    public BusSimulator(BoardingArea boardingArea) {
        super(BUS_MEAN_ARRIVAL_TIME, boardingArea);
    }

    @Override
    protected Runnable getRunnable(int id, BoardingArea boardingArea) {
        return new Bus(id,BUS_MAX_LOAD, boardingArea);
    }
}
