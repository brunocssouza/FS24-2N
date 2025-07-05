import Conexao.Actions;

public class Main {
    public static void main(String[] args) {
        Actions.read("Aluno", null);
        Actions.createAluno(
                "Graduação em Ciência de Dados",
                "Intermediário",
                4,
                876543210
        );
    }
}
