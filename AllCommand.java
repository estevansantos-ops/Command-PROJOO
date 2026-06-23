import java.util.Map;

public class AllCommand implements Command {
    private Map<Integer, Pessoa> database;

    public AllCommand(Map<Integer, Pessoa> database) {
        this.database = database;
    }

    @Override
    public void execute(String[] args) {
        if (database.isEmpty()) {
            System.out.println("O banco de dados está vazio.");
            return;
        }
        System.out.println("Lista de Pessoas:");
        for (Pessoa p : database.values()) {
            System.out.println(p);
        }
        System.out.println("out");
    }
}
