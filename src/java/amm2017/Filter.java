package amm2017;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class Filter extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html;charset=UTF-8");
            
        if (request.getSession(false).getAttribute("loggedIn") != null
            && request.getSession(false).getAttribute("loggedIn").equals(true)
            && request.getParameter("action") != null && request.getParameter("action").equals("search")) 
            
             {
            List<?> listaUtentiTrovati = FactoryUtente.getInstance().searchUsers(request.getParameter("q"));
            
            if(!listaUtentiTrovati.isEmpty())
            {
                request.setAttribute("listaUtentiTrovati", listaUtentiTrovati);

                response.setContentType("application/json");
                response.setHeader("Expires", "Sun, 1 January 1995 12:00:00 GMT");
                response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

                request.getRequestDispatcher("M3/UtentiTrovati.jsp").forward(request, response);      
            }
            else response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }       
        
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
