package model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pessoa {

	private int id;
	private String nome;
	private LocalDate dataNascimento;
	
}
