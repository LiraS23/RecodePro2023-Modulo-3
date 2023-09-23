package br.com.crud.dao;

import br.com.crud.model.Pacote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacoteDAO {
    private Connection conexao;

    public PacoteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    // Método para adicionar um novo pacote
    public boolean adicionarPacote(Pacote pacote) {
        String sql = "INSERT INTO pacotes (idPacote, destino, valorDiaria) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, pacote.getIdPacote());
            pstmt.setString(2, pacote.getDestino());
            pstmt.setBigDecimal(3, pacote.getValorDiaria());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obter um pacote pelo ID
    public Pacote obterPacotePorId(int idPacote) {
        String sql = "SELECT * FROM pacotes WHERE idPacote = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, idPacote);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Pacote pacote = new Pacote();
                pacote.setIdPacote(rs.getInt("idPacote"));
                pacote.setDestino(rs.getString("destino"));
                pacote.setValorDiaria(rs.getBigDecimal("valorDiaria"));
                return pacote;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para listar todos os pacotes
    public List<Pacote> listarPacotes() {
        String sql = "SELECT * FROM pacotes";
        List<Pacote> pacotes = new ArrayList<>();
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Pacote pacote = new Pacote();
                pacote.setIdPacote(rs.getInt("idPacote"));
                pacote.setDestino(rs.getString("destino"));
                pacote.setValorDiaria(rs.getBigDecimal("valorDiaria"));
                pacotes.add(pacote);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacotes;
    }

    // Método para atualizar os dados de um pacote
    public boolean atualizarPacote(Pacote pacote) {
        String sql = "UPDATE pacotes SET destino = ?, valorDiaria = ? WHERE idPacote = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, pacote.getDestino());
            pstmt.setBigDecimal(2, pacote.getValorDiaria());
            pstmt.setInt(3, pacote.getIdPacote());
            int linhasAfetadas = pstmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para excluir um pacote pelo ID
    public boolean excluirPacote(int idPacote) {
        String sql = "DELETE FROM pacotes WHERE idPacote = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, idPacote);
            int linhasAfetadas = pstmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
