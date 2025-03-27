import javax.swing.table.AbstractTableModel;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class AnimalTableModel extends AbstractTableModel {
    private List<Animal> animals = new ArrayList<>();
    private final String[] columnNames = {"Animal Name", "Species", "Condition", "Age", "Weight"};

    public AnimalTableModel() {
        this.animals = new ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return animals.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal animal = animals.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return animal.getName();
            case 1:
                return animal.getSpecies();
            case 2:
                return animal.getCondition();
            case 3:
                return animal.getAge();
            case 4:
                return animal.getWeight();
            default:
                return null;
        }
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        fireTableDataChanged(); //lol
    }

    public void removeAnimal(int rowIndex) {
        animals.remove(rowIndex);
        fireTableDataChanged();
    }

    public void filterAnimals(String filter) {
        animals.removeIf(animal -> !animal.getName().toLowerCase().contains(filter.toLowerCase()));
        fireTableDataChanged();
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals; // Ustawienie nowej listy zwierząt
        fireTableDataChanged(); // Odświeżenie tabeli
    }

    public Animal getAnimalAt(int rowIndex) {
        return animals.get(rowIndex); // Pobierz schronisko na podstawie indeksu w tabeli
    }
}
