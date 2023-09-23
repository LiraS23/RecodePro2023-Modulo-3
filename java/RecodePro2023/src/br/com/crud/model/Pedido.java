package br.com.crud.model;

import java.math.BigDecimal;
import java.util.Date;

public class Pedido {
	
	private int idPedido;
	private Date dataPedido;
	private int diariasPedido;
	private BigDecimal valorPedido;
	private int fk_pacote_idPacote;
	private String fk_cliente_cpf;
	
	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public int getDiariasPedido() {
		return diariasPedido;
	}

	public void setDiariasPedido(int diariasPedido) {
		this.diariasPedido = diariasPedido;
	}

	public BigDecimal getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}

	public int getFk_pacote_idPacote() {
		return fk_pacote_idPacote;
	}

	public void setFk_pacote_idPacote(int fk_pacote_idPacote) {
		this.fk_pacote_idPacote = fk_pacote_idPacote;
	}

	public String getFk_cliente_cpf() {
		return fk_cliente_cpf;
	}

	public void setFk_cliente_cpf(String fk_cliente_cpf) {
		this.fk_cliente_cpf = fk_cliente_cpf;
	}

}
