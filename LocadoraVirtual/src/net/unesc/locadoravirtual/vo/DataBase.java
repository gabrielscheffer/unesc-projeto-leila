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
		filmes.add(new Filmes(1, "Al�m da Escurid�o � Star Trek", "Em sua nova miss�o, a tripula��o da nave Enterprise " +
				"� enviada para um planeta primitivo, que est� prestes a ser destru�do devido � erup��o de um vulc�o. " +
				"Spock (Zachary Quinto) � enviado para dentro do vulc�o, onde deve deixar um dispositivo que ir� " +
				"congelar a lava incandescente. Entretanto, problemas inesperados fazem com que ele fique preso " +
				"dentro do vulc�o, sem ter como sair. Para salv�-lo, James T. Kirk (Chris Pine) ordena que " +
				"a Enterprise saia de seu esconderijo no fundo do mar, o que faz com que a nave seja vista pelos " +
				"seres primitivos que habitam o planeta. Esta � uma grave viola��o das regras da Frota Estelar, o" +
				" que faz com que Kirk perca o comando da nave para o capit�o Pike (Bruce Greenwood). A situa��o" +
				" muda por completo quando John Harrison (Benedict Cumberbatch), um renegado da Frota Estelar, " +
				"coordena um ataque a uma biblioteca p�blica, que oculta uma importante base da organiza��o. " +
				"N�o demora muito para que Kirk seja reconduzido ao posto de capit�o da Enterprise e enviado " +
				"para capturar Harrison em um planet�ide dentro do imp�rio klingon, que est� � beira de uma " +
				"guerra com a Federa��o.", R.drawable.alem_da_escuridao_startrek, 2013, 3.80D));
		filmes.add(new Filmes(2, "Os Croods", "Em plena era pr�-hist�rica, escondidos na maior parte do " +
				"tempo dentro de uma caverna, vivem Grug (Nicolas Cage / H�rcules Franco), a esposa Ugga " +
				"(Catherine Keener / B�rbara Monteiro), a vov� (Cloris Leachman / Mari�ngela Cant�), " +
				"o garoto Thunk (Clark Duke / Fred Mascarenhas), a pequena e feroz Sandy (Randy Thom /" +
				" P�mela Rodrigues) e a jovem Eep (Emma Stone / Lu�sa Palomanes). Eles s�o os Croods," +
				" uma fam�lia liderada por um pai que morre de medo do mundo exterior. S� que grandes " +
				"transforma��es est�o para acontecer, pois a adolescente Eep acaba conhecendo o tamb�m" +
				" jovem Guy (Ryan Reynolds / Raphael Rossatto) e ele vai apresentar um incr�vel mundo " +
				"novo, para o desespero do paiz�o protetor. Agora, juntos, eles v�o enfrentar grandes " +
				"desafios e se adaptar a uma nova e divertida era. ", R.drawable.croods, 2013, 3.15D));
		filmes.add(new Filmes(3, "Depois da Terra", "H� 1000 anos, um cataclismo tornou a Terra " +
				"um lugar hostil e for�ou os humanos a se abrigarem no planeta Nova Prime, morando" +
				" em naves espaciais. Depois de uma miss�o, o general Cypher Raige (Will Smith) " +
				"retorna � sua fam�lia e ao filho de treze anos de idade (Jaden Smith). Mas pouco" +
				" tempo ap�s seu retorno, uma chuva de asteroides faz com que a nave onde moram caia" +
				" na Terra. Com o pai correndo risco de morte, o jovem adolescente dever� aprender" +
				" sozinho a domar este planeta, encontrando �gua, comida e cuidando de seu pai. ",
				R.drawable.depois_da_terra, 2013, 3.50D));
		filmes.add(new Filmes(4, "Guerra Mundial Z","Uma terr�vel e misteriosa doen�a se espalha" +
				"pelo mundo, transformando as pessoas em uma esp�cie de zumbis. A velocidade " +
				"do cont�gio � impressionante e logo o Governo americano recruta um ex-investigador" +
				" da ONU (Organiza��o das Na��es Unidas) para investigar o que pode estar acontecendo" +
				" e assim salvar a humanidade, tendo em vista que as previs�es s�o as mais " +
				"catastr�ficas poss�veis. Gerry Lane (Brad Pitt) tinha optado por dedicar mais" +
				" tempo a sua esposa Karen (Mireille Enos) e as filhas, mas seu amor a p�tria e " +
				"o desejo de salvar sua fam�lia acabam contribuindo para que ele tope a miss�o. " +
				"Agora, ele precisa percorrer o caminho inverso da contamina��o para tentar entender" +
				" as causas ou, ao menos, indentificar uma maneira de conter o cont�gio at� que se " +
				"descubra uma cura antes do  apocalipse. Come�a uma verdadeira corrida contra o tempo," +
				" que mostra-se cada vez mais curto, na medida que a popula��o de humanos n�o para " +
				"de diminuir. ",R.drawable.guerra_mundial_z, 2013, 3.50D));
		filmes.add(new Filmes(5, "Se Beber, n�o Case 3", "Alan (Zach Galifianakis) est� deprimido" +
				" devido � morte de seu pai. Preocupado com o cunhado, Doug (Justin Bartha) sugere" +
				" que ele v� at� um lugar chamado New Horizons, que pode torn�-lo um novo homem. " +
				"Alan apenas aceita a sugest�o ap�s Phil (Bradley Cooper) e Stu (Ed Helms) " +
				"concordarem em lev�-lo, juntamente com Doug. � o in�cio de uma nova viagem do " +
				"quarteto, que acaba sendo interrompida bruscamente pelos capangas de Marshall " +
				"(John Goodman). O malfeitor est� atr�s de Chow (Ken Jeong), que lhe aplicou um " +
				"golpe milion�rio, e acredita que os amigos ainda possuam contato com ele. Ap�s " +
				"sequestrar Doug, Marshall d� a Alan, Stu e Phil um prazo para que encontrem Chow " +
				"e devolvam as barras de ouro por ele roubadas, caso contr�rio todos morrer�o. O " +
				"que o trio n�o esperava era que, para reencontrar Chow, teria que ir at� Tijuana," +
				" no M�xico, e tamb�m em Las Vegas. ", R.drawable.se_beber_nao_case_3, 2013, 3.50D));
		filmes.add(new Filmes(6, "Universidade Monstros", "Mike Wazowski (Billy Crystal) e " +
				"James P. Sullivan (John Goodman) s�o uma dupla insepar�vel em Monstros S.A.," +
				" mas nem sempre foi assim. Quando se conheceram na universidade, os dois jovens " +
				"monstros se detestavam, com Mike sendo um sujeito estudioso, mas n�o muito assustador," +
				" e Sulley surgindo como o cara popular e arrogante, gra�as ao talento inerente para o " +
				"susto. Ap�s um incidente durante um teste, os dois s�o obrigados a participarem " +
				"da mesma equipe na olimp�ada dos sustos. A equipe, por sinal, � formada por uma" +
				" s�rie de monstros desajustados, para o desespero de Sulley, acostumado a conviver" +
				" com os caras mais populares da escola. ",
				R.drawable.universidade_monstros, 2013, 3.50D));

		carrinho = new ArrayList<Filmes>();
		carrinho.add(filmes.get(4));
		carrinho.add(filmes.get(5));

		favoritos = new ArrayList<Filmes>();
		favoritos.add(filmes.get(0));
		favoritos.add(filmes.get(1));
		favoritos.add(filmes.get(2));
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
