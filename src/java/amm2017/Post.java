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
public class Post {
    
    public enum PostType
    {
        TESTO, IMMAGINE, LINK
    };
    
    public enum DestinationType
    {
        INVALID, BACHECA, GRUPPO;
    };
         
    
    private int id;
    private Utente autorePost;
    private String contenuto;
    private PostType tipoPost;
    private String attachedUrl;   
    private DestinationType tipoDestinazione;
    private int idDestinazione;
    
    public Post()
    {
        this.id=-1;
        this.autorePost=null;
        this.contenuto="";
        this.attachedUrl="";     
        this.tipoDestinazione=DestinationType.INVALID;
        this.idDestinazione=-1;
    }
          
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    } 
    
    public Utente getAutorePost(){
        return autorePost;
    }
    
    public void setAutorePost(Utente autore){
        this.autorePost=autore;
    }
    
    public String getContenuto(){
        return contenuto;
    }
    
    public void setContenuto(String testo){
        this.contenuto=testo;
    }
    
    public PostType getTipoPost() {
        return tipoPost;
    }

    
    public void setTipoPost(PostType tipoPost) {
        this.tipoPost = tipoPost;
    }

    public String getAttachedUrl() {
        return attachedUrl;
    }

    public void setAttachedUrl(String attachedUrl) {
        this.attachedUrl = attachedUrl;
    }

    public DestinationType getTipoDestinazione() {
        return tipoDestinazione;
    }

    public void setTipoDestinazione(DestinationType tipoDestinazione) {
        this.tipoDestinazione = tipoDestinazione;
    }

    public int getIdDestinazione() {
        return idDestinazione;
    }

    public void setIdDestinazione(int idDestinazione) {
        this.idDestinazione = idDestinazione;
    }
    
}

