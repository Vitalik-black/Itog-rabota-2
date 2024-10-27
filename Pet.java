import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class Pet {
    private String name;
    private LocalDate birthDate;
    protected List<String> commands;

    public Pet(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public abstract String makeClass();

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }
}
