package ru.javabegin.training.goldman.objects.common;


import ru.javabegin.goldman.game.enums.GameObjectType;
import javax.swing.ImageIcon;
import ru.javabegin.training.goldman.objects.game.interfaces.StaticObject;

/**
 * класс, который отвечает за любой объект, созданный в игре. задает все общие
 * характеристики объектов в игре
 */
public abstract class AbstractGameObject implements StaticObject {
    
    private GameObjectType type;// все объекты будут иметь тип
    private Coordinate coordinate;// все объекты будут иметь координаты положения
    
    private ImageIcon icon = getImageIcon("/ru/javabegin/training/goldman/images/noicon.png");// изображение по-умолчанию

    public AbstractGameObject() {

    }

    public void setIcon(ImageIcon currentIcon) {
        this.icon = currentIcon;
    }

    @Override
    public ImageIcon getIcon() {
        return icon;
    }

    
    protected ImageIcon getImageIcon(String path){
        return new ImageIcon(getClass().getResource(path));
    }
    
    @Override
    public GameObjectType getType() {
        return type;
    }

    public void setType(GameObjectType type) {
        this.type = type;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

   
}
