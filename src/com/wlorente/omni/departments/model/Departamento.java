package com.wlorente.omni.departments.model;

public class Departamento {
	
	private Integer id;
	private String  name;
	private String  region;
	private String  city;
	private String  state;
	//private Integer idBoard;
	private String idBoard;
	private boolean isEdicao = true;
	
	public Departamento(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIdBoard() {
		return idBoard;
	}

	public void setIdBoard(String idBoard) {
		this.idBoard = idBoard;
	}

	public boolean isEdicao() {
		return isEdicao;
	}

	public void setEdicao(boolean isEdicao) {
		this.isEdicao = isEdicao;
	}
	
	
	

}
