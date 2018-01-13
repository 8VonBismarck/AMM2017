/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm2017;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author admin
 */
public class FactoryGruppo {
 
    private static FactoryGruppo singleton;
    private ArrayList<Gruppo> listaGruppi = new ArrayList<Gruppo>();
    
    private FactoryGruppo()
    {
    
        FactoryUtente tmp = FactoryUtente.getInstance();
        
        //gruppo 1
        Gruppo gruppo1 = new Gruppo();
        gruppo1.setId(1);
        gruppo1.setNome("Mogolfieristi");
        gruppo1.setIscritti(new ArrayList<Utente>(Arrays.asList(tmp.getUtenteById(1), tmp.getUtenteById(2))));
        
        //gruppo 2
        Gruppo gruppo2 = new Gruppo();
        gruppo2.setId(2);
        gruppo2.setNome("Ritardatari");
        gruppo2.setIscritti(new ArrayList<Utente>(Arrays.asList(tmp.getUtenteById(1), tmp.getUtenteById(2), tmp.getUtenteById(3))));
    }
    
    public static FactoryGruppo getInstance(){
        
        if(singleton==null)
            singleton = new FactoryGruppo();
        
        return singleton;
    }
    
    public Gruppo getGruppoById(int id){
        
        for(Gruppo tmpGruppo : this.listaGruppi){
            if(tmpGruppo.getId()==id)
                return tmpGruppo;
        }
        return null;
    }
    
    public ArrayList<Gruppo> getSubscribedGroups(Utente t)
    {
        ArrayList<Gruppo> subscribedGroups=new ArrayList<>();
        
        for(Gruppo tmp : this.listaGruppi)
        {
            if(tmp.getIscritti().contains(t))
                subscribedGroups.add(tmp);
        }
        
        return subscribedGroups;
    }
    
    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
}
