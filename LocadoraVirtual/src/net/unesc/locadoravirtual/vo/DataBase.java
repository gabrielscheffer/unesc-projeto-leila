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
		filmes.add(new Filmes(1, "Além da Escuridão – Star Trek", "Em sua nova missão, a tripulação da nave Enterprise " +
				"é enviada para um planeta primitivo, que está prestes a ser destruído devido à erupção de um vulcão. " +
				"Spock (Zachary Quinto) é enviado para dentro do vulcão, onde deve deixar um dispositivo que irá " +
				"congelar a lava incandescente. Entretanto, problemas inesperados fazem com que ele fique preso " +
				"dentro do vulcão, sem ter como sair. Para salvá-lo, James T. Kirk (Chris Pine) ordena que " +
				"a Enterprise saia de seu esconderijo no fundo do mar, o que faz com que a nave seja vista pelos " +
				"seres primitivos que habitam o planeta. Esta é uma grave violação das regras da Frota Estelar, o" +
				" que faz com que Kirk perca o comando da nave para o capitão Pike (Bruce Greenwood). A situação" +
				" muda por completo quando John Harrison (Benedict Cumberbatch), um renegado da Frota Estelar, " +
				"coordena um ataque a uma biblioteca pública, que oculta uma importante base da organização. " +
				"Não demora muito para que Kirk seja reconduzido ao posto de capitão da Enterprise e enviado " +
				"para capturar Harrison em um planetóide dentro do império klingon, que está à beira de uma " +
				"guerra com a Federação.", R.drawable.alem_da_escuridao_startrek, 2013, 3.80D));
		filmes.add(new Filmes(2, "Os Croods", "Em plena era pré-histórica, escondidos na maior parte do " +
				"tempo dentro de uma caverna, vivem Grug (Nicolas Cage / Hércules Franco), a esposa Ugga " +
				"(Catherine Keener / Bárbara Monteiro), a vovó (Cloris Leachman / Mariângela Cantú), " +
				"o garoto Thunk (Clark Duke / Fred Mascarenhas), a pequena e feroz Sandy (Randy Thom /" +
				" Pâmela Rodrigues) e a jovem Eep (Emma Stone / Luísa Palomanes). Eles são os Croods," +
				" uma família liderada por um pai que morre de medo do mundo exterior. Só que grandes " +
				"transformações estão para acontecer, pois a adolescente Eep acaba conhecendo o também" +
				" jovem Guy (Ryan Reynolds / Raphael Rossatto) e ele vai apresentar um incrível mundo " +
				"novo, para o desespero do paizão protetor. Agora, juntos, eles vão enfrentar grandes " +
				"desafios e se adaptar a uma nova e divertida era. ", R.drawable.croods, 2013, 3.15D));
		filmes.add(new Filmes(3, "Depois da Terra", "Há 1000 anos, um cataclismo tornou a Terra " +
				"um lugar hostil e forçou os humanos a se abrigarem no planeta Nova Prime, morando" +
				" em naves espaciais. Depois de uma missão, o general Cypher Raige (Will Smith) " +
				"retorna à sua família e ao filho de treze anos de idade (Jaden Smith). Mas pouco" +
				" tempo após seu retorno, uma chuva de asteroides faz com que a nave onde moram caia" +
				" na Terra. Com o pai correndo risco de morte, o jovem adolescente deverá aprender" +
				" sozinho a domar este planeta, encontrando água, comida e cuidando de seu pai. ",
				R.drawable.depois_da_terra, 2013, 3.50D));
		filmes.add(new Filmes(4, "Guerra Mundial Z","Uma terrível e misteriosa doença se espalha" +
				"pelo mundo, transformando as pessoas em uma espécie de zumbis. A velocidade " +
				"do contágio é impressionante e logo o Governo americano recruta um ex-investigador" +
				" da ONU (Organização das Nações Unidas) para investigar o que pode estar acontecendo" +
				" e assim salvar a humanidade, tendo em vista que as previsões são as mais " +
				"catastróficas possíveis. Gerry Lane (Brad Pitt) tinha optado por dedicar mais" +
				" tempo a sua esposa Karen (Mireille Enos) e as filhas, mas seu amor a pátria e " +
				"o desejo de salvar sua família acabam contribuindo para que ele tope a missão. " +
				"Agora, ele precisa percorrer o caminho inverso da contaminação para tentar entender" +
				" as causas ou, ao menos, indentificar uma maneira de conter o contágio até que se " +
				"descubra uma cura antes do  apocalipse. Começa uma verdadeira corrida contra o tempo," +
				" que mostra-se cada vez mais curto, na medida que a população de humanos não para " +
				"de diminuir. ",R.drawable.guerra_mundial_z, 2013, 3.50D));
		filmes.add(new Filmes(5, "Se Beber, não Case 3", "Alan (Zach Galifianakis) está deprimido" +
				" devido à morte de seu pai. Preocupado com o cunhado, Doug (Justin Bartha) sugere" +
				" que ele vá até um lugar chamado New Horizons, que pode torná-lo um novo homem. " +
				"Alan apenas aceita a sugestão após Phil (Bradley Cooper) e Stu (Ed Helms) " +
				"concordarem em levá-lo, juntamente com Doug. É o início de uma nova viagem do " +
				"quarteto, que acaba sendo interrompida bruscamente pelos capangas de Marshall " +
				"(John Goodman). O malfeitor está atrás de Chow (Ken Jeong), que lhe aplicou um " +
				"golpe milionário, e acredita que os amigos ainda possuam contato com ele. Após " +
				"sequestrar Doug, Marshall dá a Alan, Stu e Phil um prazo para que encontrem Chow " +
				"e devolvam as barras de ouro por ele roubadas, caso contrário todos morrerão. O " +
				"que o trio não esperava era que, para reencontrar Chow, teria que ir até Tijuana," +
				" no México, e também em Las Vegas. ", R.drawable.se_beber_nao_case_3, 2013, 3.50D));
		filmes.add(new Filmes(6, "Universidade Monstros", "Mike Wazowski (Billy Crystal) e " +
				"James P. Sullivan (John Goodman) são uma dupla inseparável em Monstros S.A.," +
				" mas nem sempre foi assim. Quando se conheceram na universidade, os dois jovens " +
				"monstros se detestavam, com Mike sendo um sujeito estudioso, mas não muito assustador," +
				" e Sulley surgindo como o cara popular e arrogante, graças ao talento inerente para o " +
				"susto. Após um incidente durante um teste, os dois são obrigados a participarem " +
				"da mesma equipe na olimpíada dos sustos. A equipe, por sinal, é formada por uma" +
				" série de monstros desajustados, para o desespero de Sulley, acostumado a conviver" +
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
