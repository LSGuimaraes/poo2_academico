package br.com.academico.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluno")
	private Integer id;

	@Column(name = "nome_aluno")
	private String nome;

	private String sexo;

	@Column(name = "data_nasc")
	private Date dataNascimento;

	@ManyToMany(mappedBy = "alunos")
	private List<Curso> cursos = new ArrayList<Curso>();

	public Aluno() {
	}

	public Aluno(Integer id, String nome, String sexo, Date dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}

	public void addCurso(Curso c) {
		this.cursos.add(c);
		c.getAlunos().add(this);
	}

	public void removeCurso(Curso c) {
		this.cursos.remove(c);
		c.getAlunos().remove(this);
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento
				+ ", cursos=" + cursos + "]";
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cursos == null) ? 0 : cursos.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Aluno other = (Aluno) obj;
		if (cursos == null) {
			if (other.cursos != null)
				return false;
		} else if (!cursos.equals(other.cursos))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
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
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}

}
