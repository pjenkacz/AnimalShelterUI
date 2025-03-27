import java.time.LocalDate;

public class Animal implements Comparable<Animal> {
    private String name;
    private String species;
    private AnimalCondition condition;
    private int age;
    private double price;

    // Dodatkowe pola
    private double weight;
    private boolean isVaccinated;

    // Konstruktor z podstawowymi i dodatkowymi polami
    public Animal(String name, String species, AnimalCondition condition, int age, double price, double weight, boolean isVaccinated) {
        this.name = name;
        this.species = species;
        this.condition = condition;
        this.age = age;
        this.price = price;
        this.weight = weight;
        this.isVaccinated = isVaccinated;

    }

    // Metoda print() wyświetlająca informacje o zwierzęciu
    public void print() {
        System.out.println("Animal Information:");
        System.out.println("Name: " + name);
        System.out.println("Species: " + species);
        System.out.println("Condition: " + condition);
        System.out.println("Age: " + age + " years");
        System.out.println("Price: $" + price);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Vaccinated: " + (isVaccinated ? "Yes" : "No"));

    }

    // Implementacja interfejsu Comparable<Animal>
    @Override
    public int compareTo(Animal other) {
        // Możemy porównać według imienia, gatunku lub wieku, wybierając jeden priorytet
        // Tu załóżmy porównanie po imieniu jako domyślne
        return this.name.compareTo(other.name);
    }

    // Dodatkowe metody porównawcze (opcjonalnie, jeśli chcemy różne sposoby sortowania)
    public int compareBySpecies(Animal other) {
        return this.species.compareTo(other.species);
    }

    public int compareByAge(Animal other) {
        return Integer.compare(this.age, other.age);
    }

    // Gettery i Settery dla wszystkich pól (opcjonalnie, aby umożliwić późniejsze zmiany)
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative.");
        }
    }
    public void setCondition(AnimalCondition condition) {
        if (age >= 0) {
            this.condition = condition;
        } else {
            System.out.println("Age cannot be negative.");
        }
    }
    public String getSpecies() {
        return species;
    }

    public AnimalCondition getCondition() {
        return condition;
    }

    public int getAge() {
        return age;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

}
