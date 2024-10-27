import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalRegistry registry = new AnimalRegistry();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Добавить домашнее животное");
            System.out.println("2. Показать список животных");
            System.out.println("3. Показать команды животного");
            System.out.println("4. Показать животных по дате рождения");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя животного: ");
                    String name = scanner.nextLine();
                    LocalDate birthDate = null;

                    while (true) {
                        System.out.print("Введите дату рождения животного (DD MM YYYY): ");
                        String birthDateInput = scanner.nextLine();

                        try {
                            birthDate = LocalDate.parse(birthDateInput, formatter);
                            break; // Выход из цикла, если дата валидна
                        } catch (DateTimeParseException e) {
                            System.out.println("Неверный формат даты. Пожалуйста, введите дату в формате DD MM YYYY.");
                        }
                    }

                    System.out.print("Выберите тип животного (Собака, Кошка, Хомяк): ");
                    String type = scanner.nextLine();

                    Pet pet = null;
                    if (type.equalsIgnoreCase("Собака")) {
                        pet = new Dog(name, birthDate);
                    } else if (type.equalsIgnoreCase("Кошка")) {
                        pet = new Cat(name, birthDate);
                    } else if (type.equalsIgnoreCase("Хомяк")) {
                        pet = new Hamster(name, birthDate);
                    }

                    if (pet != null) {
                        registry.addPet(pet);
                    } else {
                        System.out.println("Неверный тип животного.");
                    }
                    break;

                case 2:
                    registry.displayPets();
                    break;

                case 3:
                    System.out.print("Введите имя животного: ");
                    String petName = scanner.nextLine();
                    pet = registry.findPetByName(petName);
                    if (pet != null) {
                        registry.displayCommands(pet);
                    } else {
                        System.out.println("Животное не найдено.");
                    }
                    break;

                case 4:
                    registry.displayPetsByBirthDate();
                    break;

                case 0:
                    System.out.println("Выход из программы.");
                    return;

                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");

            }
        }
    }
}
