package br.com.sefaz.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.sefaz.model.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	private List<Usuario> listaUsuarios = new ArrayList<Usuario>();

	public List<Usuario> listarUsuarios() {
		return this.listaUsuarios;
	}

	public void cadastrar(Usuario usuario) {
		this.listaUsuarios.add(usuario);
	}

	public void alterar(Usuario usuario) {
		for (Usuario usu : listaUsuarios) {
			if (usu.getId() == usuario.getId()) {
				remover(usu);
				this.listaUsuarios.add(usuario);
			}
		}
	}

	public void remover(Usuario usuario) {

		for (int i = 0; i < this.listaUsuarios.size(); i++) {
			Usuario usu = this.listaUsuarios.get(i);
			if (usu.getId() == usuario.getId()) {
				this.listaUsuarios.remove(i);
			}
		}
	}

}
