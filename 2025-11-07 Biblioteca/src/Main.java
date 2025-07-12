import Dao.AlunoDAO;
import Model.Aluno;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        AlunoDAO alunoDAO = new AlunoDAO();

        Aluno aluno1 = new Aluno("Bruno", 23, 983581798);
        Aluno aluno2 = new Aluno("José", 66, 952355494);
        alunoDAO.setAluno(aluno1);
        alunoDAO.setAluno(aluno2);

        // READ
        System.out.println("> Testando Listagem:");
        ArrayList<Aluno> alunos = AlunoDAO.getAluno();
        if (!alunos.isEmpty()) {
            for (Aluno aluno : alunos) {
                System.out.println(aluno.getNome());
            }
        }

        // UPDATE
        System.out.println("> Testando Atualizar:");
        Aluno alunoAtualizado = new Aluno(1, "Lucas", 11, 947213124);
        alunoDAO.updateAluno(alunoAtualizado);




    }
}
