/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm2017;

import java.sql.Statement;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class FactoryUtente {
    
    private static FactoryUtente singleton;
    private ArrayList<Utente> listaUtenti = new ArrayList<Utente>();
    
    private FactoryUtente(){
    
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
        listaUtenti.add(incompleto);
    }
    
    public static FactoryUtente getInstance(){
        
        if(singleton==null)
            singleton=new FactoryUtente();
        return singleton;
    }
    /*
    public Utente getUtenteById(int id){
        
        for(Utente tmpUtente : this.listaUtenti){
            if(tmpUtente.getId()==id)
                return tmpUtente;
        }
        return null;
    }*/
    
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
    
     public static boolean checkCompletion(Utente u) throws IllegalAccessException,
                     IllegalArgumentException,
                     InvocationTargetException
    {
        String tmp="";
        String dummy="";
        Method [] methods=u.getClass().getDeclaredMethods();
        
        for(Method m : methods)
        {
            if(m.getName().startsWith("get") && m.getReturnType()==String.class)
            {
                if(m.getName().endsWith("Nome") || m.getName().endsWith("Cognome") 
                        || m.getName().endsWith("Motto") || m.getName().endsWith("UrlImgProfilo") )
                {
                    tmp=(String)m.invoke(u);
                    if(tmp.equals(dummy))
                        return false;
                }
            }
        }
        
        return true;
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
     
    private String connectionString; 
     
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    } 
    
    public Utente getUtenteById(int id) 
    {
        Utente tmp = null;
        String query = "select * from utenti where id="+id;
        ResultSet set = null;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), "ali_baba", "apriti sesamo");
            Statement stmt = conn.createStatement();
            
            set = stmt.executeQuery(query);
             
            if(set.next())
            {
                tmp = new Utente(set.getInt("id"), set.getString("nome"), set.getString("cognome"), set.getString("dataNascita"), 
                        set.getString("motto"), set.getString("password"), set.getString("urlImgProfilo"),
                        set.getString("email"));
            }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(FactoryUtente.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return tmp;
    }


}


