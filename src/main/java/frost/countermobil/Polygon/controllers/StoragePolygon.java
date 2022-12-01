package frost.countermobil.Polygon.controllers;


import frost.countermobil.Polygon.models.Figure;
import frost.countermobil.Polygon.services.FigureService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/storage")
public class StoragePolygon extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        FigureService figureService = new FigureService();

        List<Figure> figures = figureService.getAllFigures();
        req.setAttribute("userId", session.getAttribute("userId"));
        req.setAttribute("figures", figures);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/imageStorage.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FigureService figureService = new FigureService();
        List<Figure> figures = figureService.getAllFigures();
        String searchFigure = req.getParameter("figureSearch");
        figures = figureService.findFiguresByName(figures, searchFigure);
        req.setAttribute("figures", figures);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/imageStorage.jsp");
        dispatcher.forward(req, resp);
    }
}
