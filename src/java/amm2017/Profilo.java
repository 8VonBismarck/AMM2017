/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm2017;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
public class Profilo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        response.setContentType("text/html;charset=UTF-8");
        
        if(session!=null)
        {    
            request.setAttribute("isUserInfoComplete", false);      
            request.getRequestDispatcher("M3/Profilo.jsp").forward(request, response);
        }
        
        else response.sendRedirect("login.html");
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

/*

Utente vecchio = (Utente)session.getAttribute("user");
            Utente nuovo = new Utente(vecchio.getId(), request.getParameter("nome"), request.getParameter("cognome"), 
                                request.getParameter("data_n"), request.getParameter("motto"), 
                                request.getParameter("password"), request.getParameter("UrlImgProfilo"),
                                vecchio.getEmail());
            
            try
                {
                    ArrayList<String> campiModificati = updateUserInfo(request, vecchio, nuovo);
                    
                    if(campiModificati.isEmpty())
                        request.setAttribute("campiModificati", "none");
                    else
                        request.setAttribute("campiModificati", campiModificati);
                    loadData(request);
                }
                catch(Exception ex){}         
        
            try
            {
                if(FactoryUtente.checkCompletion((Utente)session.getAttribute("user")))
                    request.setAttribute("isUserInfoComplete", true);
                else 
                    request.setAttribute("isUserInfoComplete", false);
            }catch(Exception ex){}
            
            request.getRequestDispatcher("M3/Profilo.jsp").forward(request, response);
        }
        
        else response.sendRedirect("login.html");
    }

     public void loadData(HttpServletRequest request) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        Utente utente = (Utente) request.getSession(false).getAttribute("user");
        Field [] classFields = utente.getClass().getDeclaredFields();
        Method tmpGetter;
        
        for(Field tmp : classFields)
        {
            if(tmp.getType() == String.class)
            {    
                tmpGetter = Utente.class.getMethod("get"+tmp.getName().substring(0, 1).toUpperCase() + tmp.getName().substring(1));
                request.setAttribute(tmp.getName(), tmpGetter.invoke(utente).toString());
            }        
        }   
    }
    
    public ArrayList<String> updateUserInfo(HttpServletRequest request, Utente vecchio, Utente nuovo) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        ArrayList<String> campiModificati = new ArrayList<>();
        Field [] classFields = vecchio.getClass().getDeclaredFields();
        Method [] classMethods = nuovo.getClass().getDeclaredMethods();
        Method tmpGetter, tmpSetter;
        
        for(Field tmp : classFields)
        {
            if(tmp.getType() == String.class)
            {    
                tmpGetter = Utente.class.getMethod("get"+tmp.getName().substring(0, 1).toUpperCase() + tmp.getName().substring(1));
                tmpSetter = Utente.class.getMethod("set"+tmp.getName().substring(0, 1).toUpperCase() + tmp.getName().substring(1), String.class);
                
                if(tmpGetter.invoke(nuovo).toString()!= null
                   && !tmpGetter.invoke(nuovo).toString().equals("")
                   && !tmpGetter.invoke(nuovo).toString().equals(tmpGetter.invoke(vecchio).toString()))
                {
                    campiModificati.add(tmp.getName());
                    tmpSetter.invoke(vecchio, tmpGetter.invoke(nuovo));
                }
            }
        }
        
        request.getSession(false).setAttribute("user", vecchio);
        return campiModificati;                
    }


*/