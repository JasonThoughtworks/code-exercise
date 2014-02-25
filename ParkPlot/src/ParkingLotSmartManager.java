import java.util.ArrayList;

public class ParkingLotSmartManager extends ParkingLotManager {

    public ParkingLotSmartManager(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    protected ParkingLot getParkingLot() {
        return getMostAvailableParkingLot();
    }

    private ParkingLot getMostAvailableParkingLot() {
        ParkingLot mostAvailableParkingLot = managedParkingLotList.get(0);
        for (ParkingLot parkingLot : managedParkingLotList) {
            if (parkingLot.hasMoreAvailableParkingLots(mostAvailableParkingLot)) {
                mostAvailableParkingLot = parkingLot;
            }
        }
        return mostAvailableParkingLot;
    }

}
