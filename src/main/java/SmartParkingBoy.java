import java.util.Comparator;
import java.util.List;

class SmartParkingBoy {
    private List<ParkingLot> parkingLots;

    SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    Token park(Car car) {
        return parkingLots
                .stream()
                .max(Comparator.comparingInt(ParkingLot::spots))
                .get()
                .park(car);
    }

    Car pick(Token token) {
        for (ParkingLot parkingLot : parkingLots)
            if (parkingLot.containToken(token)) return parkingLot.pick(token);
        throw new CarNotExistException();
    }
}
