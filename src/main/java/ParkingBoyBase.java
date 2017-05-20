import java.util.List;

public class ParkingBoyBase {
    protected List<ParkingLot> parkingLots;

    public ParkingBoyBase(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    Car pick(Token token) {
        for (ParkingLot parkingLot : parkingLots)
            if (parkingLot.containToken(token)) return parkingLot.pick(token);
        throw new CarNotExistException();
    }
}
