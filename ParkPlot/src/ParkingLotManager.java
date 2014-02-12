import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager {
    private List<ParkingLot> managedParkingLotList = new ArrayList<ParkingLot>();

    public void addManagedParkingLot(ParkingLot parkingLot) {
        managedParkingLotList.add(parkingLot);
    }

    public int getAvailableParkingLotNumber() {
        int availableParkingLotNumber = 0;
        for (ParkingLot parkingLot : managedParkingLotList) {
            availableParkingLotNumber += parkingLot.getAvailableParkingLotNumber();
        }
        return availableParkingLotNumber;
    }

    public Receipt park(Car car) {
        for (ParkingLot parkingLot : managedParkingLotList) {
            Receipt receipt = parkingLot.park(car);
            if (null != receipt) {
                return receipt;
            }
        }
        return null;
    }

    public Car retrive(Receipt receipt) {
        for (ParkingLot parkingLot : managedParkingLotList) {
            Car car = parkingLot.retrive(receipt);
            if (null != car) {
                return car;
            }
        }
        return null;
    }
}
