package br.com.academico.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso")
	private Integer id;

	@Column(name = "nome_curso")
	private String nome;

	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "aluno_curso", joinColumns = @JoinColumn(name = "id_curso"), inverseJoinColumns = @JoinColumn(name = "id_aluno"))
	private List<Aluno> alunos = new ArrayList<Aluno>();

	public Curso() {
	}

	public Curso(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public void addAluno(Aluno a) {
		this.alunos.add(a);
		a.getCursos().add(this);
	}

	public void removeAluno(Aluno a) {
		this.alunos.remove(a);
		a.getCursos().remove(this);
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", alunos=" + alunos + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alunos == null) ? 0 : alunos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (alunos == null) {
			if (other.alunos != null)
				return false;
		} else if (!alunos.equals(other.alunos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
