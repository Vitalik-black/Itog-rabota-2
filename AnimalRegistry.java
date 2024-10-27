import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.time.format.DateTimeFormatter;

class AnimalRegistry {
    private List<Pet> pets;

    public AnimalRegistry() {
        this.pets = new ArrayList<>();
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public Pet findPetByName(String name) {
        for (Pet pet : pets) {
            if (pet.getName().equalsIgnoreCase(name)) {
                return pet;
            }
        }
        return null;
    }

    public void displayCommands(Pet pet) {
        if (pet.getCommands().isEmpty()) {
            System.out.println(pet.getName() + " не знает ни одной команды.");
        } else {
            System.out.println(pet.getName() + " знает команды: ");
            for (String command : pet.getCommands()) {
                System.out.println("- " + command);
            }
        }
    }

    public void displayPets() {
        System.out.println("Список домашних животных:");
        for (Pet pet : pets) {
            System.out.println(pet.getName() + " - " + pet.makeClass());
        }
    }

    public void displayPetsByBirthDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        pets.sort(Comparator.comparing(Pet::getBirthDate));
        System.out.println("Животные, отсортированные по дате рождения:");
        for (Pet pet : pets) {
            System.out.println(pet.getName() + " - Дата рождения: " + pet.getBirthDate().format(formatter));
        }
    }

    public int getPetCount() {
        return pets.size();
    }
}
