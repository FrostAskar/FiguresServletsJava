package frost.countermobil.Polygon.DAO.Local;

import frost.countermobil.Polygon.DAO.FigureDAO;
import frost.countermobil.Polygon.models.Figure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FigureDAOLocal implements FigureDAO {

    static List<Figure> figures = new ArrayList<>();
    static int lastId = 1;

    public synchronized void save(Figure f) {
        f.setId(lastId);
        figures.add(f);
        lastId++;
    }

    @Override
    public List<Figure> getAllFigures() {
        return figures;
    }

    public List<Figure> getFiguresByUser(int userId){
        List<Figure> userFigures = new ArrayList<>();
        for (Figure figure : figures) {
            if (figure.getOwnerId() == userId) {
                userFigures.add(figure);
            }
        }
        return userFigures;
    }

    @Override
    public void removeFigure(String figureId, int userId){
        Iterator<Figure> it = figures.iterator();
        while(it.hasNext()) {
            Figure check = it.next();
            if (check.getId() == Integer.parseInt(figureId)){
                if (check.getOwnerId() == (userId)){
                    it.remove();
                } else {
                    System.out.println("User is not object's owner");
                }
            }
        }
    }

    public Figure recoverFigure(String figureId) {
        Figure target = null;
        for (Figure figure : figures){
            if (figure.getId() == Integer.parseInt(figureId)){
                target = figure;
            }
        }
        System.out.println("Figure not found");
        return target;
    }
}
