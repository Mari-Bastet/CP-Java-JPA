package br.com.fiap;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TDS_TB_PRODUTOCS")
public class Produto {
	
	@Id
	private int id;
	
	@Column(name="NOME", nullable=false, length=50)
	private String nomeProduto;
	
	@Column(name="PRECO", nullable=false)
	private double precoProduto;
	
	@Column(name="VALIDADE")
	private Calendar dataValidade;
	
	@Column(name="TAMANHO", nullable = true)
	private Double tamanhoProduto;
	
	@Column(name="DESCRICAO", nullable=false, length=1000)
	private String descricaoProduto;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public double getTamanhoProduto() {
		return tamanhoProduto;
	}

	public void setTamanhoProduto(Double tamanhoProduto) {
		this.tamanhoProduto = tamanhoProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}
	

}
