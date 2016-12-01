/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;



import DAO.ResourcesDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Adrian
 */

@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
        
        int ID = Integer.parseInt(request.getParameter("resourceId"));
        int ComputerType = Integer.parseInt(request.getParameter("computerType"));   
        String ComputerModel = request.getParameter("computerModel");
        
        float ScreenSize = Float.parseFloat(request.getParameter("computerSize"));   
        String CPU = request.getParameter("computerCPU");
        String RAM = request.getParameter("computerRAM");  
        String Storage = request.getParameter("computerStorage"); 
        
        if(request.getParameter("updateResource")=="update")
        {
             GetByID(ID,ComputerType,ComputerModel,ScreenSize,CPU,RAM,Storage);
        }
        else if (request.getParameter("updateResource")=="DELETE")
        {
            DeleteByID(ID);
        }
        RequestDispatcher rd = request.getRequestDispatcher("update-resource.jsp");  
        rd.forward(request, response);
    }
    
    private void GetByID(int ID,int ComputerType,String ComputerModel,Float ScreenSize,String CPU,String RAM,String Storage)
    {
       // Create the Resource Object
        ResourcesDAO e = new ResourcesDAO();
                       
        // Update the ID
        e.updateComputerType(ID, ComputerType);
        e.updateComputerModel(ID,ComputerModel);
        e.updateComputerScreenSize(ID,ScreenSize);
        e.updateComputerCPU(ID,CPU);
        e.updateComputerRAM(ID,RAM);
        e.updateComputerStorage(ID, Storage);
        
       
    }
    
    private void DeleteByID(int ID)
    {
       // Create the Resource Object
        ResourcesDAO e = new ResourcesDAO();
                       
        // Update the ID
       e.deleteResourceById(ID);
       
    }
    
    
}
