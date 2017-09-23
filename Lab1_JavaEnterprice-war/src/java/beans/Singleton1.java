/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Григорий
 */
@ApplicationScoped
@Named("Singleton1")
@Singleton
@LocalBean
public class Singleton1 implements Serializable {

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Singleton1() {
        count = 0;
    }

    @Lock(LockType.WRITE)
    public void addSuccess(@Observes GuessEvent event) {
        count++;
    }
}
