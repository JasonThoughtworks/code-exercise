import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;

public class ParkingLotSuperManagerTest {

    @Test
    public void should_park_a_car_into_a_parking_lot() throws Exception {

        Car car = new Car();

        ParkingLot parkingLot = new ParkingLot(2);

        List parkingLotList = new ArrayList<ParkingLot>();

        parkingLotList.add(parkingLot);

        ParkingLotSuperManager parkingLotSuperManager = new ParkingLotSuperManager(parkingLotList);

        Receipt receipt = parkingLotSuperManager.park(car);

        assertSame(car, parkingLot.retrieve(receipt));
    }

    @Test
    public void should_park_a_car_into_the_highest_vacancy_rate_parking_lot() throws Exception {

        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.park(new Car());

        ParkingLot highestVacancyRateParkingLot = new ParkingLot(2);

        List parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(parkingLot);
        parkingLotList.add(highestVacancyRateParkingLot);

        ParkingLotSuperManager parkingLotSuperManager = new ParkingLotSuperManager(parkingLotList);

        Car expectCar = new Car();
        Receipt receipt = parkingLotSuperManager.park(expectCar);

        Car actualCar = highestVacancyRateParkingLot.retrieve(receipt);
        assertSame(expectCar, actualCar);

    }

    @Test
    public void should_park_a_car_into_the_highest_vacancy_rate_parking_lot_() throws Exception {

        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.park(new Car());

        ParkingLot highestVacancyRateParkingLot = new ParkingLot(2);

        List parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(highestVacancyRateParkingLot);
        parkingLotList.add(parkingLot);

        ParkingLotSuperManager parkingLotSuperManager = new ParkingLotSuperManager(parkingLotList);

        Car expectCar = new Car();
        Receipt receipt = parkingLotSuperManager.park(expectCar);

        Car actualCar = highestVacancyRateParkingLot.retrieve(receipt);
        assertSame(expectCar, actualCar);

    }
}
