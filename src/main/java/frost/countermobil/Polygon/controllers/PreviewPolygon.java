package frost.countermobil.Polygon.controllers;

import frost.countermobil.Polygon.models.Figure;
import frost.countermobil.Polygon.services.FigureService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/preview")
public class PreviewPolygon extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FigureService figureService = new FigureService();
        String figureId = req.getParameter("figureId");
        Figure figure = figureService.previewFigure(figureId);
        int xCoord = figure.getxCoordinate();
        int yCoord = figure.getyCoordinate();
        String figureForm = figure.getForm();
        int figureSize = figure.getSize();
        String figureColor = figure.getColor();

        req.setAttribute("figureX", xCoord);
        req.setAttribute("figureY", yCoord);
        req.setAttribute("figureForm", figureForm);
        req.setAttribute("figureSize", figureSize);
        req.setAttribute("figureColor", figureColor);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/imagePreview.jsp");
        dispatcher.forward(req, resp);
    }
}
