/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm2017;

/**
 *
 * @author admin
 */
public class Utente {

    private int id;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String motto;
    private String password;
    private String urlImgProfilo;
    private String email;
    
    public Utente(){
    
        this.id=-1;
        this.nome="";
        this.cognome="";
        this.dataNascita="";
        this.motto="";
        this.password="";
        this.urlImgProfilo="";
        this.email="";
    }
    
    public Utente(Utente u){
    
        this.id=u.getId();
        this.nome= u.getNome();
        this.cognome=u.getCognome();
        this.dataNascita=u.getDataNascita();
        this.motto=u.getMotto();
        this.password=u.getPassword();
        this.urlImgProfilo=u.getUrlImgProfilo();        
        this.email=u.getEmail();        
    }
    
    public Utente(int id, String nome, String cognome, String dataNascita, String motto, String password, String urlImgProfilo, String email)
    {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.motto = motto;
        this.password = password;
        this.urlImgProfilo = urlImgProfilo;
        this.email = email;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    public String getCognome(){
        return cognome;
    }
    
    public void setCognome(String cognome){
        this.cognome=cognome;
    }
    
    public String getDataNascita(){
        return dataNascita;
    }
    
    public void setDataNascita(String dataNascita){
        this.dataNascita=dataNascita;
    }
    
    public String getMotto(){
        return motto;
    }
    
    public void setMotto(String motto){
        this.motto=motto;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    
    public String getUrlImgProfilo(){
        return urlImgProfilo;
    }
    
    public void setUrlImgProfilo(String urlImgProfilo){
        this.urlImgProfilo=urlImgProfilo;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email=email;
    }
}
