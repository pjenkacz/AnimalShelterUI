import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableColumnModel;
import java.util.ArrayList;


public class AdminPanel extends JFrame {
    private ShelterTableModel shelterTableModel;  // Deklaracja na poziomie klasy
    private AnimalTableModel animalTableModel;
    private JTable shelterTable;
    private JTable animalTable;
    private JTextField filterField;
    private ShelterManager shelterManager;

    public AdminPanel(ShelterManager shelterManager) {
        this.shelterManager = shelterManager;
        setTitle("Admin Panel - Animal Shelter Management");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        shelterTableModel = new ShelterTableModel();
        animalTableModel = new AnimalTableModel();

        for (AnimalShelter shelter : shelterManager.getShelters().values()) {
            shelterTableModel.addShelter(shelter);
        }

        shelterTable = new JTable(shelterTableModel);
        //ustawienie szerokosci kolumn schelter Table
        shelterTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

//        shelterTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        TableColumnModel columnModelS = shelterTable.getColumnModel();
//        columnModelS.getColumn(0).setPreferredWidth(150); // Animal Name
//        columnModelS.getColumn(1).setPreferredWidth(20);

        JScrollPane scrollPaneS = new JScrollPane(shelterTable);
        add(scrollPaneS, BorderLayout.EAST);

        shelterTable.getSelectionModel().addListSelectionListener(event -> {
            // Sprawdzenie, czy wiersz jest wybrany
            int selectedRow = shelterTable.getSelectedRow();
            if (selectedRow != -1) {
                // Pobranie wybranego schroniska z modelu tabeli
                AnimalShelter selectedShelter = shelterTableModel.getShelterAt(selectedRow);
                // Ustawienie listy zwierząt dla animalTable
                animalTableModel.setAnimals(selectedShelter.getAnimalList());
            }
        });
        animalTable = new JTable(animalTableModel);
        //ustawienie szerokości kolumn animalTable
        animalTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

//        animalTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        TableColumnModel columnModelA = animalTable.getColumnModel();
//        columnModelA.getColumn(0).setPreferredWidth(150); // Animal Name
//        columnModelA.getColumn(1).setPreferredWidth(100); // Species
//        columnModelA.getColumn(2).setPreferredWidth(120); // Condition
//        columnModelA.getColumn(3).setPreferredWidth(60);  // Age
//        columnModelA.getColumn(4).setPreferredWidth(80);  // Weight

        JScrollPane scrollPaneA = new JScrollPane(animalTable);
        add(scrollPaneA, BorderLayout.WEST);

        filterField = new JTextField();
        filterField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filterText = filterField.getText();
                shelterTableModel.filterShelters(filterText);
                animalTableModel.filterAnimals(filterText);
            }
        });

        JButton addShelterButton = new JButton("Add Shelter");
        addShelterButton.addActionListener(e -> {
            String shelterName = JOptionPane.showInputDialog("Enter shelter name:");
            int capacity = Integer.parseInt(JOptionPane.showInputDialog("Enter shelter capacity:"));
            int phone = Integer.parseInt(JOptionPane.showInputDialog("Enter shelter phone number:"));
            shelterTableModel.addShelter(new AnimalShelter(shelterName, capacity, phone));
        });

        JButton sortButton = new JButton("Sort Shelters by Capacity");
        sortButton.addActionListener(e -> shelterTableModel.sortSheltersByCapacity());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(new JLabel("Filter:"), BorderLayout.WEST);
        topPanel.add(filterField, BorderLayout.CENTER);
        topPanel.add(addShelterButton, BorderLayout.EAST);
        topPanel.add(sortButton, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(shelterTable), BorderLayout.WEST);
        add(new JScrollPane(animalTable), BorderLayout.EAST);

        JPanel centerPanel = new JPanel();
        centerPanel.add(new JLabel("Select a shelter to see details"));
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS)); // Układ w pionie

        // Przycisk usuwania zwierzęcia
        JPanel buttonPanel = new JPanel();

        JButton removeAnimalButton = new JButton("Remove Animal");
        removeAnimalButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton removeSchelterButton = new JButton("Remove Schelter");
        removeSchelterButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton addAnimalButton = new JButton("Add Animal"); // Nowy przycisk "Add Animal"
        addAnimalButton.setAlignmentX(Component.CENTER_ALIGNMENT);




        //usuwanie zwierzęcia ze schroniska (nie usuwaj biednyh zwierzakow)lol
        removeAnimalButton.addActionListener(e -> {
            int selectedRow = animalTable.getSelectedRow();
            if (selectedRow != -1) {
                // Pobierz wybrane zwierzę
                Animal selectedAnimal = animalTableModel.getAnimalAt(selectedRow);
                // Pobierz wybrane schronisko
                int selectedShelterRow = shelterTable.getSelectedRow();
                if (selectedShelterRow != -1) {
                    AnimalShelter selectedShelter = shelterTableModel.getShelterAt(selectedShelterRow);
                    selectedShelter.removeAnimal(selectedAnimal); // Usuń zwierzę ze schroniska
                    animalTableModel.setAnimals(selectedShelter.getAnimalList()); // Odśwież tabelę
                    JOptionPane.showMessageDialog(this, "Animal removed successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Wybierz zwierza!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Wybierz zwierza!");
            } //lbtb
        });

        removeSchelterButton.addActionListener(e -> {
            int selectedRow = shelterTable.getSelectedRow();
            if (selectedRow != -1) {
                AnimalShelter selectedShelter = shelterTableModel.getShelterAt(selectedRow);
                if(selectedShelter != null){
                    shelterManager.removeShelter(selectedShelter.getShelterName());
                    shelterTableModel.removeShelter(selectedRow); // Usuń z modelu tabeli
                    animalTableModel.setAnimals(new ArrayList<>());

                    JOptionPane.showMessageDialog(this, "Shelter removed successfully!");
                }
            }else {
                JOptionPane.showMessageDialog(this, "Please select a shelter to remove!");
            }
        });

        addAnimalButton.addActionListener(e -> {
            int selectedRow = shelterTable.getSelectedRow();
            if (selectedRow != -1) {
                AnimalShelter selectedShelter = shelterTableModel.getShelterAt(selectedRow);
                if (selectedShelter != null) {
                    // Pole do wprowadzenia danych
                    String name = JOptionPane.showInputDialog(this, "Enter animal name:");
                    String species = JOptionPane.showInputDialog(this, "Enter animal species:");

                    // Tworzenie JComboBox z wartościami AnimalCondition
                    AnimalCondition[] conditions = AnimalCondition.values();
                    JComboBox<AnimalCondition> conditionComboBox = new JComboBox<>(conditions);
                    int result = JOptionPane.showConfirmDialog(this, conditionComboBox, "Select animal condition", JOptionPane.OK_CANCEL_OPTION);

                    if (result == JOptionPane.OK_OPTION) {
                        AnimalCondition condition = (AnimalCondition) conditionComboBox.getSelectedItem();

                        try {
                            // Pobieranie wieku i wagi
                            int age = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter animal age:"));
                            double price = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter animal price:"));
                            double weight = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter animal weight:"));

                            // Pobieranie informacji o szczepieniu
                            int vaccinatedResult = JOptionPane.showConfirmDialog(this, "Is the animal vaccinated?", "Vaccination", JOptionPane.YES_NO_OPTION);
                            boolean isVaccinated = vaccinatedResult == JOptionPane.YES_OPTION;

                            // Tworzenie nowego zwierzęcia
                            Animal newAnimal = new Animal(name, species, condition, age, price, weight, isVaccinated);

                            // Dodanie zwierzęcia do schroniska
                            selectedShelter.addAnimal(newAnimal);

                            // Odświeżenie tabeli animalTable
                            animalTableModel.setAnimals(selectedShelter.getAnimalList());
                            JOptionPane.showMessageDialog(this, "Animal added successfully!");
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(this, "Invalid numeric value entered.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }// on jest 10/10 ale robi mi obiad
            } else { // 11/10
                JOptionPane.showMessageDialog(this, "Please select a shelter first.");
            }
        });
        buttonPanel.add(addAnimalButton);
        buttonPanel.add(removeAnimalButton); // Dodaj przycisk do opakowania
        buttonPanel.add(removeSchelterButton);
        centerPanel.add(buttonPanel); // Dodaj opakowanie do głównego panelu
        setVisible(true); //xd
    }
//    public AnimalShelter getShelterAt(int rowIndex) {
//        return shelters.get(rowIndex);
//    }
}
