package br.com.sefaz.dao;

import java.util.List;

import br.com.sefaz.model.Usuario;

public interface UsuarioDao {
	
	public List<Usuario> listarUsuarios();
	public void cadastrar(Usuario usuario);
	public void alterar(Usuario usuario);
	public void remover(Usuario usuario);

}
