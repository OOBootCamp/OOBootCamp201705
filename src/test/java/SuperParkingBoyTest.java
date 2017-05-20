import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SuperParkingBoyTest {
    @Test
    public void should_pick_and_park_car_with_one_parking_lot() throws Exception {
        SuperParkingBoy parkingBoy = new SuperParkingBoy(Arrays.asList(new ParkingLot(1)));
        Car car = new Car();

        Assert.assertSame(car, parkingBoy.pick(parkingBoy.park(car)));
    }

    @Test
    public void should_pick_and_park_car_with_two_parking_lot() throws Exception {
        SuperParkingBoy parkingBoy = new SuperParkingBoy(Arrays.asList(new ParkingLot(1),new ParkingLot(1)));
        Car car = new Car();

        Assert.assertSame(car, parkingBoy.pick(parkingBoy.park(car)));
    }

    @Test
    public void should_park_car_to_parking_lot_with_more_vacancy() throws Exception {
        ParkingLot parkingLotWithMoreSpace = new ParkingLot(5);
        parkingLotWithMoreSpace.park(new Car());
        parkingLotWithMoreSpace.park(new Car());
        parkingLotWithMoreSpace.park(new Car());
        ParkingLot parkingLotWithMoreVacancy = new ParkingLot(2);
        parkingLotWithMoreVacancy.park(new Car());

        SuperParkingBoy parkingBoy = new SuperParkingBoy(Arrays.asList(parkingLotWithMoreSpace, parkingLotWithMoreVacancy));
        Car car = new Car();

        Assert.assertSame(car, parkingLotWithMoreVacancy.pick(parkingBoy.park(car)));
    }

    @Test(expected = FullException.class)
    public void should_pick_and_park_car_given_all_parking_lot_is_full() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        SuperParkingBoy parkingBoy = new SuperParkingBoy(Arrays.asList(new ParkingLot(1), parkingLot));
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());

        parkingBoy.park(new Car());
    }
}
