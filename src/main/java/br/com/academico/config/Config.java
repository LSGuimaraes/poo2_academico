package br.com.academico.config;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.academico.entities.Aluno;
import br.com.academico.entities.Curso;
import br.com.academico.repositories.AlunoRepository;
import br.com.academico.repositories.CursoRepository;

@Configuration
public class Config implements CommandLineRunner {

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public void run(String... args) throws Exception {

		Curso poo = new Curso(null, "PROGRAMAÇÃO ORIENTADA A OBJETOS");
		Curso bd = new Curso(null, "BANCO DE DADOS");
		Curso proi = new Curso(null, "PROGRAMAÇÃO PARA INTERNET");

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, Calendar.OCTOBER);
		cal.set(Calendar.DAY_OF_MONTH, 29);
		java.sql.Date dataNasc = new Date(cal.getTimeInMillis());

		Aluno pedro = new Aluno(null, "PEDRO", "M", dataNasc);
		Aluno tiago = new Aluno(null, "TIAGO", "M", dataNasc);
		Aluno joao = new Aluno(null, "JOAO", "M", dataNasc);
		Aluno nobarquinho = new Aluno(null, "NOBARQUINHO", "M", dataNasc);

		/*
		 * pedro.addCurso(poo); tiago.addCurso(poo); tiago.addCurso(bd);
		 * joao.addCurso(poo); joao.addCurso(bd); joao.addCurso(proi);
		 */
		
		cursoRepository.save(poo);
		cursoRepository.save(bd);
		cursoRepository.save(proi);

		alunoRepository.save(pedro);
		alunoRepository.save(tiago);
		alunoRepository.save(joao);
		alunoRepository.save(nobarquinho);

	}

}
