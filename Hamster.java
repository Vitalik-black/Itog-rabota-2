import java.time.LocalDate;

class Hamster extends Pet {
    public Hamster(String name, LocalDate birthDate) {
        super(name, birthDate);
        commands.add("бегать в колесе");
        commands.add("кушать");
    }

    @Override
    public String makeClass() {
        return "Hamster";
    }
}
