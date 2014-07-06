package ru.javabegin.training.goldman.abstracts;

import ru.javabegin.training.goldman.enums.MovingDirection;
import ru.javabegin.training.goldman.interfaces.gameobjects.MovingObject;
import ru.javabegin.training.goldman.objects.Coordinate;

/**
 * класс, который отвечает за любой движущийся объект. наследуется от класса
 * AbstractGameObject с добавлением функций движения
 */
public abstract class AbstractMovingObject extends AbstractGameObject implements MovingObject {

    public abstract void changeIcon(MovingDirection direction);

    @Override
    public void move(MovingDirection direction, AbstractGameMap gameMap) {

        Coordinate newCoordinate = getNewCoordinate(direction);
        

        AbstractGameObject objectInNewCoordinate = gameMap.getGameCollection().getObjectByCoordinate(newCoordinate);

        switch (objectInNewCoordinate.getType()) {

            case NOTHING: {
                changeIcon(direction);
                setCoordinate(newCoordinate);
            }

            default: {
            }

        }

    }


    public Coordinate getNewCoordinate(MovingDirection direction) {

        // берем текущие координаты объекта, которые нужно передвинуть (индексы начинаются с нуля)
        int x = this.getCoordinate().getX();
        int y = this.getCoordinate().getY();


        Coordinate newCoordinate = new Coordinate(x, y);


        switch (direction) {// определяем, в каком направлении нужно двигаться по массиву
            case UP: {
                newCoordinate.setY(y - 1);
                break;
            }
            case DOWN: {
                newCoordinate.setY(y + 1);
                break;
            }
            case LEFT: {
                newCoordinate.setX(x - 1);
                break;
            }
            case RIGHT: {
                newCoordinate.setX(x + 1);
                break;
            }
        }

        return newCoordinate;
    }
}
