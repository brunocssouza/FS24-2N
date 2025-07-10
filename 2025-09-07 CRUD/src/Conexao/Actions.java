package Conexao;

import java.math.BigDecimal;
import java.sql.*;

//

// Para SELECT:
import java.util.ArrayList;

import static Conexao.ConexaoDB.fecharConexao;
import static Conexao.ConexaoDB.conectar;

public class Actions {
    public static void read(String table_name, String order_by) {
        String sql = "SELECT * FROM " + table_name + " " + (order_by == null ? "" : "ORDER BY " + order_by);
        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conexao = conectar();
            if(conexao != null) {
                ps = conexao.prepareStatement(sql);
                rs = ps.executeQuery();
                System.out.println("========== TABELA " + table_name + " ==========");
                while(rs.next()) {
                    ArrayList<String> rows = new ArrayList<>();
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        rows.add(rs.getString(i));
                    }
                    System.out.println(rows);
                }

                System.out.println("==================================");
                System.out.println("Tabela " + table_name + " iterada com sucesso.");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar a tabela Alunos: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {rs.close();}
                if (ps != null) {ps.close();}
                if (conexao != null) {fecharConexao(conexao);}
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar recursos: " + ex.getMessage());
            }
        }
    }

        // Adiciona registro na tabela Usuario
    public static void createUsuario(String cpf, String disponibilidade, String usuario_nome, String telefone1, String telefone2, String nacionalidade, String data_nascimento, String senha, String email) {
        String sql = "INSERT INTO usuario (cpf, disponibilidade, usuario_nome, telefone1, telefone2, nacionalidade, data_nascimento, senha, email) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conexao = null;
        PreparedStatement ps = null;
        try {
            conexao = conectar();
            if(conexao != null) {
                ps = conexao.prepareStatement(sql);
                ps.setString(1, cpf);
                ps.setString(2, disponibilidade);
                ps.setString(3, usuario_nome);
                ps.setString(4, telefone1);
                ps.setString(5, telefone2);
                ps.setString(6, nacionalidade);
                ps.setString(7, data_nascimento);
                ps.setString(8, senha);
                ps.setString(9, email);
                int linhasAfetadas = ps.executeUpdate();
                if(linhasAfetadas > 0) {
                    System.out.println("Dado inserido com sucesso!");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir: " + ex.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    fecharConexao(conexao);
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar recursos após inserção: " + ex.getMessage());
            }
        }
    }

    public static void createAluno(String formacao_academica, String idioma_nivelamento, int usuario_id, String cpf) {
        String sql = "INSERT INTO Aluno (formacao_academica, idioma_nivelamento, fk_Usuario_usuario_id, fk_Usuario_cpf) VALUES (?, ?, ?, ?)";
        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, formacao_academica);
            ps.setString(2, idioma_nivelamento);
            ps.setInt(3, usuario_id);
            ps.setString(4, cpf);
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) System.out.println("Aluno inserido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Aluno: " + ex.getMessage());
        }
    }

    public static void createTutor(String cargo, String comentario, String idioma, String descricao, String experiencia, int usuario_id, String cpf) {
        String sql = "INSERT INTO Tutor (cargo, comentario, idioma, descricao, experiencia_profissional, fk_Usuario_usuario_id, fk_Usuario_cpf) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, cargo);
            ps.setString(2, comentario);
            ps.setString(3, idioma);
            ps.setString(4, descricao);
            ps.setString(5, experiencia);
            ps.setInt(6, usuario_id);
            ps.setString(7, cpf);
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) System.out.println("Tutor inserido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Tutor: " + ex.getMessage());
        }
    }

    public static void createFeedback(String avaliacaoFluencia, String sugestaoMelhoria, String avaliacaoTecnica) {
        String sql = "INSERT INTO Feedback (avaliacao_fluencia, sugestao_melhoria, avaliacao_tecnica) VALUES (?, ?, ?)";
        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, avaliacaoFluencia);
            ps.setString(2, sugestaoMelhoria);
            ps.setString(3, avaliacaoTecnica);
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) System.out.println("Feedback inserido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Feedback: " + ex.getMessage());
        }
    }

    public static void createEntrevista(String area, String idioma, Timestamp duracao, int alunoId, String alunoCpf, int tutorId, String tutorCpf, int feedbackId) {
        String sql = "INSERT INTO Entrevista (area, idioma, duracao, fk_Aluno_fk_Usuario_usuario_id, fk_Aluno_fk_Usuario_cpf, fk_Tutor_fk_Usuario_usuario_id, fk_Tutor_fk_Usuario_cpf, fk_Feedback_feedback_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, area);
            ps.setString(2, idioma);
            ps.setTimestamp(3, duracao);
            ps.setInt(4, alunoId);
            ps.setString(5, alunoCpf);
            ps.setInt(6, tutorId);
            ps.setString(7, tutorCpf);
            ps.setInt(8, feedbackId);
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) System.out.println("Entrevista inserida com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Entrevista: " + ex.getMessage());
        }
    }

    public static void createPagamento(String formaPagamento, BigDecimal valor) {
        String sql = "INSERT INTO Pagamento (forma_de_pagamento, valor) VALUES (?, ?)";
        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, formaPagamento);
            ps.setBigDecimal(2, valor);
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) System.out.println("Pagamento inserido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Pagamento: " + ex.getMessage());
        }
    }

    public static void createAgendamento(String area, String idioma, BigDecimal valor, Time duracao, Date data, Time hora, int alunoId, String alunoCpf, int tutorId, String tutorCpf, int pagamentoId) {
        String sql = "INSERT INTO Agendamento (area, idioma, valor, duracao, data, hora, fk_Aluno_fk_Usuario_usuario_id, fk_Aluno_fk_Usuario_cpf, fk_Tutor_fk_Usuario_usuario_id, fk_Tutor_fk_Usuario_cpf, fk_Pagamento_pagamento_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, area);
            ps.setString(2, idioma);
            ps.setBigDecimal(3, valor);
            ps.setTime(4, duracao);
            ps.setDate(5, data);
            ps.setTime(6, hora);
            ps.setInt(7, alunoId);
            ps.setString(8, alunoCpf);
            ps.setInt(9, tutorId);
            ps.setString(10, tutorCpf);
            ps.setInt(11, pagamentoId);
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) System.out.println("Agendamento inserido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Agendamento: " + ex.getMessage());
        }
    }

    public static void createTecnologiaConhecida(String nomeTecnologia) {
        String sql = "INSERT INTO Tecnologia_Conhecida (nome_tecnologia_conhecida) VALUES (?)";
        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, nomeTecnologia);
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) System.out.println("Tecnologia conhecida inserida com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir tecnologia conhecida: " + ex.getMessage());
        }
    }

    public static void createTecnologiaConhecidaTutor(int tutorId, String tutorCpf, int tecnologiaId) {
        String sql = "INSERT INTO TecnologiaConhecida_Tutor (fk_Tutor_fk_Usuario_usuario_id, fk_Tutor_fk_Usuario_cpf, fk_Tecnologia_Conhecida_tecnologia_conhecida_id) VALUES (?, ?, ?)";
        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, tutorId);
            ps.setString(2, tutorCpf);
            ps.setInt(3, tecnologiaId);
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) System.out.println("Relação tutor-tecnologia inserida com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir relação tutor-tecnologia: " + ex.getMessage());
        }
    }

    public static void createEndereco(String bairro, int cep, String complemento, int numero, String rua, String estado, String pais, String cidade) {
        String sql = "INSERT INTO Endereco (bairro, cep, complemento, numero, rua, estado, pais, cidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, bairro);
            ps.setInt(2, cep);
            ps.setString(3, complemento);
            ps.setInt(4, numero);
            ps.setString(5, rua);
            ps.setString(6, estado);
            ps.setString(7, pais);
            ps.setString(8, cidade);
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) System.out.println("Endereço inserido com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Endereço: " + ex.getMessage());
        }
    }

    public static void createEnderecoUsuario(int usuarioId, String cpf, int enderecoId) {
        String sql = "INSERT INTO Endereco_Usuario (fk_Usuario_usuario_id, fk_Usuario_cpf, fk_Endereco_endereco_id) VALUES (?, ?, ?)";
        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, usuarioId);
            ps.setString(2, cpf);
            ps.setInt(3, enderecoId);
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) System.out.println("Relação endereço-usuário inserida com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir relação endereço-usuário: " + ex.getMessage());
        }
    }



}
