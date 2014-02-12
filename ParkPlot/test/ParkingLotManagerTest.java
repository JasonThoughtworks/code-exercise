import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ParkingLotManagerTest {

    private ParkingLotManager parkingLotManager;

    @Before
    public void setUp() throws Exception {
        ParkingLot parkingLot = new ParkingLot(10);
        parkingLotManager = new ParkingLotManager();
        parkingLotManager.addManagedParkingLot(parkingLot);

    }

    @Test
    public void should_return_available_parking_lot_number() {
        assertThat(parkingLotManager.getAvailableParkingLotNumber(), is(10));
    }


    @Test
    public void should_get_a_receipt_when_ask_manager_parking_my_car_successfully() {
        Car car = new Car();
        Receipt receipt = parkingLotManager.park(car);
        assertNotNull(receipt);
    }

    @Test
    public void should_not_get_a_receipt_when_all_parking_lot_has_no_available_parking_lots() {
        ParkingLot parkingLotWithNoLots = new ParkingLot(0);
        ParkingLotManager parkingLotManagerWithNoLots = new ParkingLotManager();
        parkingLotManagerWithNoLots.addManagedParkingLot(parkingLotWithNoLots);
        Car car = new Car();

        Receipt receipt = parkingLotManagerWithNoLots.park(car);
        assertNull(receipt);
    }

    @Test
    public void should_get_a_different_receipt_when_another_car_parking_at_parking_lots() {
        Car car1 = new Car();
        Receipt receipt1 = parkingLotManager.park(car1);

        Car car2 = new Car();
        Receipt receipt2 = parkingLotManager.park(car2);
        assertFalse(receipt1.equals(receipt2));
    }

    @Test
    public void should_take_a_car_out_with_specific_receipt() throws Exception {
        Car car = new Car();
        Receipt receipt = parkingLotManager.park(car);

        Car car2 = parkingLotManager.retrive(receipt);

        assertEquals(car, car2);
    }

}
