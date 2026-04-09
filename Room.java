public class Room {
    int roomNumber;
    boolean isBooked;
    Guest guest;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
    }
}