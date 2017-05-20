import java.util.List;

class NormalParkingBoy extends ParkingBoyBase{
    NormalParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Token park(Car car) {
        for (ParkingLot parkingLot : parkingLots)
            if (!parkingLot.isFull()) return parkingLot.park(car);
        throw new FullException();
    }
}
