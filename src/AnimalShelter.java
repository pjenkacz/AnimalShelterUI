import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnimalShelter {
    private String shelterName;
    private List<Animal> animalList;
    private int maxCapacity;
    private int phoneNumber;

    // Konstruktor
    public AnimalShelter(String shelterName, int maxCapacity, int phone) {
        this.shelterName = shelterName;
        this.animalList = new ArrayList<>();
        this.maxCapacity = maxCapacity;
        this.phoneNumber = phone;
    }

    // a. Metoda addAnimal - dodawanie zwierzęcia do schroniska
    public void addAnimal(Animal animal) {
        if (animalList.size() >= maxCapacity) {
            System.err.println("Cannot add animal. Maximum capacity reached.");
            return;
        }

        for (Animal a : animalList) {
            if (a.getName().equals(animal.getName()) && a.getSpecies().equals(animal.getSpecies()) && a.getAge() == animal.getAge()) {
                System.out.println("Animal already exists in the shelter.");
                return;
            }
        }

        animalList.add(animal);
    }

    // b. Metoda removeAnimal - usuwanie zwierzęcia ze schroniska
    public void removeAnimal(Animal animal) {
        animalList.remove(animal);
    }

    // c. Metoda getAnimal - adopcja zwierzęcia (zmiana stanu i usunięcie ze schroniska)
    public void getAnimal(Animal animal) {
        if (animalList.contains(animal)) {

            animalList.remove(animal);
            System.out.println(animal.getName() + " has been adopted.");
        } else {
            System.out.println("Animal not found in the shelter.");
        }
    }

    // d. Metoda changeCondition - zmiana stanu zwierzęcia
    public void changeCondition(Animal animal, AnimalCondition condition) {
        if (animalList.contains(animal)) {
            animal.setCondition(condition);
        } else {
            System.out.println("Animal not found in the shelter.");
        }
    }

    // e. Metoda changeAge - zmiana wieku zwierzęcia
    public void changeAge(Animal animal, int age) {
        if (animalList.contains(animal)) {
            animal.setAge(age);
        } else {
            System.out.println("Animal not found in the shelter.");
        }
    }

    // f. Metoda countByCondition - liczenie zwierząt w danym stanie
    public int countByCondition(AnimalCondition condition) {
        int count = 0;
        for (Animal animal : animalList) {
            if (animal.getCondition() == condition) {
                count++;
            }
        }
        return count;
    }

    // g. Metoda sortByName - zwracanie listy zwierząt posortowanej po imieniu
    public List<Animal> sortByName() {
        List<Animal> sortedList = new ArrayList<>(animalList);
        sortedList.sort(Comparator.comparing(Animal::getName)); //dzialka koksu
        return sortedList;
    }

    // h. Metoda sortByPrice - zwracanie listy zwierząt posortowanej po cenie rosnąco
    public List<Animal> sortByPrice() {
        List<Animal> sortedList = new ArrayList<>(animalList);
        sortedList.sort(Comparator.comparingDouble(Animal::getPrice)); //nigger
        return sortedList;
    }

    // i. Metoda search - szukanie zwierzęcia po imieniu
    public Animal search(String name) {
        for (Animal animal : animalList) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        System.out.println("Animal with name " + name + " not found."); //nigger
        return null;
    }

    // j. Metoda searchPartial - wyszukiwanie częściowe po nazwie lub gatunku
    public List<Animal> searchPartial(String query) {
        List<Animal> result = new ArrayList<>();
        for (Animal animal : animalList) {
            if (animal.getName().toLowerCase().contains(query.toLowerCase()) ||
                    animal.getSpecies().toLowerCase().contains(query.toLowerCase())) {
                result.add(animal);
            }
        }
        return result;
    }

    // k. Metoda summary - wypisywanie informacji o wszystkich zwierzętach
    public void summary() {
        System.out.println("Shelter Summary:");
        System.out.println("Shelter Name: " + shelterName);
        System.out.println("Total Animals: " + animalList.size() + "/" + maxCapacity);
        for (Animal animal : animalList) {
            animal.print();
            System.out.println("--------------------");
        }
    }

    // l. Metoda max - zwracanie zwierzęcia o najwyższej cenie czyt. 69
    public Animal max() {
        return Collections.max(animalList, Comparator.comparingDouble(Animal::getPrice));
    }

    public String getShelterName() {
        return shelterName;
    } //420

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
}
