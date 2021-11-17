package modelo;

import java.util.Objects;

public class Animal {

	private Integer id_animal;
	private String classe;
	private String especie;
	private Boolean extincao;
	private Boolean natureza;
	private Double peso;
	private String raca;

	public Animal() {
	}

	public Animal(String classe, String especie, Boolean extincao, Boolean natureza, Double peso, String raca) {
		super();
		this.classe = classe;
		this.especie = especie;
		this.extincao = extincao;
		this.natureza = natureza;
		this.peso = peso;
		this.raca = raca;
	}

	public Integer getId_animal() {
		return id_animal;
	}

	public void setId_animal(Integer id_animal) {
		this.id_animal = id_animal;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Boolean getExtincao() {
		return extincao;
	}

	public void setExtincao(Boolean extincao) {
		this.extincao = extincao;
	}

	public Boolean getNatureza() {
		return natureza;
	}

	public void setNatureza(Boolean natureza) {
		this.natureza = natureza;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id_animal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(id_animal, other.id_animal);
	}

	
	@Override
	public String toString() {
		return "ID: " + id_animal + " |  Classe: " + classe + " | Espécie: " + especie + " | Extinção: " + extincao
				+ " | Natureza: " + natureza + " | Raça=" + raca + " | Peso: " + String.format("%.2f", peso) + "kg";
	}
}
