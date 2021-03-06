import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager {
    protected List<ParkingLot> managedParkingLotList = new ArrayList<ParkingLot>();

    public ParkingLotManager(List<ParkingLot> managedParkingLotList) {
        this.managedParkingLotList = managedParkingLotList;
    }

    public int getAvailableParkingLotNumber() {
        int availableParkingLotNumber = 0;
        for (ParkingLot parkingLot : managedParkingLotList) {
            availableParkingLotNumber += parkingLot.getAvailableParkingLotNumber();
        }
        return availableParkingLotNumber;
    }

    public Receipt park(Car car) {
        ParkingLot parkingLot = this.getParkingLot();
        if (null != parkingLot) {
            return parkingLot.park(car);
        }
        return null;
    }

    protected ParkingLot getParkingLot() {
        for (ParkingLot parkingLot : managedParkingLotList) {
            if (parkingLot.getAvailableParkingLotNumber() > 0) {
                return parkingLot;
            }
        }
        return null;
    }

    public Car retrieve(Receipt receipt) {
        for (ParkingLot parkingLot : managedParkingLotList) {
            Car car = parkingLot.retrieve(receipt);
            if (null != car) {
                return car;
            }
        }
        return null;
    }
}
