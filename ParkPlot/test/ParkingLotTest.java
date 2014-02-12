import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingLotTest {

    private ParkingLot parkingLot;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(10);
    }

    @Test
    public void should_return_available_parking_lot_number_in_park_plot() {
        assertThat(parkingLot.getAvailableParkingLotNumber(), is(10));
    }

    @Test
    public void should_get_a_receipt_when_a_car_parking_at_parking_lot() {
        Car car = new Car();
        Receipt receipt = parkingLot.park(car);
        assertNotNull(receipt);
    }

    @Test
    public void should_not_get_a_receipt_when_a_car_try_to_park_in_but_no_available_parking_lots() {
        ParkingLot parkingLotWithNoLots = new ParkingLot(0);
        Car car = new Car();
        Receipt receipt = parkingLotWithNoLots.park(car);
        assertNull(receipt);
    }

    @Test
    public void should_get_a_different_receipt_when_another_car_parking_at_parking_lots() {
        Car car1 = new Car();
        Receipt receipt1 = parkingLot.park(car1);

        Car car2 = new Car();
        Receipt receipt2 = parkingLot.park(car2);
        assertFalse(receipt1.equals(receipt2));
    }

    @Test
    public void should_decrease_available_parking_lot_number_when_a_car_park_in() {
        ParkingLot parkingLot = new ParkingLot(5);

        Car car = new Car();

        parkingLot.park(car);

        assertThat(parkingLot.getAvailableParkingLotNumber(), is(4));
    }

    @Test
    public void should_take_a_car_out_with_specific_receipt() throws Exception {
        Car car = new Car();
        Receipt receipt = parkingLot.park(car);

        Car car2 = parkingLot.retrive(receipt);

        assertEquals(car, car2);
    }
}
