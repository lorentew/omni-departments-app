package com.wlorente.omni.departments.controller;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.wlorente.omni.departments.model.Departamento;
import com.wlorente.omni.departments.model.Estado;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@ManagedBean
public class DepartmentsBean {

	Integer parametroRecebido;

	public Departamento depto = new Departamento();

	public void carregar(Integer id) {

		Client c = Client.create();
		WebResource wr = c.resource("https://omni-departments.herokuapp.com/api/departments/" + id);

		String json = wr.get(String.class);
		Gson gson = new Gson();
		depto = gson.fromJson(json, new TypeToken<Departamento>() {
		}.getType());

		org.primefaces.context.DefaultRequestContext.getCurrentInstance().update("frm:painel-dialog-departamento");
		org.primefaces.context.DefaultRequestContext.getCurrentInstance().update("frm:painel-dialog-diretoria");
	}

	public List<Departamento> getDepartamentos() {

		Client c = Client.create();
		WebResource wr = c.resource("https://omni-departments.herokuapp.com/api/departments");

		String json = wr.get(String.class);
		Gson gson = new Gson();
		return gson.fromJson(json, new TypeToken<List<Departamento>>() {
		}.getType());
	}

	public Estado[] getEstados() {
		return Estado.values();
	}

	public void deletar() throws IOException {

		OkHttpClient client = new OkHttpClient().newBuilder().build();
		MediaType mediaType = MediaType.parse("text/plain");
		RequestBody body = RequestBody.create(mediaType, "");
		Request request = new Request.Builder().url("https://omni-departments.herokuapp.com/api/departments/" + parametroRecebido)
				.method("DELETE", body).build();
		Response response = client.newCall(request).execute();
	}

	public void editar() throws IOException {
		depto.setEdicao(true);
		carregar(parametroRecebido);
	}

	public Departamento getDepto() {
		return depto;
	}

	public void setDepto(Departamento depto) {
		this.depto = depto;
	}

	public void getParameter(ActionEvent event) {
		parametroRecebido = (Integer) event.getComponent().getAttributes().get("parametro");
	}

	public void getObject(ActionEvent event) throws IOException {
		Departamento novoDepartamento = (Departamento) event.getComponent().getAttributes().get("depto");
		gravar(novoDepartamento);
	}

	public void gravar(Departamento depto) throws IOException {
		String jSon = "{\n    " + "\"name\": \"pName\",\n    \"region\": \"pRegion\",\n    "
				+ "\"city\": \"pCity\",\n    \"state\": \"pState\"," + "\n\t\"idBoard\": \"pIdBoard\"\n}";

		jSon = jSon.replace("pName", depto.getName());
		jSon = jSon.replace("pRegion", depto.getRegion());
		jSon = jSon.replace("pCity", depto.getCity());
		jSon = jSon.replace("pState", depto.getState());
		jSon = jSon.replace("pIdBoard", depto.getIdBoard());

		if (depto.getId() == null) { // inserir novo registro
			OkHttpClient client = new OkHttpClient().newBuilder().build();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, jSon);
			Request request = new Request.Builder().url("https://omni-departments.herokuapp.com/api/departments").method("POST", body)
					.addHeader("Content-Type", "application/json").build();
			Response response = client.newCall(request).execute();
			
			if (response.code()!=201) {
				System.out.println("Erro: " + response.message());
			}

		} else {
			OkHttpClient client = new OkHttpClient().newBuilder().build();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, jSon);
			Request request = new Request.Builder().url("https://omni-departments.herokuapp.com/api/departments/" + depto.getId())
					.method("PUT", body).addHeader("Content-Type", "application/json").build();
			Response response = client.newCall(request).execute();

			if (response.code()!=204) {
				System.out.println("Erro: " + response.message());
			}
		}
		

	}

}
