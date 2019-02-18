package utils;

import model.Jogador;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public abstract class OtherTools {
    public OtherTools() {
    }

    public static List<String> retornaNomesJogadores(TreeMap<LocalDate, Jogador> jogadorTreeMap) throws UnsupportedEncodingException {
            Jogador jog;
            List<Jogador> jogadores = new ArrayList<>(jogadorTreeMap.values());
            Iterator<Jogador> iterator = jogadores.iterator();
            List<String> nomesJogadores = new ArrayList<>();
            while (iterator.hasNext()) {
                jog = iterator.next();
                String temp = new String(jog.getFull_name().getBytes("UTF-8"));
                nomesJogadores.add(temp);
            }
        return nomesJogadores;
        }

    public static BigDecimal parseToBigDecimal(String eur_release_clause) {
        if(eur_release_clause != null && !eur_release_clause.equals("")){
            return new BigDecimal(eur_release_clause);
        }else {
            return new BigDecimal("0");
        }
    }

    public static LocalDate parseToLocalDate(String s) {
        String[] dateSeparated = s.split("-");
        return LocalDate.of(Integer.parseInt(dateSeparated[0]),
                Integer.parseInt(dateSeparated[1]),
                Integer.parseInt(dateSeparated[2]));
    }

    public static Integer parseToInteger (String str){
        if(str != null){
            return Integer.parseInt(str);
        }else{
            return 0;
        }
    }

}
