import java.util.Comparator;
import java.util.List;

class SuperParkingBoy extends ParkingBoyBase{

    SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    Token park(Car car) {
        return parkingLots
                .stream()
                .max(Comparator.comparingDouble(ParkingLot::vacancy))
                .get()
                .park(car);
    }
}
