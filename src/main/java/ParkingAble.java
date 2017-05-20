public interface ParkingAble {
    Token park(Car car);

    Car pick(Token token);

    boolean isFull();

    boolean containToken(Token token);
}
