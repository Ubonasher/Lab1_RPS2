/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mosels;

public class Doljnost extends Model {

    private String nazvanieDoljnosti;
    private int zarplata;

    public Doljnost() {
        super();
    }

    public Doljnost(int nextInt) {
        super(nextInt);
    }

    public Doljnost(Integer id, String nazvanieDoljnosti, int zarplata) {
        super(id);
        this.nazvanieDoljnosti = nazvanieDoljnosti;
        this.zarplata = zarplata;
    }

   
    public String getNazvanieDoljnosti() {
        return nazvanieDoljnosti;
    }

    public void setNazvanieDoljnosti(String nazvanieDoljnosti) {
        this.nazvanieDoljnosti = nazvanieDoljnosti;
    }

    public int getZarplata() {
        return zarplata;
    }

    public void setZarplata(int zarplata) {
        this.zarplata = zarplata;
    }

    @Override
    public String toString() {
        return "Id:" + this.getId() + " " + this.getNazvanieDoljnosti() + " - Зарплата:" + this.getZarplata();
    }

}
