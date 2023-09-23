package br.com.crud.dao;

import br.com.crud.model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    private Connection conexao;

    public PedidoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    // Método para adicionar um novo pedido
    public boolean adicionarPedido(Pedido pedido) {
        String sql = "INSERT INTO pedidos (idPedido, dataPedido, diariasPedido, valorPedido, fk_pacote_idPacote, fk_cliente_cpf) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, pedido.getIdPedido());
            pstmt.setDate(2, new java.sql.Date(pedido.getDataPedido().getTime()));
            pstmt.setInt(3, pedido.getDiariasPedido());
            pstmt.setBigDecimal(4, pedido.getValorPedido());
            pstmt.setInt(5, pedido.getFk_pacote_idPacote());
            pstmt.setString(6, pedido.getFk_cliente_cpf());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obter um pedido pelo ID
    public Pedido obterPedidoPorId(int idPedido) {
        String sql = "SELECT * FROM pedidos WHERE idPedido = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, idPedido);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setDataPedido(rs.getDate("dataPedido"));
                pedido.setDiariasPedido(rs.getInt("diariasPedido"));
                pedido.setValorPedido(rs.getBigDecimal("valorPedido"));
                pedido.setFk_pacote_idPacote(rs.getInt("fk_pacote_idPacote"));
                pedido.setFk_cliente_cpf(rs.getString("fk_cliente_cpf"));
                return pedido;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para listar todos os pedidos
    public List<Pedido> listarPedidos() {
        String sql = "SELECT * FROM pedidos";
        List<Pedido> pedidos = new ArrayList<>();
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setDataPedido(rs.getDate("dataPedido"));
                pedido.setDiariasPedido(rs.getInt("diariasPedido"));
                pedido.setValorPedido(rs.getBigDecimal("valorPedido"));
                pedido.setFk_pacote_idPacote(rs.getInt("fk_pacote_idPacote"));
                pedido.setFk_cliente_cpf(rs.getString("fk_cliente_cpf"));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    // Método para atualizar os dados de um pedido
    public boolean atualizarPedido(Pedido pedido) {
        String sql = "UPDATE pedidos SET dataPedido = ?, diariasPedido = ?, valorPedido = ?, fk_pacote_idPacote = ?, fk_cliente_cpf = ? WHERE idPedido = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setDate(1, new java.sql.Date(pedido.getDataPedido().getTime()));
            pstmt.setInt(2, pedido.getDiariasPedido());
            pstmt.setBigDecimal(3, pedido.getValorPedido());
            pstmt.setInt(4, pedido.getFk_pacote_idPacote());
            pstmt.setString(5, pedido.getFk_cliente_cpf());
            pstmt.setInt(6, pedido.getIdPedido());
            int linhasAfetadas = pstmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para excluir um pedido pelo ID
    public boolean excluirPedido(int idPedido) {
        String sql = "DELETE FROM pedidos WHERE idPedido = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, idPedido);
            int linhasAfetadas = pstmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
