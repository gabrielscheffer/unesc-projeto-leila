package net.unesc.locadoravirtual.vo;

import java.util.ArrayList;
import java.util.List;

import net.unesc.locadoravirtual.R;

public class DataBase {

	private static List<Filmes> filmes;
	private static List<Filmes> carrinho = new ArrayList<Filmes>();
	private static List<Filmes> favoritos = new ArrayList<Filmes>();

	public static void init() {
		filmes = new ArrayList<Filmes>();
		filmes.add(new Filmes(1, "Além da Escuridão – Star Trek",
				R.drawable.alem_da_escuridao_startrek, 2013, 3.50D));
		filmes.add(new Filmes(2, "Os Croods", R.drawable.croods, 2013, 3.50D));
		filmes.add(new Filmes(3, "Depois da Terra", R.drawable.depois_da_terra,
				2013, 3.50D));
		filmes.add(new Filmes(4, "Guerra Mundial Z",
				R.drawable.guerra_mundial_z, 2013, 3.50D));
		filmes.add(new Filmes(5, "Se Beber, não Case 3",
				R.drawable.se_beber_nao_case_3, 2013, 3.50D));
		filmes.add(new Filmes(6, "Universidade Monstros",
				R.drawable.universidade_monstros, 2013, 3.50D));

		carrinho = new ArrayList<Filmes>();
		carrinho.add(new Filmes(5, "Se Beber, não Case 3",
				R.drawable.se_beber_nao_case_3, 2013, 3.50D));
		carrinho.add(new Filmes(6, "Universidade Monstros",
				R.drawable.universidade_monstros, 2013, 3.50D));

		favoritos = new ArrayList<Filmes>();
		favoritos.add(new Filmes(1, "Além da Escuridão – Star Trek",
				R.drawable.alem_da_escuridao_startrek, 2013, 3.50D));
		favoritos
				.add(new Filmes(2, "Os Croods", R.drawable.croods, 2013, 3.50D));
		favoritos.add(new Filmes(3, "Depois da Terra",
				R.drawable.depois_da_terra, 2013, 3.50D));
	}

	public static List<Filmes> getFilmes() {
		return filmes;
	}

	public static void setFilmes(List<Filmes> filmes) {
		DataBase.filmes = filmes;
	}

	public static List<Filmes> getCarrinho() {
		return carrinho;
	}

	public static void setCarrinho(List<Filmes> carrinho) {
		DataBase.carrinho = carrinho;
	}

	public static List<Filmes> getFavoritos() {
		return favoritos;
	}

	public static void setFavoritos(List<Filmes> favoritos) {
		DataBase.favoritos = favoritos;
	}

}
