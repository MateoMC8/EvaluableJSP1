/*Integrantes Mateo Marin Cuadros, Yerlin Arroyave
 */

import static java.awt.SystemColor.text;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class index extends HttpServlet {
      private static final long serialVersionUID = 1L;

 
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
         HttpSession sesion = req.getSession();
        res.setContentType("text/html");
        PrintWriter salida = res.getWriter();
        salida.println("<HEAD><TITLE> Seguir sesion");
        salida.println("</TITLE></HEAD><BODY>");
        salida.println("<h1> Inicio de sesion</h1>");
        //Un contador de accesos simple para esta petición
        Integer ivalue = (Integer) sesion.getAttribute("GorkaElorduy");
        if (ivalue == null) {
            ivalue = new Integer(1);
        } else {
            ivalue = new Integer(ivalue.intValue() + 1);
        }
        sesion.setAttribute("GorkaElorduy", ivalue);
        salida.println("Has accedido a esta página " + ivalue + " veces");
        salida.println("<h2>");
        salida.println("Se han guardado los datos de la sesion</h2>");
        //mostramos todos los datos de la sesión
        Enumeration nombresSesion = sesion.getAttributeNames();
        while (nombresSesion.hasMoreElements()) {
            String nombre = nombresSesion.nextElement().toString();
            Object valor = sesion.getAttribute(nombre);
            salida.println(nombre + " =  "+ valor + "<br>");
        }
        salida.println("</BODY>");
      
    }

 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        processRequest(req, res);
          
          
        
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        processRequest(req, res);
         
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
