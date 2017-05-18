import java.util.List;

class ParkingBoy {
    private List<ParkingLot> parkingLots;

    ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    Token park(Car car) {
        for (ParkingLot parkingLot : parkingLots)
            if (!parkingLot.isFull()) return parkingLot.park(car);
        throw new FullException();
    }

    Car pick(Token token) {
        for (ParkingLot parkingLot : parkingLots)
            if (parkingLot.containToken(token)) return parkingLot.pick(token);
        throw new CarNotExistException();
    }
}
