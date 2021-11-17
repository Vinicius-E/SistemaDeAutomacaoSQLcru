package modelo;

import java.util.Objects;

public class Carro {

	private Integer id_carro;
	private Integer ano;
	private String cor;
	private String modelo;
	private String placa;
	private Double vlr_fipe;
	
	public Carro() {	
	}

	public Carro(Integer ano, String cor, String modelo, String placa, Double vlr_fipe) {
		super();
		this.ano = ano;
		this.cor = cor;
		this.modelo = modelo;
		this.placa = placa;
		this.vlr_fipe = vlr_fipe;
	}

	
	public Integer getId_carro() {
		return id_carro;
	}

	public void setId_carro(Integer id_carro) {
		this.id_carro = id_carro;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Double getVlr_fipe() {
		return vlr_fipe;
	}

	public void setVlr_fipe(Double vlr_fipe) {
		this.vlr_fipe = vlr_fipe;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id_carro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(id_carro, other.id_carro);
	}

	public String toString() {
		return "ID: " + id_carro + " | Ano: " + ano + " | Cor: " + cor + " | Modelo: " + modelo + " |  Placa:"
				+ placa + " | Preço na Tabela Fipe: R$ " + String.format("%.2f", vlr_fipe);
	}
	
	
	
}
