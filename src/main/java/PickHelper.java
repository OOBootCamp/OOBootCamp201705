import java.util.List;

public class PickHelper {
    Car pick(Token token, List<? extends ParkingAble> parkingLots) {
        for (ParkingAble parkingLot : parkingLots)
            if (parkingLot.containToken(token)) return parkingLot.pick(token);
        throw new CarNotExistException();
    }
}