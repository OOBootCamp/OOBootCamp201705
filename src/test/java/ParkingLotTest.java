import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void should_get_a_token_when_park_a_car_given_parking_lot_has_available_lots() {
        ParkingLot parkingLot = new ParkingLot(1);

        Car car = new Car();
        Car pickCar = parkingLot.pick(parkingLot.park(car));

        Assert.assertSame(car, pickCar);
    }

    @Test
    public void should_get_a_token_when_park_two_car_given_parking_lot_has_available_lots() {
        ParkingLot parkingLot = new ParkingLot(2);
        Car firstCar = new Car();
        Car secondCar = new Car();
        Token firstCarToken = parkingLot.park(firstCar);
        Token secondCarToken = parkingLot.park(secondCar);

        Assert.assertSame(firstCar, parkingLot.pick(firstCarToken));
        Assert.assertSame(secondCar, parkingLot.pick(secondCarToken));
    }

    @Test(expected = FullException.class)
    public void should_fail_to_park_when_parking_a_car_given_a_fully_parked_parking_lot() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());

        parkingLot.park(new Car());
    }

    @Test(expected = CarNotExistException.class)
    public void should_fail_to_park_when_parking_a_car_given_a_fully_parked_parking_lot1() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);

        parkingLot.pick(new Token());
    }

    @Test(expected = CarNotExistException.class)
    public void should_fail_to_park_when_parking_a_car_given_a_fully_parked_parking_lot2() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        Token token = parkingLot.park(new Car());
        parkingLot.pick(token);

        parkingLot.pick(token);
    }

    @Test()
    public void should_fail_to_park_when_parking_a_car_given_a_fully_parked_parking_lot21() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.pick(parkingLot.park(new Car()));
        Car car = new Car();

        Assert.assertSame(car, parkingLot.pick(parkingLot.park(car)));
    }
}
