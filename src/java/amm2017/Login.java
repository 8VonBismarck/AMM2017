/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm2017;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
@WebServlet(name="Login", urlPatterns = {"/login.html"}, loadOnStartup = 0)
public class Login extends HttpServlet {
    
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
    */
    
    @Override

   public void init(){

       String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
        Class.forName(JDBC_DRIVER);
        } 
        catch (ClassNotFoundException ex) {Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);}

       FactoryUtente.getInstance().setConnectionString(dbConnection);
       FactoryGruppo.getInstance().setConnectionString(dbConnection);
       FactoryPost.getInstance().setConnectionString(dbConnection);

   }
   
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Apertura della sessione
        HttpSession session = request.getSession();

        //Se è impostato il parametro GET logout, distrugge la sessione
        if(request.getParameter("logout")!=null)
        {
            session.invalidate();
            request.getRequestDispatcher("M3/Login.jsp").forward(request, response);
            return;
        }

        //Se esiste un attributo di sessione loggedIn e questo vale true
        //(Utente già loggato)
        if (session.getAttribute("loggedIn") != null &&
            session.getAttribute("loggedIn").equals(true)) {

            //Verificare CHECKCOMPLETION() true o false, da fare
            request.getRequestDispatcher("bacheca.html").forward(request, response);
            return;

        //Se l'utente non è loggato...
}else {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
        if (email != null &&
                password != null)
            {
                int loggedUserID = FactoryUtente.getInstance().getIdByEmailAndPassword(email, password);

                //se l'utente è valido...
                if(loggedUserID!=-1)
                {
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("loggedUserID", loggedUserID);
                    session.setAttribute("loginError", "none");
                    response.sendRedirect("bacheca.html");

                    //request.getRequestDispatcher("bacheca.html").forward(request, response);
                    return;
                } else { //altrimenti se la coppia user/pass non è valida (id==-1)

                    //ritorno al form del login informandolo che i dati non sono validi
                    request.setAttribute("invalidData", true);
                    request.getRequestDispatcher("M3/Login.jsp").forward(request, response);
                    return;
                }


            }
        }

        /*
          Se non si verifica nessuno degli altri casi,
          tentativo di accesso diretto alla servlet Login -> reindirizzo verso
          il form di login.
        */
        request.getRequestDispatcher("M3/Login.jsp").forward(request, response);
}
    
    /*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {     
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        
        if(session.getAttribute("loggedIn")!=null)
        {
            if(session.getAttribute("loggedIn").equals(false))
            {
                if(request.getParameter("email")!=null && request.getParameter("password")!=null)
                {
                    if(request.getParameter("email").toString().length()>0 && request.getParameter("password").toString().length()>0)
                    {
                        Utente tmp=FactoryUtente.getInstance().getUtenteByEmail(request.getParameter("email").toString());

                        if(tmp!=null)
                        {
                            if(tmp.getPassword().equals(request.getParameter("password")))
                            {
                                session.setAttribute("loginError", "none");
                                session.setAttribute("loggedIn", true);
                                try { chooseDestination(new Utente(tmp), request, response); }
                                catch(Exception ex){}
                            }
                            else
                            {
                                session.setAttribute("loginError", "wrongPassword");
                                request.getRequestDispatcher("M3/Login.jsp").forward(request, response);  
                            }
                        }
                        else
                        {
                            session.setAttribute("loginError", "wrongPassword");
                            request.getRequestDispatcher("M3/Login.jsp").forward(request, response);  
                        }                          
                    }
                    else
                    {
                        session.setAttribute("loginError", "emptyField");
                        request.getRequestDispatcher("M3/Login.jsp").forward(request, response);
                    }  
                }
                else
                {
                    session.setAttribute("loginError", "none");
                    request.getRequestDispatcher("M3/Login.jsp").forward(request, response);
                }
            }
            
        }
        else
        {
            session.setAttribute("loginError", "none");
            session.setAttribute("loggedIn", false);
            request.getRequestDispatcher("M3/Login.jsp").forward(request, response);                
        }
    }
    
    public void chooseDestination(Utente tmp, HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, IOException, InvocationTargetException
    {
        request.getSession(false).setAttribute("user", tmp);
        request.getSession(false).setAttribute("friends", FactoryUtente.getInstance().getFriends(tmp));
        
        if(FactoryUtente.checkCompletion(tmp))         
            response.sendRedirect("bacheca.html");
        else
            response.sendRedirect("profilo.html");
    }
    
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        request.getSession(false).invalidate(); 
        response.sendRedirect("login.html");
    }
    * */
    
   /* 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {     
        if(request.getParameter("action") == null || request.getParameter("action").equals("login"))
            this.login(request, response);
        else if(request.getParameter("action").equals("logout"))
            this.logout(request, response); 
    }*/ 
    
    /* ACCESSO CON DATABASE
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        
        if(session.getAttribute("loggedIn")!=null)
        {
            if(session.getAttribute("loggedIn").equals(false))
            {
                if(request.getParameter("email")!=null && request.getParameter("password")!=null)
                {
                    if(request.getParameter("email").length()>0 && request.getParameter("password").length()>0)
                    {
                        Utente tmp = FactoryUtente.getInstance().getUtenteByEmail(request.getParameter("email"));

                        if(tmp!=null && tmp.getPassword().equals(request.getParameter("password")))
                        {
                            request.setAttribute("loginError", "none");
                            session.setAttribute("loggedIn", true);
                            
                            try { chooseDestination(new Utente(tmp), request, response); }
                            catch(Exception ex){}
                        }
                        else
                        {
                            request.setAttribute("loginError", "wrongCredentials");
                            request.getRequestDispatcher("M3/Login.jsp").forward(request, response);  
                        }                          
                    }
                    else
                    {
                        request.setAttribute("loginError", "emptyField");
                        request.getRequestDispatcher("M3/Login.jsp").forward(request, response);
                    }  
                }
                else
                {
                    request.setAttribute("loginError", "none");
                    request.getRequestDispatcher("M3/Login.jsp").forward(request, response);
                }
            }
            else
            {
                try { chooseDestination((Utente)FactoryUtente.getInstance().getUtenteById((int)session.getAttribute("user")), request, response); }
                catch(Exception ex){}
            }
        }
        else
        {
            request.setAttribute("loginError", "none");
            session.setAttribute("loggedIn", false);
            request.getRequestDispatcher("M3/Login.jsp").forward(request, response);                
        }        
    }   
    public void chooseDestination(Utente tmp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IllegalAccessException, IOException, InvocationTargetException
    {
        request.getSession(false).setAttribute("user", tmp.getId());

        if(FactoryUtente.checkCompletion(tmp))   
            response.sendRedirect("bacheca.html?ownerType=user");
        else
            response.sendRedirect("profilo.html?isUserInfoComplete=false");
    }  ACCESSO CON DATABASE*/  
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        request.getSession(false).invalidate(); 
        response.sendRedirect("login.html");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    

}
