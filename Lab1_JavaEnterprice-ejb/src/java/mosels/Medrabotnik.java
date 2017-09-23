/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mosels;

import java.util.Date;

/**
 *
 * @author Григорий
 */
public class Medrabotnik extends Model {

    private int nadbavkaKZarplate;
    private Date datarojdenia;
    private String fio;
    private Doljnost doljnost;
    private Otdelenie otdelenie;

    public Medrabotnik() {
        super();
    }

    public Medrabotnik(Integer id) {
        super(id);
    }

    public Medrabotnik(Integer id, Doljnost doljnost, Otdelenie otdelenie, int nadbavkaKZarplate, Date datarojdenia, String fio) {
        super(id);
        this.nadbavkaKZarplate = nadbavkaKZarplate;
        this.datarojdenia = datarojdenia;
        this.fio = fio;
        this.doljnost = doljnost;
        this.otdelenie = otdelenie;

    }

    public int getNadbavkaKZarplate() {
        return nadbavkaKZarplate;
    }

    public void setNadbavkaKZarplate(int nadbavkaKZarplate) {
        this.nadbavkaKZarplate = nadbavkaKZarplate;
    }

    public Date getDatarojdenia() {
        return datarojdenia;
    }

    public void setDatarojdenia(Date datarojdenia) {
        this.datarojdenia = datarojdenia;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Doljnost getDoljnost() {
        return doljnost;
    }

    public void setDoljnost(Doljnost doljnost) {
        this.doljnost = doljnost;
    }

    public Otdelenie getOtdelenie() {
        return otdelenie;
    }

    public void setOtdelenie(Otdelenie otdelenie) {
        this.otdelenie = otdelenie;
    }

    @Override
    public String toString() {
        return "Id:" + this.getId() + "   ФИО:" + this.getFio() + "   Дата рождения:" + this.getDatarojdenia() + "   Надбавка к зарплате:" + this.getNadbavkaKZarplate() + "   Должность:" + doljnost.getNazvanieDoljnosti() + "   Отделение:" + otdelenie.getNazvanieOtdelenia();
    }

}
