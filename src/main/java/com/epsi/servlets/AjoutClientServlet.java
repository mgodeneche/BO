package com.epsi.servlets;

import com.epsi.tpecommerce.entity.Client;
import com.epsi.tpecommerce.service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by maxencegodeneche on 24/06/2014.
 */
@WebServlet("/userAdd")
class AjoutUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String mail = req.getParameter("mail");

        Client client = new Client(prenom,nom,mail);

        ClientService service = new ClientService();
        service.addClient(client);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        //resp.getWriter().write("Hello " + name + "!");
    }
}
