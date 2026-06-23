import java.util.Map;

public class GetCommand implements Command {
    private Map<Integer, Pessoa> database;

    public GetCommand(Map<Integer, Pessoa> database) {
        this.database = database;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: get <id>");
            return;
        }
        try {
            int id = Integer.parseInt(args[0]);
            Pessoa p = database.get(id);
            if (p != null) {
                System.out.println(p);
            } else {
                System.out.println("Erro: Pessoa com ID " + id + " não encontrada.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: O ID deve ser um número inteiro.");
        }
    }
}
