package br.com.sefaz.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.sefaz.dao.UsuarioDao;
import br.com.sefaz.dao.UsuarioDaoImpl1;
import br.com.sefaz.model.Telefone;
import br.com.sefaz.model.Usuario;
import br.com.sefaz.model.conexao.Conexao;

public class UsuarioController {

	public static void main(String[] args) {
		
		
		UsuarioDao usuarioDao = new UsuarioDaoImpl1();
		Telefone raul = new Telefone();
		raul.setDdd(87);
		raul.setNumero("123654");
		raul.setTipo("fixo");

		Telefone gael = new Telefone();
		gael.setDdd(81);
		gael.setNumero("8974526");
		gael.setTipo("movel");

		Telefone nydia = new Telefone();
		nydia.setDdd(81);
		nydia.setNumero("856412");
		nydia.setTipo("movel");

		List<Telefone> listaRaul = new ArrayList<Telefone>();
		listaRaul.add(raul);
		List<Telefone> listaGael = new ArrayList<Telefone>();
		listaGael.add(gael);
		List<Telefone> listaNydia = new ArrayList<Telefone>();
		listaNydia.add(nydia);


		Usuario raul_j = new Usuario("raul", "raul@eusoueu.com", "xxxxx", listaRaul);
		Usuario gael_j = new Usuario("gael", "gael@eusoueu.com", "xxxxx", listaGael);
		Usuario nydia_j = new Usuario("nydia", "nydia@eusoueu.com", "xxxxx", listaNydia);
		
		usuarioDao.cadastrar(nydia_j);
		usuarioDao.cadastrar(raul_j);
		usuarioDao.cadastrar(gael_j);
		
		List<Usuario> lista = usuarioDao.listarUsuarios();
		for (Usuario usuario : lista) {
			System.out.println(usuario.toString());
		}
		
		
		usuarioDao.remover(raul_j);
		System.out.println("====================================================================================");
		List<Usuario> lista1 = usuarioDao.listarUsuarios();
		for (Usuario usuario : lista1) {
			System.out.println(usuario.toString());
		}
		
	}

}
