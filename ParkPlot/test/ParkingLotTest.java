import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingLotTest {

    private ParkingLot parkingLot;

    @Test
    public void should_return_available_parking_lot_number_in_park_plot() {
        parkingLot = new ParkingLot(1);
        assertThat(parkingLot.getAvailableParkingLotNumber(), is(1));
    }

    @Test
    public void should_get_a_receipt_when_a_car_parking_at_parking_lot() {
        parkingLot = new ParkingLot(1);
        Car car = new Car();
        Receipt receipt = parkingLot.park(car);
        assertSame(car, parkingLot.retrieve(receipt));
    }

    @Test
    public void should_not_get_a_receipt_when_a_car_try_to_park_in_but_no_available_parking_lots() {
        ParkingLot parkingLotWithNoLots = new ParkingLot(0);
        Receipt receipt = parkingLotWithNoLots.park(new Car());

        assertNull(receipt);
    }

    @Test
    public void should_get_a_different_receipt_when_another_car_parking_at_parking_lots() {
        parkingLot = new ParkingLot(2);
        Receipt receipt = parkingLot.park(new Car());
        Receipt anotherReceipt = parkingLot.park(new Car());

        assertNotSame(receipt, anotherReceipt);
    }

    @Test
    public void should_decrease_available_parking_lot_number_when_a_car_park_in() {
        ParkingLot parkingLot = new ParkingLot(5);
        parkingLot.park(new Car());

        assertThat(parkingLot.getAvailableParkingLotNumber(), is(4));
    }

    @Test
    public void should_take_a_car_out_with_specific_receipt() throws Exception {
        parkingLot = new ParkingLot(1);
        Car car = new Car();
        Receipt receipt = parkingLot.park(car);
        Car retrieveCar = parkingLot.retrieve(receipt);

        assertSame(car, retrieveCar);
    }
}
