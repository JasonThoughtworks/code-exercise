import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertSame;

public class ParkingLotSmartManagerTest {

    private ParkingLotSmartManager parkingLotSmartManager;
    private ParkingLot parkingLot;

    @Test
    public void should_park_a_car_into_a_parking_lot() {
        parkingLot = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot);

        parkingLotSmartManager = new ParkingLotSmartManager(parkingLots);

        Car car = new Car();
        Receipt receipt = parkingLotSmartManager.park(car);

        assertSame(car, parkingLot.retrieve(receipt));
    }

    @Test
    public void should_park_the_car_into_the_most_available_parking_lot() throws Exception {
        ParkingLot mostAvailableParkingLot = new ParkingLot(2);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(1));
        parkingLots.add(mostAvailableParkingLot);
        parkingLots.add(new ParkingLot(1));
        parkingLotSmartManager = new ParkingLotSmartManager(parkingLots);

        Car car = new Car();
        Receipt receipt = parkingLotSmartManager.park(car);

        Car retrievedCar = mostAvailableParkingLot.retrieve(receipt);

        assertSame(car, retrievedCar);

    }
}
