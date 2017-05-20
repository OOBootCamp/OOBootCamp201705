import java.util.HashMap;

class ParkingLot {
    private HashMap<Token, Car> tokenCarHashMap = new HashMap<>();
    private int capacity;

    ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    Token park(Car car) {
        if (isFull()) throw new FullException();

        Token token = new Token();
        tokenCarHashMap.put(token, car);
        return token;
    }

    Car pick(Token token) {
        if (!tokenCarHashMap.containsKey(token)) throw new CarNotExistException();
        return tokenCarHashMap.remove(token);
    }

    boolean isFull() {
        return tokenCarHashMap.size() == capacity;
    }

    boolean containToken(Token token) {
        return tokenCarHashMap.containsKey(token);
    }

    public int spots() {
        return capacity - tokenCarHashMap.size();
    }

    public double vacancy() {
        double v = (spots() * 1.0) / capacity;
        return v;
    }
}
