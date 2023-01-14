import models.BoardingArea;
import models.Bus;
import models.Rider;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BoardingArea boardingArea = new BoardingArea();
        Rider rider1 = new Rider(1,boardingArea);
        Rider rider2 = new Rider(2,boardingArea);
        Rider rider3 = new Rider(3,boardingArea);
        Bus bus = new Bus(1,5,boardingArea);

        Bus bus2 = new Bus(2,5,boardingArea);
        (new Thread(bus2)).start();
        Thread.sleep(1000);
        (new Thread(rider1)).start();
        (new Thread(rider2)).start();

        (new Thread(bus)).start();
        (new Thread(rider3)).start();
    }
}