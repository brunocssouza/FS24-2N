import Conexao.Actions;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Main {

    public static void main(String[] args) {
        Actions.read("Aluno", null);
        Actions.createUsuario("12345678912", "Tarde", "Lucas", "51983581799", "51235236324", "Americana", "2001-11-09", "senha123", "lucas@email.com");
        Actions.createAluno("Ensino Médio", "Intermediário", 1, "12345678912");
        Actions.createTutor("Instrutor", "Pontual e dedicado", "Inglês", "Ensina com foco em fluência", "5 anos de experiência", 2, "98765432100");
        Actions.createFeedback("Avançado", "Mais prática oral", "Boa didática");
        Actions.createEntrevista("Backend", "Inglês", Timestamp.valueOf("2025-07-10 14:00:00"), 1, "12345678912", 2, "98765432100", 1);
        Actions.createPagamento("Cartão de Crédito", new BigDecimal("149.99"));
        Actions.createAgendamento("Frontend", "Português", new BigDecimal("149.99"), Time.valueOf("01:00:00"), Date.valueOf("2025-07-12"), Time.valueOf("15:00:00"), 1, "12345678912", 2, "98765432100", 1);
        Actions.createTecnologiaConhecida("Java");
        Actions.createTecnologiaConhecidaTutor(2, "98765432100", 1);
        Actions.createEndereco("Centro", 90200000, "Apto 204", 120, "Av. Brasil", "RS", "Brasil", "Porto Alegre");
        Actions.createEnderecoUsuario(1, "12345678912", 1);


    }
}
