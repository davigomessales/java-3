package utils;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import model.Jogador;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvTool {

    private static final String PATH = "C:\\Users\\Davi\\codenation\\java-3\\src\\main\\resources\\data.csv";
    private static List<Jogador> getAllJogadores(){
        List<Jogador> listaTodos =  new ArrayList<>();
        try(Reader reader = Files.newBufferedReader(Paths.get(PATH))){
            ColumnPositionMappingStrategy<Jogador> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Jogador.class);
            String[] fieldsToBind = {"Id",
                    "", "full_name", "club",
                    "", "", "age", "",
                    "birth_date", "", "",
                    "", "", "", "nationality",
                    "", "", "eur_wage",
                    "eur_release_clause", ""};
            strategy.setColumnMapping(fieldsToBind);
            CsvToBean jogadores = new CsvToBeanBuilder(reader).withMappingStrategy(strategy).withSkipLines(1).withIgnoreLeadingWhiteSpace(true).build();
            for (Object jog : jogadores) {listaTodos.add((Jogador) jog);}
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaTodos;
    }
    private static List<Jogador> listaDeJogadores;

    public static List<Jogador> getListaJogadores(){
        if(listaDeJogadores == null){
            listaDeJogadores = getAllJogadores();
        }
        return listaDeJogadores;
    }
}
