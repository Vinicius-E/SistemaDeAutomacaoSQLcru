package modelo;

import java.util.Objects;

public class Eletronico {

	private Integer id_elet;
	private String cor;
	private Boolean funciona;
	private String modelo;
	private Double valor;
	private String tipo;
	
	public Eletronico() {
	}

	public Eletronico(String cor, Boolean funciona, String modelo, Double valor, String tipo) {
		super();
		this.cor = cor;
		this.funciona = funciona;
		this.modelo = modelo;
		this.valor = valor;
		this.tipo = tipo;
	}

	
	public Integer getId_elet() {
		return id_elet;
	}

	public void setId_elet(Integer id_elet) {
		this.id_elet = id_elet;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Boolean getFunciona() {
		return funciona;
	}

	public void setFunciona(Boolean funciona) {
		this.funciona = funciona;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_elet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eletronico other = (Eletronico) obj;
		return Objects.equals(id_elet, other.id_elet);
	}

	@Override
	public String toString() {
		return "ID: " + id_elet + " | Cor: " + cor + " | Funciona: " + funciona + " | Modelo: " + modelo
				+ " | Valor: R$ " + String.format("%.2f", valor) + " | Tipo: " + tipo;
	}	
}
