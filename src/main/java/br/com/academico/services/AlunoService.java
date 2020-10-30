package br.com.academico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.academico.entities.Aluno;
import br.com.academico.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	public Aluno findById(Integer id) {
		return alunoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public Aluno insert(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public void delete(Integer id) {
		alunoRepository.findById(id).map(aluno -> {
			alunoRepository.delete(aluno);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public void update(Integer id, Aluno obj) {
		alunoRepository.findById(id).map(aluno -> {
			aluno.setNome(obj.getNome());
			aluno.setSexo(obj.getSexo());
			aluno.setDataNascimento(obj.getDataNascimento());
			aluno.setCursos(obj.getCursos());
			return alunoRepository.save(aluno);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
