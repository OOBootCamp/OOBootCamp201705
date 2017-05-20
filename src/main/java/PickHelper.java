import java.util.List;

public class PickHelper {
    <T extends  ParkingAble> Car pick(Token token, List<T> parkingLots) {
        for (ParkingAble parkingLot : parkingLots)
            if (parkingLot.containToken(token)) return parkingLot.pick(token);
        throw new CarNotExistException();
    }
}