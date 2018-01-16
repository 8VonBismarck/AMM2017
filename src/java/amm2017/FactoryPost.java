/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm2017;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class FactoryPost {
    
    private static FactoryPost singleton;
    private ArrayList<Post> listaPost = new ArrayList<Post>();
    
    private FactoryPost(){
     /*
        FactoryUtente utenteFactory = FactoryUtente.getInstance();
        ArrayList<Post> listaPost= new ArrayList<>();
        
        //Creazione Post1
       
        Post post1 = new Post();
        post1.setContenuto("Post uno.");
        post1.setId(0);
        post1.setAutorePost(FactoryUtente.getUtenteById());
        
        post1.setTipoDestinazione(Post.DestinationType.BACHECA);
        post1.setIdDestinazione(0);
        
        
        //Creazione Post2
        Post post2 = new Post();
        post2.setContenuto("Ti mando una foto, ciao");
        post2.setAttachedUrl("immagine.jpg");
        post2.setId(1);
        post2.setAutorePost(utenteFactory.getUtenteById(0));
        post2.setTipoPost(Post.PostType.IMMAGINE);
        
        post2.setTipoDestinazione(Post.DestinationType.BACHECA);
        post2.setIdDestinazione(1);

        
        //Creazione Post3        
        Post post3 = new Post();
        post3.setContenuto("Siete invitati al'evento in molgonfiera di giovedì, ci vediamo lì, ciao");
        post3.setAttachedUrl("http://68.media.tumblr.com/fe7cd8c3cd98e15f1812430959c36b56/tumblr_myftmaNObo1sh9bnuo1_500.jpg");
        post3.setId(2);
        post3.setAutorePost(utenteFactory.getUtenteById(1));
        post3.setTipoPost(Post.PostType.IMMAGINE);
        
        post3.setTipoDestinazione(Post.DestinationType.GRUPPO);
        post3.setIdDestinazione(0);*/
        
    }
    
    
    public static FactoryPost getInstance()
    {
        if (singleton == null)
            singleton = new FactoryPost();
        
        return singleton;
    }
    
    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
       
   public Post getPostById(int id) {        
        FactoryUtente utenteFactory = FactoryUtente.getInstance();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "matteo", "matteo");
            
            String query = 
                      "select * from posts "
                    + "join posttype on posts.type = posttype.posttype_id "
                    + "where post_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                Post current = new Post();
                
                current.setId(res.getInt("id"));
                current.setTipoDestinazione(res.getInt("tipoDestinazione"));
                current.setIdDestinazione(res.getInt("idUtenteDest"));
                current.setIdDestinazione(res.getInt("idGruppoDest"));
                current.setContenuto(res.getString("contenuto"));
                current.setAttachedUrl(res.getString("linkAllegato"));
                
                //imposto l'autore del post
                Utente autore = utenteFactory.getUtenteById(res.getInt("author"));
                current.setAutorePost(autore);

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
    /*    
    public Post getFakePost(Utente autore, String contenuto, Post.PostType tipoPost, String attachedUrl, Post.DestinationType tipoDestinazione)
    {
        Post tmp = new Post();
        
        tmp.setAutorePost(autore);
        tmp.setContenuto(contenuto);
        tmp.setTipoPost(tipoPost);
        tmp.setAttachedUrl(attachedUrl);
        tmp.setTipoDestinazione(tipoDestinazione);       
        
        return tmp;
    }
    */
   
   public List getPostList(Utente utente) {
        List<Post> listaPost = new ArrayList<Post>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "matteo", "matteo");
            
            String query = 
                      "select * from post "
                    + "where autorePost = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, utente.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                Post current = new Post();
                
                current.setId(res.getInt("id"));
                current.setTipoDestinazione(res.getInt("tipoDestinazione"));
                current.setIdDestinazione(res.getInt("idUtenteDest"));
                current.setIdDestinazione(res.getInt("idGruppoDest"));
                current.setContenuto(res.getString("contenuto"));
                current.setAttachedUrl(res.getString("linkAllegato"));
                
                

                //imposto l'autore del post
                current.setAutorePost(utente);
                
                listaPost.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPost;
    }
   
   public void addNewPost(Post post){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "matteo", "matteo");
            
            String query = 
                      "insert into posts (post_id, content, type, author) "
                    + "values (default, ? , ? , ? )";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, post.getContenuto());

            stmt.setInt(2, post.getTipoPost());
            
            stmt.setInt(3, post.getAutorePost().getId());
            
            // Esecuzione query
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
}
   
    
    /*
    ArrayList<Post> getPostList(Gruppo gruppo)
    {
        ArrayList<Post> tmp = new ArrayList<Post>();
        
        for (Post tmpPost : this.listaPost) 
        {
            if (tmpPost.getTipoDestinazione()==Post.DestinationType.GRUPPO && tmpPost.getIdDestinazione()==gruppo.getId())
                tmp.add(tmpPost);
        }

        return tmp;
    } */ 
    
    
}

