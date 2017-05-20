import java.util.Comparator;
import java.util.List;

class SmartParkingBoy extends ParkingBoyBase {
    SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Token park(Car car) {
        return parkingLots
                .stream()
                .max(Comparator.comparingInt(ParkingLot::spots))
                .get()
                .park(car);
    }
}
