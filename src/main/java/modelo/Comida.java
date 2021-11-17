package modelo;

import java.util.Objects;

public class Comida {

	private Integer id_comida;
	private String classe;
	private String descricao;
	private Boolean fitness;
	private String tipo;
	private Double vlr_kg;
	
	public Comida() {	
	}

	public Comida(String classe, String descricao, Boolean fitness, String tipo, Double vlr_kg) {
		super();
		this.classe = classe;
		this.descricao = descricao;
		this.fitness = fitness;
		this.tipo = tipo;
		this.vlr_kg = vlr_kg;
	}

	
	public Integer getId_comida() {
		return id_comida;
	}

	public void setId_comida(Integer id_comida) {
		this.id_comida = id_comida;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getFitness() {
		return fitness;
	}

	public void setFitness(Boolean fitness) {
		this.fitness = fitness;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getVlr_kg() {
		return vlr_kg;
	}

	public void setVlr_kg(Double vlr_kg) {
		this.vlr_kg = vlr_kg;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_comida);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comida other = (Comida) obj;
		return Objects.equals(id_comida, other.id_comida);
	}

	
	@Override
	public String toString() {
		return "ID: " + id_comida + " | Classe: " + classe + "| Descrição: " + descricao + " | Fitness: "
				+ fitness + " | Tipo: " + tipo + " | Valor por KG: R$ " + String.format("%.2f", vlr_kg);
	}
}
