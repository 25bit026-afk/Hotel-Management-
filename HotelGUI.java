import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelGUI extends JFrame implements ActionListener {

    JButton addGuestBtn, bookRoomBtn, viewRoomsBtn, checkoutBtn;
    HotelService service = new HotelService();

    public HotelGUI() {

        setTitle("Hotel Management System");
        setSize(400, 350);
        setLayout(new GridLayout(4, 1, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addGuestBtn = new JButton("Add Guest");
        bookRoomBtn = new JButton("Book Room");
        viewRoomsBtn = new JButton("View Rooms");
        checkoutBtn = new JButton("Checkout");

        add(addGuestBtn);
        add(bookRoomBtn);
        add(viewRoomsBtn);
        add(checkoutBtn);

        addGuestBtn.addActionListener(this);
        bookRoomBtn.addActionListener(this);
        viewRoomsBtn.addActionListener(this);
        checkoutBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {

        if (e.getSource() == addGuestBtn) {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Guest ID:"));
                String name = JOptionPane.showInputDialog("Enter Name:");
                String phone = JOptionPane.showInputDialog("Enter Phone:");

                JOptionPane.showMessageDialog(this,
                        service.addGuest(id, name, phone));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input!");
            }

        } else if (e.getSource() == bookRoomBtn) {

            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Guest ID:"));
                JOptionPane.showMessageDialog(this, service.bookRoom(id));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input!");
            }

        } else if (e.getSource() == viewRoomsBtn) {

            JOptionPane.showMessageDialog(this, service.viewRooms());

        } else if (e.getSource() == checkoutBtn) {

            try {
                int roomNo = Integer.parseInt(JOptionPane.showInputDialog("Enter Room Number:"));
                JOptionPane.showMessageDialog(this, service.checkout(roomNo));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input!");
            }
        }
    }

    public static void main(String[] args) {
        new HotelGUI();
    }
}