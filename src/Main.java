import models.BoardingArea;
import models.Bus;
import models.Rider;
import simulation.BusSimulator;
import simulation.RiderSimulator;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BoardingArea boardingArea = new BoardingArea();
        BusSimulator busSimulator = new BusSimulator(boardingArea);
        RiderSimulator riderSimulator = new RiderSimulator(boardingArea);

        (new Thread(riderSimulator)).start();
        (new Thread(busSimulator)).start();


    }
}