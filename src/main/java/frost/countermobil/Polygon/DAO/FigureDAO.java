package frost.countermobil.Polygon.DAO;

import frost.countermobil.Polygon.models.Figure;

import java.util.ArrayList;
import java.util.List;

public interface FigureDAO {

    void save(Figure f);
    List<Figure> getAllFigures();

    List<Figure> getFiguresByUser(int userId);

    void removeFigure(String figureId, int ownerId);

    Figure recoverFigure(String figureId);
}
