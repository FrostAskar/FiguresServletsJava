package frost.countermobil.Polygon.controllers;

import frost.countermobil.Polygon.models.Figure;
import frost.countermobil.Polygon.services.FigureService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/delete")
public class DeletePolygon extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FigureService figureService = new FigureService();
        HttpSession session = req.getSession();

        String figureId = req.getParameter("figureId");
        int userId = (int) session.getAttribute("userId");

        figureService.removeFigure(figureId, userId);
        resp.sendRedirect("/storage");
    }
}
