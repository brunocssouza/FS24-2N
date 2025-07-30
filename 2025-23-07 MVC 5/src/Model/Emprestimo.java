package Model;

public class Emprestimo {
    private int id_emprestimo;
    private String data_emprestimo;
    private String data_devolucao;
    private int id_aluno;
    private int id_livro;

    public Emprestimo(int id_emprestimo, String data_emprestimo, String data_evolucao, int id_aluno, int id_livro) {
        this.id_emprestimo = id_emprestimo;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_evolucao;
        this.id_aluno = id_aluno;
        this.id_livro = id_livro;
    }

    public Emprestimo(String data_emprestimo, String data_evolucao, int id_aluno, int id_livro) {
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_evolucao;
        this.id_aluno = id_aluno;
        this.id_livro = id_livro;
    }

    public int getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(int id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public String getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(String data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_evolucao(String data_evolucao) {
        this.data_devolucao = data_evolucao;
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }
}
