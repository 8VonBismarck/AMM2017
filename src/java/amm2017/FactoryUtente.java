/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm2017;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

import java.util.*;


/**
 *
 * @author admin
 */
public class FactoryUtente {
    
    private static FactoryUtente singleton;
    private ArrayList<Utente> listaUtenti = new ArrayList<Utente>();
    private String connectionString; 
    private String connectionUsername;
    private String connectionPassword;
    
    
    private FactoryUtente(){
    /*
        //utente 1
        Utente utente1 = new Utente();
        utente1.setId(1);
        utente1.setNome("Nome1");
        utente1.setCognome("Cognome1");
        utente1.setDataNascita("01-01-01");
        utente1.setMotto("motto1");
        utente1.setUrlImgProfilo("img1");
        utente1.setPassword("password1");
        utente1.setEmail("email1");
        
        //utente 2
        Utente utente2 = new Utente();
        utente2.setId(2);
        utente2.setNome("Nome2");
        utente2.setCognome("Cognome2");
        utente2.setDataNascita("02-02-02");
        utente2.setMotto("motto2");
        utente2.setUrlImgProfilo("img2");
        utente2.setPassword("password2");
        utente2.setEmail("email2");
        
        //utente 3
        Utente utente3 = new Utente();
        utente3.setId(3);
        utente3.setNome("Nome3");
        utente3.setCognome("Cognome3");
        utente3.setDataNascita("03-03-03");
        utente3.setMotto("motto3");
        utente3.setUrlImgProfilo("img3");
        utente3.setPassword("password3");
        utente3.setEmail("email3");
        
        //utente incompleto
        Utente incompleto = new Utente();
        incompleto.setId(4);
        incompleto.setNome("");
        incompleto.setCognome("");
        incompleto.setDataNascita("");
        incompleto.setMotto("");
        incompleto.setUrlImgProfilo("");
        incompleto.setPassword("password0");
        incompleto.setEmail("email0");
        
        
        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
        listaUtenti.add(incompleto);*/
    }
    
    
    
        public static FactoryUtente getInstance()
    {
        if (singleton == null) singleton = new FactoryUtente();      
        return singleton;
    }   
    public void setConnectionString(String s) { this.connectionString = s; }    
    public String getConnectionString() { return this.connectionString; }      
    public static boolean checkCompletion(Utente utente) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        String tmp="";

        Method [] methods=utente.getClass().getDeclaredMethods();
        
        for(Method m : methods)
        {
            if(m.getName().startsWith("get") && m.getReturnType()==String.class)
            {
                if(m.getName().endsWith("Nome") || m.getName().endsWith("Cognome") 
                        || m.getName().endsWith("FrasePresentazione") || m.getName().endsWith("UrlFotoProfilo") )
                {
                    tmp = (String)m.invoke(utente);
                    if(tmp == null || tmp.equals(""))
                        return false;
                }
            }
        }      
        return true;
    } 

    public Utente getUtenteByEmail(String email){
    
        for (Utente tmpUtente : this.listaUtenti){
            if(tmpUtente.getEmail().equals(email))
                return tmpUtente;
        }
        return null;
    }
    
    public ArrayList<Utente> cercaUtente(String nome, String cognome)
    {
        ArrayList<Utente> utentiTrovati= new ArrayList<Utente>();
        
        for (Utente tmpUser : this.listaUtenti) 
        {
            if (tmpUser.getNome().equals(nome) && tmpUser.getCognome().equals(cognome)) 
                utentiTrovati.add(tmpUser);
        }
        
        return utentiTrovati;        
    }
    
     public ArrayList<Utente> getFriends(Utente t)
    {
        ArrayList<Utente> tmp = new ArrayList<Utente>();
        for(Utente u : this.listaUtenti)
        {
            if(!((Utente)u).equals(t))
                tmp.add(new Utente(u));
        }
        
        return tmp;
    } 
    
    public Utente getUtenteById(int id) 
    {
        try
        {
            Connection conn = DriverManager.getConnection(connectionString, "matteo", "matteo");
            
            String query = 
                      "select * from utenti "
                    + "where id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);
            
            ResultSet res = stmt.executeQuery();
            
            if (res.next()) {
                Utente current = new Utente();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setDataNascita(res.getString("dataNascita"));
                current.setMotto(res.getString("motto"));
                current.setPassword(res.getString("password"));
                current.setUrlImgProfilo(res.getString("urlImgProfilo"));
                current.setEmail(res.getString("email"));

                stmt.close();
                conn.close();
                return current;
            }    
                
                 stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
return null;

}
    
    public int getIdByEmailAndPassword(String email, String password){
        try {
            Connection conn = DriverManager.getConnection(connectionString, "matteo", "matteo");
            
            String query = 
                      "select id from utenti "
                    + "where email = ? and password = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                int id = res.getInt("id");

                stmt.close();
                conn.close();
                return id;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
        }
    
    public List getUtentiiList() {
        List<Utente> listaUtenti = new ArrayList<Utente>();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "matteo", "matteo");
            
            String query = 
                      "select * from utenti";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Utente current = new Utente();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setDataNascita(res.getString("dataNascita"));
                current.setMotto(res.getString("motto"));
                current.setPassword(res.getString("password"));
                current.setUrlImgProfilo(res.getString("urlImgProfilo"));
                current.setEmail(res.getString("email"));
                
                listaUtenti.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaUtenti;
    }
    
     public List getUtentiList(String nome) {
        List<Utente> listaUtenti = new ArrayList<Utente>();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "matteo", "matteo");
            
            String query = 
                      "select * from utenti where nome like ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, "%" + nome + "%");
            
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Utente current = new Utente();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setDataNascita(res.getString("dataNascita"));
                current.setMotto(res.getString("motto"));
                current.setPassword(res.getString("password"));
                current.setUrlImgProfilo(res.getString("urlImgProfilo"));
                current.setEmail(res.getString("email"));
                
                listaUtenti.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaUtenti;
    }
     
    public List<Utente> searchUsers(String value)
    {
        List<Utente> listaUtentiTrovati = new ArrayList<>();
        
        String query = "SELECT * FROM utenti WHERE nome || ' ' || cognome LIKE ?";


        try(Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            PreparedStatement stmt = conn.prepareStatement(query)
            )
        {
            stmt.setString(1, "%"+value+"%");
       
            ResultSet set = stmt.executeQuery();
                       
            while(set.next())
            {
                 Utente tmp = new Utente(set.getInt("id"), set.getString("nome"), set.getString("cognome"), set.getString("dataNascita"),
                        set.getString("motto"), set.getString("password"), set.getString("urlFotoProfilo"), set.getString("email") 
                        );
                               
                listaUtentiTrovati.add(tmp.getEssentials());
            }            
        }
        catch (SQLException ex) { Logger.getLogger(FactoryUtente.class.getName()).log(Level.SEVERE, null, ex); }
        
        return listaUtentiTrovati;
    } 
    
}
    





