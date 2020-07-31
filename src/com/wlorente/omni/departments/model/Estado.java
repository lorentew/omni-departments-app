package com.wlorente.omni.departments.model;

public enum Estado {
	
	SP("SÃO PAULO"), 
	RJ("RIO DE JANEIRO"),
	MG("MINAS GERAIS"),
	PR("PARANÁ"),
	SC("SANTA CATARINA"),
	RN("RIO GRANDE DO NORTE"),
	RS("RIO GRANDE DO SUL"),
	AM("AMAZONAS"),
	ES("ESPIRITO SANTO"),
	MT("MATO GROSSO"),
	MS("MATO GROSSO DO SUL"),
	PI("PIAUI"),
	PE("PERNAMBUCO");
	
	private String descricao;

	Estado(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	

}
