import java.util.List;

class ParkingBoy extends ParkingBoyBase{
    ParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    Token park(Car car) {
        for (ParkingLot parkingLot : parkingLots)
            if (!parkingLot.isFull()) return parkingLot.park(car);
        throw new FullException();
    }
}
