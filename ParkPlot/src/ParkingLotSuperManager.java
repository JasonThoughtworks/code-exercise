import java.util.List;

public class ParkingLotSuperManager extends ParkingLotManager{
    public ParkingLotSuperManager(List parkingLots) {
        super(parkingLots);
    }

    @Override
    protected ParkingLot getParkingLot() {
        return getHighestVacancyRateParkingLot();
    }

    private ParkingLot getHighestVacancyRateParkingLot() {
        ParkingLot highestVacancyRateParkingLot = managedParkingLotList.get(0);
        for (ParkingLot parkingLot : managedParkingLotList) {
            if (parkingLot.isVacancyRateHigher(highestVacancyRateParkingLot)){
                highestVacancyRateParkingLot = parkingLot;
            }
        }
        return highestVacancyRateParkingLot;
    }

}
