package Model;

public class Emprestimo {
    private int id_emprestimo;
    private String data_emprestimo;
    private String data_evolucao;
    private int aluno_idaluno;
    private int livro_idlivro;

    public Emprestimo(int id_emprestimo, String data_emprestimo, String data_evolucao, int aluno_idaluno, int livro_idlivro) {
        this.id_emprestimo = id_emprestimo;
        this.data_emprestimo = data_emprestimo;
        this.data_evolucao = data_evolucao;
        this.aluno_idaluno = aluno_idaluno;
        this.livro_idlivro = livro_idlivro;
    }

    public Emprestimo(String data_emprestimo, String data_evolucao, int aluno_idaluno, int livro_idlivro) {
        this.data_emprestimo = data_emprestimo;
        this.data_evolucao = data_evolucao;
        this.aluno_idaluno = aluno_idaluno;
        this.livro_idlivro = livro_idlivro;
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

    public String getData_evolucao() {
        return data_evolucao;
    }

    public void setData_evolucao(String data_evolucao) {
        this.data_evolucao = data_evolucao;
    }

    public int getAluno_idaluno() {
        return aluno_idaluno;
    }

    public void setAluno_idaluno(int aluno_idaluno) {
        this.aluno_idaluno = aluno_idaluno;
    }

    public int getLivro_idlivro() {
        return livro_idlivro;
    }

    public void setLivro_idlivro(int livro_idlivro) {
        this.livro_idlivro = livro_idlivro;
    }
}
