import java.util.List;

class ParkingManager {
    private final PickHelper pickHelper = new PickHelper();
    private List<ParkingAble> parkingLots;

    ParkingManager(List<ParkingAble> parkingLots) {
        this.parkingLots = parkingLots;
    }

    Token park(Car car) {
        for (ParkingAble parkingLot : parkingLots)
            if (!parkingLot.isFull()) return parkingLot.park(car);
        throw new FullException();
    }

    public Car pick(Token token) {
        return pickHelper.pick(token, parkingLots);
    }

}
