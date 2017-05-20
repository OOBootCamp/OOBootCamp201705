import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SmartParkingBoyTest {
    @Test
    public void should_pick_and_park_car_with_one_parking_lot() throws Exception {
        SmartParkingBoy parkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(1)));
        Car car = new Car();

        Assert.assertSame(car, parkingBoy.pick(parkingBoy.park(car)));
    }

    @Test
    public void should_pick_and_park_car_with_two_parking_lot() throws Exception {
        SmartParkingBoy parkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(1),new ParkingLot(1)));
        Car car = new Car();

        Assert.assertSame(car, parkingBoy.pick(parkingBoy.park(car)));
    }

    @Test
    public void should_park_car_to_parking_lot_with_more_spots() throws Exception {
        ParkingLot parkingLotWithMoreSpots = new ParkingLot(2);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(1), parkingLotWithMoreSpots));
        Car car = new Car();

        Assert.assertSame(car, parkingLotWithMoreSpots.pick(parkingBoy.park(car)));
    }

    @Test(expected = FullException.class)
    public void should_pick_and_park_car_given_all_parking_lot_is_full() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(1), parkingLot));
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());

        parkingBoy.park(new Car());
    }
}
