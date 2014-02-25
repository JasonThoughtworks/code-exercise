import java.util.List;

/**
 * Created by twer on 2/20/14.
 */
public class ParkingLotManagerBase1 {

    private List<ParkingLot> managedParkingLotList;

    public ParkingLotManagerBase1(List<ParkingLot> managedParkingLotList) {

        this.managedParkingLotList = managedParkingLotList;
    }

    public int getAvailableParkingLotNumber() {
        int availableParkingLotNumber = 0;
        for (ParkingLot parkingLot : managedParkingLotList) {
            availableParkingLotNumber += parkingLot.getAvailableParkingLotNumber();
        }
        return availableParkingLotNumber;
    }
}
