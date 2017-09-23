package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@Stateless
public class StateFullDao implements Serializable, TempInterfase {

    @Resource(name = "jdbc/Lab1JavaEE")
    private DataSource ds;
    Connection connect;


    public void initConnection() {
        try {
            InitialContext ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("jdbc/Lab1JavaEE");
        } catch (NamingException ex) {

        }
    }

    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

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
    public boolean GetByFio(String FIO) {
        boolean index = false;

        try {
            PreparedStatement myPrStmt = connect.prepareStatement("SELECT * FROM medrabotnik WHERE medrabotnik.FIO = ?");
            myPrStmt.setString(1, FIO);
            ResultSet myRs = myPrStmt.executeQuery();
            while (myRs.next()) {

                if (FIO.equals(myRs.getString("FIO"))) {
                    index = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return index;
    }

}
