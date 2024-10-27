import java.time.LocalDate;

class Cat extends Pet {
    public Cat(String name, LocalDate birthDate) {
        super(name, birthDate);
        commands.add("прыгать");
        commands.add("Носиться по дому");
    }

    @Override
    public String makeClass() {
        return "Cat";
    }
}
