package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.TempInterfase;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;

@Stateful
@ConversationScoped
@Named(value = "StatefullName")
public class StatefullName implements Serializable,LocalInterfase {

    @Inject
    private Conversation conv1;
    
     @Inject
     Event<GuessEvent> guessEvent;

    private String fio;
    private String status = "";
    private int count;

    @EJB
    TempInterfase sq1;
    

    @Override
    public String getFio() {
        return fio;
    }

    
    @Override
    public void setFio(String fio) {
        if (getFio() == null) {
            this.fio = fio;
        }
    }
    
            
    @Override
    @Interceptors(Singleton1.class)
    public void login() {
        if (conv1.isTransient()) {
            conv1.begin();
            guessEvent.fire(new GuessEvent());
            String s = "";
            if (sq1.GetByFio(fio) == true) {
                s = "Человек с таким именем есть в базе";
            } else {
                s = "Человекa с таким именем нет в базе";
            }
            setStatus(s);
        }

    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void relog() {
        if (!conv1.isTransient()) {
            conv1.end();
            this.fio = null;
            setStatus("");
        }
    }


    @Override
    public int getCount() {
        return 10;
    }

   
    @Override
    public void setCount(int count) {
        this.count = count;
    }

}
