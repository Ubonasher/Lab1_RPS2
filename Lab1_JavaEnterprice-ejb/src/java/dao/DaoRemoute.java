/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import mosels.Doljnost;
import mosels.Medrabotnik;
import mosels.Otdelenie;

/**
 *
 * @author Григорий
 */
public interface DaoRemoute {

    public Collection<Medrabotnik> GetOll();

    public void add(Medrabotnik model);

    public void update(Medrabotnik model);

    public void del(Medrabotnik model);

    public Medrabotnik GetByIdM(Medrabotnik model);

    public Doljnost GetByIdD(Doljnost model);

    public Otdelenie GetByIdO(Otdelenie model);
}
