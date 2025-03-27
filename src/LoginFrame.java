import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private ShelterManager shelterManager;

    public LoginFrame(ShelterManager shelterManager) {
        this.shelterManager = shelterManager; // Przypisanie instancji
        setTitle("Animal Shelter Management - Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initializeUI();
    }


    private void initializeUI() {
        // Panel główny
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        // Elementy interfejsu
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Login");
        panel.add(loginButton);

        add(panel);

        // Obsługa przycisku logowania
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("admin123")) {
                    // Otwarcie modułu admina
                    System.out.println("Admin login successful");
                    new AdminPanel(shelterManager).setVisible(true);
                    dispose();
                } else if (username.equals("user") && password.equals("user123")) {
                    // Otwarcie modułu klienta
                    System.out.println("User login successful");
                    new ClientPanel(shelterManager).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid login!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}
