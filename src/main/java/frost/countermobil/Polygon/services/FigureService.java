package frost.countermobil.Polygon.services;

import frost.countermobil.Polygon.DAO.FigureDAO;
import frost.countermobil.Polygon.DAO.Local.FigureDAOLocal;
import frost.countermobil.Polygon.models.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class FigureService {

    FigureDAO figureDAO = new FigureDAOLocal();

    public void newFigure(String name,
                            String owner,
                            int ownerId,
                            String form,
                            String color,
                            int xCoord,
                            int yCoord,
                            int size
    ){
        Figure figure = null;
        switch (form){
            case "Circle":
                figure = new Circle();
                figure.setForm("Circle");
                break;
            case "Square":
                figure = new Square();
                figure.setForm("Square");
                break;
            case "Triangle":
                figure = new Triangle();
                figure.setForm("Triangle");
                break;
            case "Pentagon":
                figure = new Pentagon();
                figure.setForm("Pentagon");
                break;
            case "7-pointed-star":
                figure = new Star7Points();
                figure.setForm("7-pointed-star");
                break;
        }
        figure.setName(name);
        figure.setColor(color);
        figure.setxCoordinate(xCoord);
        figure.setyCoordinate(yCoord);
        figure.setSize(size);
        figure.setOwnerId(ownerId);
        figure.setOwner(owner);
        if (figure.getName().equals("")){
            figure.setName(createName(figure));
        }
        figureDAO.save(figure);
    }

    public List<Figure> getAllFigures(){
        return figureDAO.getAllFigures();
    }

    public void removeFigure(String figureId, int userId){
        figureDAO.removeFigure(figureId, userId);
    }

    public Figure previewFigure(String figureId){
        return figureDAO.recoverFigure(figureId);
    }

    public List<Figure> getFiguresByUser (int userId){
        return figureDAO.getFiguresByUser(userId);
    }

    public List<Figure> findFiguresByName(List<Figure> figures, String figureName){
        List<Figure> foundFigures = new ArrayList<>();
        for (Figure figure : figures) {
            if (figure.getName().contains(figureName)){
                foundFigures.add(figure);
            }
        }
        System.out.println(foundFigures);
        return foundFigures;
    }

    private String createName(Figure figure){
        String result = "";
        UUID uuid = UUID.randomUUID();
        result += figure.getForm() + "_" + figure.getOwnerId() + "_" + uuid;
        return result;
    }

}
