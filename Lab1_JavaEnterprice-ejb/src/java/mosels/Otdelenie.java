/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mosels;

/**
 *
 * @author Григорий
 */
public class Otdelenie extends Model {

    private String nazvanieOtdelenia;
    private int kolichstvoMest;

    public Otdelenie() {
        super();
    }

    public Otdelenie(Integer id) {
        super(id);
    }

    public Otdelenie(Integer id, String nazvanieOtdelenia, int kolichstvoMest) {
        super(id);
        this.nazvanieOtdelenia = nazvanieOtdelenia;
        this.kolichstvoMest = kolichstvoMest;
    }

    public String getNazvanieOtdelenia() {
        return nazvanieOtdelenia;
    }

    public void setNazvanieOtdelenia(String nazvanieOtdelenia) {
        this.nazvanieOtdelenia = nazvanieOtdelenia;
    }

    public int getKolichstvoMest() {
        return kolichstvoMest;
    }

    public void setKolichstvoMest(int kolichstvoMest) {
        this.kolichstvoMest = kolichstvoMest;
    }

    @Override
    public String toString() {
        return "Id:" + this.getId() + " " + this.getNazvanieOtdelenia() + " - Количество мест:" + this.getKolichstvoMest();
    }

}
