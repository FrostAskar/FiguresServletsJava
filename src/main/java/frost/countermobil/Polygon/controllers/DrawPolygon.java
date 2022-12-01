package frost.countermobil.Polygon.controllers;

import frost.countermobil.Polygon.models.User;
import frost.countermobil.Polygon.services.FigureService;
import frost.countermobil.Polygon.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/draw")
public class DrawPolygon extends HttpServlet {

    FigureService figureService = new FigureService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/drawPolygon.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String owner = (String) session.getAttribute("userName");
        int ownerId = (int) (session.getAttribute("userId"));
        String figureName = req.getParameter("figureName");
        int xCoord = Integer.parseInt(req.getParameter("figureX"));
        int yCoord = Integer.parseInt(req.getParameter("figureY"));
        String figureForm = req.getParameter("figureForm");
        int figureSize = Integer.parseInt(req.getParameter("figureSize"));
        String figureColor = req.getParameter("figureColor");

        figureService.newFigure(figureName, owner, ownerId, figureForm, figureColor, xCoord, yCoord, figureSize);




        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/drawPolygon.jsp");
        dispatcher.forward(req, resp);
    }
}
