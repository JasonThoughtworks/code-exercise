import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int totalParkingLots;
    private Map<Receipt, Car> carMap = new HashMap<Receipt, Car>();

    public ParkingLot(int totalParkingLots) {
        this.totalParkingLots = totalParkingLots;
    }

    public int getAvailableParkingLotNumber() {
        return totalParkingLots - carMap.size();
    }

    public Receipt park(Car car) {
        if (getAvailableParkingLotNumber() > 0) {
            Receipt receipt = new Receipt();
            carMap.put(receipt, car);
            return receipt;
        }
        return null;
    }

    public Car retrieve(Receipt receipt) {
        return carMap.get(receipt);
    }

    private Double calculateVacancyRate() {
        return Double.valueOf(getAvailableParkingLotNumber() / totalParkingLots);
    }

    boolean isVacancyRateHigher(ParkingLot highestVacancyRateParkingLot) {
        return calculateVacancyRate() > highestVacancyRateParkingLot.calculateVacancyRate();
    }

    boolean hasMoreAvailableParkingLots(ParkingLot mostParkingLot) {
        return getAvailableParkingLotNumber() > mostParkingLot.getAvailableParkingLotNumber();
    }
}
