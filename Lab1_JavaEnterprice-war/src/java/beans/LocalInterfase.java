/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Local;

/**
 *
 * @author Григорий
 */
@Local
public interface LocalInterfase {

    public void login();

    public String getFio();

    public void setFio(String fio);

    public void relog();

    public void setStatus(String status);

    public String getStatus();

    public int getCount();

    public void setCount(int count);

}
