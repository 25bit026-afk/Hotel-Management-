import java.util.*;

public class HotelService {

    ArrayList<Guest> guests = new ArrayList<>();
    ArrayList<Room> rooms = new ArrayList<>();

    public HotelService() {
        for (int i = 1; i <= 5; i++) {
            rooms.add(new Room(i));
        }
    }

    public String addGuest(int id, String name, String phone) {
        guests.add(new Guest(id, name, phone));
        return "Guest Added Successfully!";
    }

    public String bookRoom(int id) {
        Guest selected = null;

        for (Guest g : guests) {
            if (g.id == id) {
                selected = g;
                break;
            }
        }

        if (selected == null) return "Guest Not Found!";

        for (Room r : rooms) {
            if (!r.isBooked) {
                r.isBooked = true;
                r.guest = selected;
                return "Room " + r.roomNumber + " Booked!";
            }
        }

        return "No Rooms Available!";
    }

    public String viewRooms() {
        StringBuilder status = new StringBuilder();

        for (Room r : rooms) {
            if (r.isBooked) {
                status.append("Room ").append(r.roomNumber)
                      .append(" - Booked by ").append(r.guest.name).append("\n");
            } else {
                status.append("Room ").append(r.roomNumber)
                      .append(" - Available\n");
            }
        }

        return status.toString();
    }

    public String checkout(int roomNo) {
        for (Room r : rooms) {
            if (r.roomNumber == roomNo && r.isBooked) {
                r.isBooked = false;
                r.guest = null;
                return "Checkout Successful!";
            }
        }
        return "Invalid Room!";
    }
}