package challenge;

import model.Jogador;
import utils.CsvTool;
import utils.OtherTools;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Main {

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
		Jogador jog;
		List<Jogador> listaJogadores = CsvTool.getListaJogadores();
		List<String>  listaNacionalidade = new ArrayList<>();
		for (Jogador j : listaJogadores) {
			jog = j;
			if (listaNacionalidade.isEmpty() || !listaNacionalidade.contains(jog.getNationality())) {
				listaNacionalidade.add(jog.getNationality());
			}
		}
		return listaNacionalidade.size();
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		Jogador jog;
		List<Jogador> listaJogadores = CsvTool.getListaJogadores();
		List<String>  listaClubes = new ArrayList<>();
		for (Jogador j : listaJogadores) {
			jog = j;
			if((listaClubes.isEmpty() || !listaClubes.contains(jog.getClub())) && !jog.getClub().equals("")){
				listaClubes.add(jog.getClub());
			}
		}
		return listaClubes.size();
	}

	// Liste o nome completo (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() throws UnsupportedEncodingException {
		Jogador jog;
		List<Jogador> listaJogadores = CsvTool.getListaJogadores();
		Iterator<Jogador> iterator = listaJogadores.iterator();
		int indice = 0;
		List<String> nomes = new ArrayList<>();
		while (iterator.hasNext() && indice < 20){
			jog = iterator.next();
			String temp = new String(jog.getFull_name().getBytes("UTF-8"));
			nomes.add(temp);
			indice++;
		}
		return nomes;

	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() throws UnsupportedEncodingException {
		List<Jogador> jogadores = CsvTool.getListaJogadores();
		Iterator<Jogador> iterator = jogadores.iterator();
		Jogador jog;
		BigDecimal eurClauseAtual;
		TreeMap<BigDecimal, String> mapJogadores = new TreeMap<>();
		while (iterator.hasNext()){
			jog = iterator.next();
			eurClauseAtual = OtherTools.parseToBigDecimal(jog.getEur_release_clause());
			String temp = new String(jog.getFull_name().getBytes("UTF-8"));
			mapJogadores.put(eurClauseAtual, temp);
		}
		return new ArrayList<>(mapJogadores.descendingMap().values()).subList(0, 10);
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() throws UnsupportedEncodingException {
		List<Jogador> jogadores = CsvTool.getListaJogadores();
		Iterator<Jogador> iterator = jogadores.iterator();
		Jogador jog;
		TreeMap<LocalDate, Jogador> jogadorTreeMap = new TreeMap<>();
		while (iterator.hasNext()){
			jog = iterator.next();
			if(jogadorTreeMap.isEmpty() || !jogadorTreeMap.containsKey(OtherTools.parseToLocalDate(jog.getBirth_date()))){
				jogadorTreeMap.put(OtherTools.parseToLocalDate(jog.getBirth_date()), jog);
			}else{
				if(OtherTools.parseToBigDecimal(jog.getEuro_wage())
						.compareTo(OtherTools.parseToBigDecimal(jogadorTreeMap.get(OtherTools.parseToLocalDate(jog.getBirth_date()))
								.getEuro_wage())) > 0){
					jogadorTreeMap.put(OtherTools.parseToLocalDate(jog.getBirth_date()), jog);
				}
			}
		}
		return OtherTools.retornaNomesJogadores(jogadorTreeMap).subList(0, 10);
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
		List<Jogador> jogadores = CsvTool.getListaJogadores();
		Jogador jog;
		Iterator<Jogador> iterator = jogadores.iterator();
		Integer quantidade = 0;
		Map<Integer, Integer> contagem = new TreeMap<>();
		while (iterator.hasNext()){
			jog = iterator.next();
			if(contagem.isEmpty() || !contagem.containsKey(OtherTools.parseToInteger(jog.getAge()))){
				contagem.put(OtherTools.parseToInteger(jog.getAge()), 1);
			}else{
				quantidade = contagem.get(OtherTools.parseToInteger(jog.getAge())) + 1;
				contagem.put(OtherTools.parseToInteger(jog.getAge()), quantidade);
			}
		}
		return contagem;
	}

	public static void main(String[] args){


	}
}
