import java.time.LocalDate;

class Dog extends Pet {
    public Dog(String name, LocalDate birthDate) {
        super(name, birthDate);
        commands.add("сидеть");
        commands.add("лежать");
    }

    @Override
    public String makeClass() {
        return "Dog";
    }
}
