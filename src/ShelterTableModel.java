import javax.swing.table.AbstractTableModel;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class ShelterTableModel extends AbstractTableModel {
    private List<AnimalShelter> shelters;
    private final String[] columnNames = {"Shelter Name", "Capacity"};

    public ShelterTableModel() {
        this.shelters = new ArrayList<>();
    }

    // Zwraca liczbę kolumn
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    // Zwraca liczbę wierszy
    @Override
    public int getRowCount() {
        return shelters.size();
    }

    // Zwraca nazwę kolumny na podstawie indeksu
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    // Zwraca wartość komórki
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AnimalShelter shelter = shelters.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return shelter.getShelterName();
            case 1:
                return shelter.getMaxCapacity();
            default:
                return null;
        }
    }

    // Dodawanie nowego schroniska do listy
    public void addShelter(AnimalShelter shelter) {
        shelters.add(shelter);
        fireTableDataChanged();
    }

    // Usuwanie schroniska
    public void removeShelter(int rowIndex) {
        shelters.remove(rowIndex);
        fireTableDataChanged();
    }

    // Sortowanie schronisk według pojemności
    public void sortSheltersByCapacity() {
        shelters.sort(Comparator.comparingInt(AnimalShelter::getMaxCapacity));
        fireTableDataChanged();
    }

    // Filtrowanie schronisk według nazwy
    public void filterShelters(String filter) {
        if (filter.isEmpty()) {
            // Jeśli filtr jest pusty, wyświetl wszystkie
            fireTableDataChanged();
        } else {
            shelters.removeIf(shelter -> !shelter.getShelterName().toLowerCase().contains(filter.toLowerCase()));
            fireTableDataChanged();
        }
    }

    public AnimalShelter getShelterAt(int rowIndex) {
        return shelters.get(rowIndex); // Pobierz schronisko na podstawie indeksu w tabeli
    }

} //69
