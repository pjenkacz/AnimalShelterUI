import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ClientPanel extends JFrame {
    private ShelterTableModel shelterTableModel;
    private AnimalTableModel animalTableModel;
    private JTable shelterTable;
    private JTable animalTable;
    private ShelterManager shelterManager;

    public ClientPanel(ShelterManager shelterManager) {
        this.shelterManager = shelterManager;
        setTitle("Client Panel - Animal Shelter Management");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicjalizacja modeli tabel
        shelterTableModel = new ShelterTableModel();
        animalTableModel = new AnimalTableModel();

        for (AnimalShelter shelter : shelterManager.getShelters().values()) {
            shelterTableModel.addShelter(shelter);
        }

        // Tabela schronisk
        shelterTable = new JTable(shelterTableModel);
        shelterTable.getSelectionModel().addListSelectionListener(event -> {
            int selectedRow = shelterTable.getSelectedRow();
            if (selectedRow != -1) {
                AnimalShelter selectedShelter = shelterTableModel.getShelterAt(selectedRow);
                if (selectedShelter != null) {
                    animalTableModel.setAnimals(selectedShelter.getAnimalList());
                }
            }
        });

        // Tabela zwierząt
        animalTable = new JTable(animalTableModel);

        // Panele z przewijaniem
        JScrollPane shelterScrollPane = new JScrollPane(shelterTable);
        JScrollPane animalScrollPane = new JScrollPane(animalTable);

        // Przyciski klienta
        JButton adoptAnimalButton = new JButton("Adopt Animal");
        adoptAnimalButton.addActionListener(e -> adoptAnimal());

        JButton contactShelterButton = new JButton("Contact Shelter");
        contactShelterButton.addActionListener(e -> contactShelter());

        // Panel z przyciskami
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(adoptAnimalButton);
        buttonPanel.add(Box.createVerticalStrut(10)); // Odstęp między przyciskami
        buttonPanel.add(contactShelterButton);

        // Układ główny
        setLayout(new BorderLayout());
        add(new JLabel("Shelters"), BorderLayout.WEST);
        add(shelterScrollPane, BorderLayout.WEST);
        add(new JLabel("Animals"), BorderLayout.EAST);
        add(animalScrollPane, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void adoptAnimal() {
        int selectedShelterRow = shelterTable.getSelectedRow();
        int selectedAnimalRow = animalTable.getSelectedRow();

        if (selectedShelterRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a shelter first.");
            return;
        }

        if (selectedAnimalRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an animal to adopt.");
            return;
        }

        AnimalShelter selectedShelter = shelterTableModel.getShelterAt(selectedShelterRow);
        Animal selectedAnimal = animalTableModel.getAnimalAt(selectedAnimalRow);

        if (selectedShelter != null && selectedAnimal != null) {
            selectedShelter.removeAnimal(selectedAnimal);
            animalTableModel.setAnimals(selectedShelter.getAnimalList());
            JOptionPane.showMessageDialog(this, "Animal adopted successfully!");
        }
    }

    private void contactShelter() {
        int selectedShelterRow = shelterTable.getSelectedRow();

        if (selectedShelterRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a shelter to contact.");
            return;
        }

        AnimalShelter selectedShelter = shelterTableModel.getShelterAt(selectedShelterRow);

        if (selectedShelter != null) {
            String message = "Contact " + selectedShelter.getShelterName() +
                    "\nPhone: " + selectedShelter.getPhoneNumber(); // Dodaj pole numer telefonu w AnimalShelter
            JOptionPane.showMessageDialog(this, message);
        }
    }
}
