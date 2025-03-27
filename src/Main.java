import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Tworzenie obiektów Animal
        Animal animal1 = new Animal("Max", "Dog", AnimalCondition.ZDROWE, 5, 150.00, 20.0, true);
        Animal animal2 = new Animal("Bella", "Cat", AnimalCondition.CHORE, 3, 100.00, 5.0, false);
        Animal animal3 = new Animal("Charlie", "Rabbit", AnimalCondition.KWARANTANNA, 2, 50.00, 1.5, true);
        Animal animal4 = new Animal("Milo", "Parrot", AnimalCondition.W_TRAKCIE_ADOPCJI, 1, 75.00, 0.3, true);
        Animal animal5 = new Animal("Rocardo", "Gaga", AnimalCondition.ZDROWE, 14, 999.00, 12.3, true);
        Animal animal6 = new Animal("Luna", "Dog", AnimalCondition.ZDROWE, 6, 120.00, 18.0, true);
        Animal animal7 = new Animal("Oscar", "Cat", AnimalCondition.CHORE, 4, 110.00, 4.8, false);
        Animal animal8 = new Animal("Daisy", "Rabbit", AnimalCondition.KWARANTANNA, 3, 60.00, 1.8, true);
        Animal animal9 = new Animal("Coco", "Parrot", AnimalCondition.W_TRAKCIE_ADOPCJI, 2, 80.00, 0.4, true);
        Animal animal10 = new Animal("Buddy", "Dog", AnimalCondition.ZDROWE, 7, 140.00, 25.0, true);

        Animal animal11 = new Animal("Molly", "Cat", AnimalCondition.CHORE, 5, 95.00, 4.5, false);
        Animal animal12 = new Animal("Ruby", "Dog", AnimalCondition.ZDROWE, 4, 130.00, 22.0, true);
        Animal animal13 = new Animal("Oliver", "Parrot", AnimalCondition.W_TRAKCIE_ADOPCJI, 1, 70.00, 0.35, true);
        Animal animal14 = new Animal("Charlie", "Dog", AnimalCondition.KWARANTANNA, 8, 160.00, 30.0, true);
        Animal animal15 = new Animal("Lucy", "Cat", AnimalCondition.ZDROWE, 3, 90.00, 4.0, true);

        Animal animal16 = new Animal("Max", "Rabbit", AnimalCondition.CHORE, 2, 50.00, 1.7, false);
        Animal animal17 = new Animal("Lily", "Dog", AnimalCondition.ZDROWE, 5, 150.00, 19.0, true);
        Animal animal18 = new Animal("Bella", "Parrot", AnimalCondition.W_TRAKCIE_ADOPCJI, 1, 75.00, 0.3, true);
        Animal animal19 = new Animal("Rex", "Dog", AnimalCondition.ZDROWE, 10, 200.00, 35.0, true);
        Animal animal20 = new Animal("Rocky", "Cat", AnimalCondition.ZDROWE, 4, 115.00, 4.6, true);

        Animal animal21 = new Animal("Duke", "Dog", AnimalCondition.KWARANTANNA, 3, 145.00, 20.5, false);
        Animal animal22 = new Animal("Zoe", "Rabbit", AnimalCondition.ZDROWE, 2, 55.00, 1.3, true);
        Animal animal23 = new Animal("Chloe", "Cat", AnimalCondition.CHORE, 6, 105.00, 4.2, false);
        Animal animal24 = new Animal("Finn", "Dog", AnimalCondition.W_TRAKCIE_ADOPCJI, 7, 155.00, 24.0, true);
        Animal animal25 = new Animal("Ellie", "Rabbit", AnimalCondition.ZDROWE, 3, 60.00, 1.4, true);

        Animal animal26 = new Animal("Milo", "Dog", AnimalCondition.KWARANTANNA, 8, 165.00, 32.0, true);
        Animal animal27 = new Animal("Willow", "Cat", AnimalCondition.ZDROWE, 5, 100.00, 5.0, true);
        Animal animal28 = new Animal("Riley", "Dog", AnimalCondition.ZDROWE, 6, 180.00, 28.0, true);
        Animal animal29 = new Animal("Luna", "Rabbit", AnimalCondition.CHORE, 4, 65.00, 1.6, false);
        Animal animal30 = new Animal("Max", "Parrot", AnimalCondition.ZDROWE, 3, 85.00, 0.5, true);

        // Tworzenie menedżera schronisk
        ShelterManager shelterManager = new ShelterManager();

        // Dodawanie schronisk do menedżera
        shelterManager.addShelter("Happy Paws Shelter", 3, 787123412);
        shelterManager.addShelter("Green Acres Sanctuary", 5, 998776111);
        shelterManager.addShelter("Rymcym Dachowo", 4, 555123456);
        shelterManager.addShelter("Jazdunia u Jadzi Schron", 6, 444987321);
        shelterManager.addShelter("Robotniczy Garnizon", 5, 333654789);
        shelterManager.addShelter("Kotkowo Pieskowo v2", 7, 222345678);
        shelterManager.addShelter("Schronisko Nigga", 8, 111234567);

        // Pobranie obiektów schronisk
        AnimalShelter happyPawsShelter = shelterManager.getShelters().get("Happy Paws Shelter");
        AnimalShelter greenAcresSanctuary = shelterManager.getShelters().get("Green Acres Sanctuary");

        // Dodawanie zwierząt do schronisk
        if (happyPawsShelter != null) {
            happyPawsShelter.addAnimal(animal1);
            happyPawsShelter.addAnimal(animal2);
        }

        if (greenAcresSanctuary != null) {
            greenAcresSanctuary.addAnimal(animal3);
            greenAcresSanctuary.addAnimal(animal4);
        }

        // Przypisywanie zwierząt do schronisk
        AnimalShelter sunnyHaven = shelterManager.getShelters().get("Rymcym Dachowo");
        if (sunnyHaven != null) {
            sunnyHaven.addAnimal(animal6);
            sunnyHaven.addAnimal(animal7);
            sunnyHaven.addAnimal(animal8);
            sunnyHaven.addAnimal(animal9);
            sunnyHaven.addAnimal(animal10);
        }

        AnimalShelter cozyCritters = shelterManager.getShelters().get("Jazdunia u Jadzi Schron");
        if (cozyCritters != null) {
            cozyCritters.addAnimal(animal11);
            cozyCritters.addAnimal(animal12);
            cozyCritters.addAnimal(animal13);
            cozyCritters.addAnimal(animal14);
            cozyCritters.addAnimal(animal15);
        }

        AnimalShelter forestFriends = shelterManager.getShelters().get("Robotniczy Garnizon");
        if (forestFriends != null) {
            forestFriends.addAnimal(animal16);
            forestFriends.addAnimal(animal17);
            forestFriends.addAnimal(animal18);
            forestFriends.addAnimal(animal19);
            forestFriends.addAnimal(animal20);
        }

        AnimalShelter urbanPaws = shelterManager.getShelters().get("Kotkowo Pieskowo v2");
        if (urbanPaws != null) {
            urbanPaws.addAnimal(animal21);
            urbanPaws.addAnimal(animal22);
            urbanPaws.addAnimal(animal23);
            urbanPaws.addAnimal(animal24);
            urbanPaws.addAnimal(animal25);
        }

        AnimalShelter harmonyHaven = shelterManager.getShelters().get("Schronisko Nigga");
        if (harmonyHaven != null) {
            harmonyHaven.addAnimal(animal26);
            harmonyHaven.addAnimal(animal27);
            harmonyHaven.addAnimal(animal28);
            harmonyHaven.addAnimal(animal29);
            harmonyHaven.addAnimal(animal30);
        }

        // Wyświetlenie podsumowania wszystkich schronisk
        shelterManager.summary();

        // Przykładowe wyszukiwanie pustych schronisk
        System.out.println("\nEmpty Shelters:");
        for (AnimalShelter emptyShelter : shelterManager.findEmpty()) {
            System.out.println("- " + emptyShelter.getShelterName());
        }

        // Przykładowe wyszukiwanie zwierzęcia po nazwie
        Animal foundAnimal = happyPawsShelter.search("Max");
        if (foundAnimal != null) {
            System.out.println("\nFound animal:");
            foundAnimal.print();
        }

        // Przykładowe usunięcie zwierzęcia ze schroniska
        happyPawsShelter.removeAnimal(animal1);

        // Przykładowe wyświetlenie zwierząt po usunięciu
        System.out.println("\nSummary after removing an animal from Happy Paws Shelter:");
        happyPawsShelter.summary();

        happyPawsShelter.addAnimal(animal5);
        System.out.println("\nSummary after adding an animal from Happy Paws Shelter:");
        happyPawsShelter.summary();


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame(shelterManager).setVisible(true);
                //AdminPanel adminPanel = new AdminPanel(shelterManager);
                //ClientPanel clientPanel = new ClientPanel(shelterManager);
            }
        });


    }
}

