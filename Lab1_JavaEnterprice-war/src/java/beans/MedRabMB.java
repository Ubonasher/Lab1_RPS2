package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.DaoRemoute;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.interceptor.Interceptors;
import mosels.Medrabotnik;

@ManagedBean(name = "MedRabMB", eager = true)
@RequestScoped
public class MedRabMB {

    private ArrayList<Medrabotnik> Md = new ArrayList<>();

    @EJB
    DaoRemoute sq1;

    
    public ArrayList<Medrabotnik> getMd() {
        Md = (ArrayList<Medrabotnik>) sq1.GetOll();
        return Md;
    }

    public void setMd(ArrayList<Medrabotnik> Md) {
        this.Md = Md;
    }

}
