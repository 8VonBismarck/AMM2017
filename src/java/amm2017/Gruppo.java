/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm2017;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Gruppo {
    
    private int id;
    private String nome;
    private ArrayList<Utente> iscritti;
    
    public Gruppo(){
        this.id=-1;
        this.nome="";
        this.iscritti = new ArrayList<Utente>();
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
    
    public ArrayList<Utente> getIscritti(){
        return iscritti;
    }
    
    public void setIscritti(ArrayList<Utente> iscritti){
        this.iscritti = iscritti;
    }
    
}
