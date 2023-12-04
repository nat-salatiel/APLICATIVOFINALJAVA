package model;

import java.util.Date;

public class Advogado {
	private String oab;
	private int idadv;
	private String nome;
	private Date data;
	private String telefone;
	private String status;

	public Advogado() {
		super();
	}

	public Advogado(String oab, int idadv, String nome, Date data,  String telefone, String status) {
		super();
		this.oab = oab;
		this.idadv = idadv;
		this.nome = nome;
		this.data = data;
		this.telefone = telefone;
		this.status = status;

	}
	
	

	public Advogado(int idadv, String nome, Date data, String telefone, String oab) {
		super();
		this.idadv = idadv;
		this.nome = nome;
		this.data = data;
		this.telefone = telefone;
		this.oab = oab;
	}

	public String getOab() {
		return oab;
	}

	public void setOab(String oab) {
		this.oab = oab;
	}

	public int getIdadv() {
		return idadv;
	}

	public void setIdadv(int idadv) {
		this.idadv = idadv;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



}
