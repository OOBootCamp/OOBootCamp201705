import java.util.HashMap;

class ParkingLot implements ParkingAble {
    private HashMap<Token, Car> tokenCarHashMap = new HashMap<>();
    private int capacity;

    ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Token park(Car car) {
        if (isFull()) throw new FullException();

        Token token = new Token();
        tokenCarHashMap.put(token, car);
        return token;
    }

    public Car pick(Token token) {
        if (!tokenCarHashMap.containsKey(token)) throw new CarNotExistException();
        return tokenCarHashMap.remove(token);
    }

    public boolean isFull() {
        return tokenCarHashMap.size() == capacity;
    }

    public boolean containToken(Token token) {
        return tokenCarHashMap.containsKey(token);
    }

    int spots() {
        return capacity - tokenCarHashMap.size();
    }

    double vacancy() {
        double v = (spots() * 1.0) / capacity;
        return v;
    }
}
