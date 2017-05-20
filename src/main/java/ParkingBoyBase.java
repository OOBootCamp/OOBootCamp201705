import java.util.List;

public abstract class ParkingBoyBase implements ParkingAble {
    protected List<ParkingLot> parkingLots;

    public ParkingBoyBase(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public abstract Token park(Car car);

    public Car pick(Token token) {
        for (ParkingLot parkingLot : parkingLots)
            if (parkingLot.containToken(token)) return parkingLot.pick(token);
        throw new CarNotExistException();
    }

    public boolean containToken(Token token) {
        return parkingLots.stream().anyMatch(parkingLot -> parkingLot.containToken(token));
    }

    public boolean isFull() {
        return parkingLots.stream().allMatch(parkingLot -> parkingLot.isFull());
    }
}
