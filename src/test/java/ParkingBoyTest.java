import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ParkingBoyTest {
    @Test
    public void should_pick_and_park_car_with_one_parking_lot() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(1)));
        Car car = new Car();

        Assert.assertSame(car, parkingBoy.pick(parkingBoy.park(car)));
    }

    @Test
    public void should_pick_and_park_car_with_two_parking_lot() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(1),new ParkingLot(1)));
        Car car = new Car();

        Assert.assertSame(car, parkingBoy.pick(parkingBoy.park(car)));
    }

    @Test
    public void should_park_car_to_second_parking_lot_given_first_parking_lot_is_full() throws Exception {
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(1), secondParkingLot));
        parkingBoy.park(new Car());

        Car car = new Car();
        Car pick = secondParkingLot.pick(parkingBoy.park(car));
        Assert.assertSame(car, pick);
    }

    @Test
    public void should_pick_and_park_car_given_first_parking_lot_is_full() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(1), parkingLot));
        parkingBoy.park(new Car());

        Car car = new Car();
        Assert.assertSame(car, parkingBoy.pick(parkingBoy.park(car)));
    }

    @Test(expected = FullException.class)
    public void should_pick_and_park_car_given_all_parking_lot_is_full() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(1), parkingLot));
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());

        parkingBoy.park(new Car());
    }
}
