import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShelterManager {
    // Mapa przechowująca schroniska, gdzie kluczem jest nazwa schroniska
    private Map<String, AnimalShelter> shelters;

    // Konstruktor inicjalizujący mapę schronisk
    public ShelterManager() {
        this.shelters = new HashMap<>();
    }

    // a. Metoda addShelter - dodająca nowe schronisko o podanej nazwie i pojemności
    public void addShelter(String name, int capacity, int phone) {
        if (shelters.containsKey(name)) {
            System.out.println("Shelter with the name '" + name + "' already exists.");
        } else {
            shelters.put(name, new AnimalShelter(name, capacity, phone)); //xd
            System.out.println("Shelter '" + name + "' has been added.");
        }
    }

    // b. Metoda removeShelter - usuwająca schronisko o podanej nazwie
    public void removeShelter(String name) {
        if (shelters.remove(name) != null) {
            System.out.println("Shelter '" + name + "' has been removed.");
        } else {
            System.out.println("Shelter '" + name + "' does not exist.");
        }
    }

    // c. Metoda findEmpty - zwracająca listę pustych schronisk
    public List<AnimalShelter> findEmpty() {
        List<AnimalShelter> emptyShelters = new ArrayList<>();  //twoja mama
        for (AnimalShelter shelter : shelters.values()) {
            if (shelter.getAnimalList().isEmpty()) {
                emptyShelters.add(shelter);
            }
        }
        return emptyShelters;
    }

    // d. Metoda summary - wypisująca informacje o schroniskach i procentowym zapełnieniu
    public void summary() {
        System.out.println("Shelter Summary:");
        for (AnimalShelter shelter : shelters.values()) {
            int totalAnimals = shelter.getAnimalList().size(); //kc
            int maxCapacity = shelter.getMaxCapacity();
            double fillPercentage = (double) totalAnimals / maxCapacity * 100;
            System.out.printf("Shelter: %s - Capacity: %d/%d (%.2f%% filled)%n", shelter.getShelterName(), totalAnimals, maxCapacity, fillPercentage);
        }
    }


    public Map<String, AnimalShelter> getShelters() {
        return shelters;
    }

}
