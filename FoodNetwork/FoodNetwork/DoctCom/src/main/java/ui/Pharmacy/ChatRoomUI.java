package ui.Pharmacy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ChatRoomUI {
    private JPanel panel;
    private JList<String> chatRoomList;
    private JList<String> chatRoomMessages;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChatRoomUI chatRoomUI = new ChatRoomUI();
            JFrame frame = new JFrame("Chat Room");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(chatRoomUI.getPanel());
            frame.pack();
            frame.setVisible(true);

            // Sample data
            DefaultListModel<String> model = new DefaultListModel<>();
            model.addElement("Chat Room 1");
            model.addElement("Chat Room 2");
            model.addElement("Chat Room 3");
            chatRoomUI.getChatRoomList().setModel(model);
        });
    }

    public ChatRoomUI() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        chatRoomList = new JList<>();
        chatRoomList.setCellRenderer(new ChatRoomListCellRenderer());
        chatRoomList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedChatRoom = chatRoomList.getSelectedValue();
                displayChatRoomMessages(selectedChatRoom);
            }
        });

        panel.add(new JScrollPane(chatRoomList));

        // TODO: Load the chat rooms into the JList
    }

    public JPanel getPanel() {
        return panel;
    }

    private void displayChatRoomMessages(String chatRoom) {
        // TODO: Fetch the messages of the selected chat room and display them in the JList
    }

    private class ChatRoomListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Check if the chat room has new messages
            boolean hasNewMessages = true;

            if (hasNewMessages) {
                try {
                    URL url = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQucWjNf3aOcyoxliL2YA8T50Y4MA0NhpF9rA&s");
                    BufferedImage img = ImageIO.read(url);
                    Image scaledImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Set width and height to 50
                    ImageIcon icon = new ImageIcon(scaledImg);
                    label.setIcon(icon);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // Add a border to each cell
            label.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

            // Change the font of each cell
            label.setFont(new Font("Arial", Font.BOLD, 14));

            // Set the background color of each cell
            label.setBackground(Color.LIGHT_GRAY);
            label.setOpaque(true);

            return label;
        }
    }

    public JList<String> getChatRoomList() {
        return chatRoomList;
    }
}