package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import mosels.Doljnost;
import mosels.Medrabotnik;
import mosels.Otdelenie;

@Stateless
public class MedrabotnikDAO implements DaoRemoute {

    @Resource(name = "jdbc/Lab1JavaEE")
    private DataSource ds;
    Connection connect;
    public Statement myStmt;
    public PreparedStatement myPrStmt;
    public PreparedStatement myPrStmt1;
    public ResultSet myRs;
    public ResultSet myRs1;

    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

    public void initConnection() {
        try {
            InitialContext ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("jdbc/Lab1JavaEE");
        } catch (NamingException ex) {

        }
    }

    @PostConstruct
    public void connect() {
        initConnection();
        try {
            connect = ds.getConnection();
        } catch (SQLException ex) {

        }
    }

    @PreDestroy
    public void disconnect() {
        try {
            connect.close();
        } catch (SQLException ex) {

        }
    }

    @Override
    public Collection<Medrabotnik> GetOll() {
        ArrayList<Medrabotnik> Md = new ArrayList<>();
        try {
            myStmt = connect.createStatement();
            myRs1 = myStmt.executeQuery("SELECT * FROM medrabotnik");
            while (myRs1.next()) {
                Doljnost vrma = GetByIdD(new Doljnost(myRs1.getInt("doljnost")));
                Otdelenie vrma2 = GetByIdO(new Otdelenie(myRs1.getInt("otdelenie")));

                Medrabotnik a = new Medrabotnik(myRs1.getInt("Id"), vrma, vrma2, myRs1.getInt("nadbavka_k_zarplate"), myRs1.getDate("Data_rojdenia"), myRs1.getString("FIO"));
                Md.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return Md;
        }
    }

    @Override
    public void add(Medrabotnik model) {
        try {
            myPrStmt = connect.prepareStatement("INSERT INTO `medrabotnik` (`nadbavka_k_zarplate`, `Data_rojdenia`, `FIO`, `otdelenie`, `doljnost`) VALUES (?,?,?,?,?)");
            myPrStmt.setInt(1, model.getNadbavkaKZarplate());
            myPrStmt.setString(2, format1.format(model.getDatarojdenia()));
            myPrStmt.setString(3, model.getFio());
            myPrStmt.setInt(4, model.getOtdelenie().getId());
            myPrStmt.setInt(5, model.getDoljnost().getId());
            myPrStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }

    @Override
    public void update(Medrabotnik model) {
        try {
            myPrStmt = connect.prepareStatement("UPDATE medrabotnik SET `nadbavka_k_zarplate`=?, `Data_rojdenia`=?, `FIO`=?, `otdelenie`=?, `doljnost`=? WHERE Id = ?");
            myPrStmt.setInt(1, model.getNadbavkaKZarplate());
            myPrStmt.setString(2, format1.format(model.getDatarojdenia()));
            myPrStmt.setString(3, model.getFio());
            myPrStmt.setInt(4, model.getOtdelenie().getId());
            myPrStmt.setInt(5, model.getDoljnost().getId());
            myPrStmt.setInt(6, model.getId());
            myPrStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }

    @Override
    public void del(Medrabotnik model) {
        try {
            myPrStmt = connect.prepareStatement("DELETE FROM medrabotnik WHERE Id = ?");
            myPrStmt.setInt(1, model.getId());
            myPrStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }

    @Override
    public Medrabotnik GetByIdM(Medrabotnik model) {
        Medrabotnik m = new Medrabotnik();
        try {

            myPrStmt = connect.prepareStatement("SELECT * FROM medrabotnik WHERE medrabotnik.Id = ?");
            myPrStmt.setInt(1, model.getId());
            myRs = myPrStmt.executeQuery();
            while (myRs.next()) {
                Doljnost vrma = GetByIdD(new Doljnost(myRs.getInt("doljnost")));
                Otdelenie vrma2 = GetByIdO(new Otdelenie(myRs.getInt("otdelenie")));

                m = new Medrabotnik(myRs.getInt("Id"), vrma, vrma2, myRs.getInt("nadbavka_k_zarplate"), myRs.getDate("Data_rojdenia"), myRs.getString("FIO"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return m;
        }
    }

    @Override
    public Doljnost GetByIdD(Doljnost model) {
        Doljnost a = new Doljnost();
        try {

            myPrStmt = connect.prepareStatement("select * from doljnost where Id = ?;");
            myPrStmt.setInt(1, model.getId());
            myRs = myPrStmt.executeQuery();
            while (myRs.next()) {
                a = new Doljnost(myRs.getInt("Id"), myRs.getString("nazvanie_doljnosti"), myRs.getInt("zarplata"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return a;
        }
    }

    @Override
    public Otdelenie GetByIdO(Otdelenie model) {
        Otdelenie o = new Otdelenie();
        try {

            myPrStmt = connect.prepareStatement("select * from otdelenie where Id = ?;");
            myPrStmt.setInt(1, model.getId());
            myRs = myPrStmt.executeQuery();
            while (myRs.next()) {
                o = new Otdelenie(myRs.getInt("Id"), myRs.getString("nazvanie_otdelenia"), myRs.getInt("kolichstvo_mest"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return o;
        }
    }
}
