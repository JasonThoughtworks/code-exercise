import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingLotManagerTest {

    private ParkingLotManager parkingLotManager;

    @Test
    public void should_return_available_parking_lot_number() {
        parkingLotManager = prepareParkingLotManagerWithSpecificTotalParkingLotNumber(1);

        assertThat(parkingLotManager.getAvailableParkingLotNumber(), is(1));
    }

    @Test
    public void should_get_a_receipt_when_ask_manager_parking_my_car_successfully() {
        parkingLotManager = prepareParkingLotManagerWithSpecificTotalParkingLotNumber(1);
        Car car = new Car();
        Receipt receipt = parkingLotManager.park(car);
        assertSame(car, parkingLotManager.retrieve(receipt));
    }

    @Test
    public void should_not_get_a_receipt_when_all_parking_lot_has_no_available_parking_lots() {
        ParkingLotManager parkingLotManagerWithNoLots = prepareParkingLotManagerWithSpecificTotalParkingLotNumber(0);
        Receipt receipt = parkingLotManagerWithNoLots.park(new Car());
        assertNull(receipt);
    }


    @Test
    public void should_get_a_different_receipt_when_another_car_parking_at_parking_lots() {
        parkingLotManager = prepareParkingLotManagerWithSpecificTotalParkingLotNumber(2);
        Receipt receipt = parkingLotManager.park(new Car());
        Receipt anotherReceipt = parkingLotManager.park(new Car());
        assertNotSame(receipt, anotherReceipt);
    }

    @Test
    public void should_take_a_car_out_with_specific_receipt() throws Exception {
        parkingLotManager = prepareParkingLotManagerWithSpecificTotalParkingLotNumber(1);
        Car car = new Car();
        Receipt receipt = parkingLotManager.park(car);
        Car retrieveCar = parkingLotManager.retrieve(receipt);
        assertSame(car, retrieveCar);
    }

    private ParkingLotManager prepareParkingLotManagerWithSpecificTotalParkingLotNumber(int ParkingLotNum) {
        ArrayList<ParkingLot> managedParkingLotList = new ArrayList<ParkingLot>();
        managedParkingLotList.add(new ParkingLot(ParkingLotNum));
        return new ParkingLotManager(managedParkingLotList);
    }
}
