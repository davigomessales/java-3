package model;

import com.opencsv.bean.CsvBindByPosition;

public class Jogador {

    @CsvBindByPosition(position = 0)
    private int id;
    @CsvBindByPosition(position = 2)
    private String full_name;
    @CsvBindByPosition(position = 3)
    private String club;
    @CsvBindByPosition(position = 18)
    private String eur_release_clause;
    @CsvBindByPosition(position = 17)
    private String euro_wage;
    @CsvBindByPosition(position = 6)
    private String age;
    @CsvBindByPosition(position = 14)
    private String nationality;
    @CsvBindByPosition(position = 8)
    private String birth_date;




    public Jogador() {
    }

    public String getBirth_date(){
        return birth_date;
    }

    public int getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getClub() {
        return club;
    }

    public String getEur_release_clause() {
        return eur_release_clause;
    }

    public String getEuro_wage() {
        return euro_wage;
    }

    public String getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }
}
