package modelo;

import java.util.Objects;

public class Reserva {

	private Integer id_reserva;
	private String cidade;
	private Double vlr_diaria;
	private Integer nmr;
	private Boolean ocupado;
	private String rua;
	
	public Reserva() {
	}

	public Reserva(String cidade, Double vlr_diaria, Integer nmr, Boolean ocupado, String rua) {
		super();
		this.cidade = cidade;
		this.vlr_diaria = vlr_diaria;
		this.nmr = nmr;
		this.ocupado = ocupado;
		this.rua = rua;
	}

	public Integer getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(Integer id_reserva) {
		this.id_reserva = id_reserva;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Double getVlr_diaria() {
		return vlr_diaria;
	}
	public void setVlr_diaria(Double vlr_diaria) {
		this.vlr_diaria = vlr_diaria;
	}
	public Integer getNmr() {
		return nmr;
	}
	public void setNmr(Integer nmr) {
		this.nmr = nmr;
	}
	public Boolean getOcupado() {
		return ocupado;
	}
	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_reserva);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(id_reserva, other.id_reserva);
	}

	@Override
	public String toString() {
		return "ID: " + id_reserva + " | Cidade: " + cidade + " | Valor Diária: R$ " + String.format("%.2f", vlr_diaria)
		+ " | Número: " + nmr + " | Ocupado: " + ocupado + " | Rua: " + rua;
	}
}
