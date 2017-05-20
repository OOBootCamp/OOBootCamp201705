import java.util.List;

public abstract class ParkingBoyBase implements ParkingAble {
    protected List<ParkingLot> parkingLots;
    private PickHelper pickHelper;

    public ParkingBoyBase(List<ParkingLot> parkingLots) {
        pickHelper = new PickHelper();
        this.parkingLots = parkingLots;
    }

    public abstract Token park(Car car);

    public Car pick(Token token) {
        return pickHelper.pick(token, parkingLots);
    }

    public boolean containToken(Token token) {
        return parkingLots.stream().anyMatch(parkingLot -> parkingLot.containToken(token));
    }

    public boolean isFull() {
        return parkingLots.stream().allMatch(parkingLot -> parkingLot.isFull());
    }
}
