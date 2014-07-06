package ru.javabegin.training.goldman.collections.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import ru.javabegin.training.goldman.collections.abstracts.MapMoveListenersRegistrator;
import ru.javabegin.training.goldman.enums.ActionResult;
import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.enums.MovingDirection;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractMovingObject;
import ru.javabegin.training.goldman.gameobjects.impl.Coordinate;
import ru.javabegin.training.goldman.gameobjects.impl.GoldMan;
import ru.javabegin.training.goldman.gameobjects.impl.Nothing;
import ru.javabegin.training.goldman.gameobjects.impl.Wall;
import ru.javabegin.training.goldman.listeners.interfaces.MoveResultListener;
import ru.javabegin.training.goldman.movestrategies.interfaces.MoveStrategy;

public class MapCollection extends MapMoveListenersRegistrator implements Serializable{// объекты для карты, которые умеют уведомлять всех слушателей о своих ходах

    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>();// хранит все объекты с доступом по координатам
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class); // хранит список объектов для каждого типа    

    public MapCollection() {

    }

    @Override
    public List<AbstractGameObject> getAllGameObjects() {
        return new ArrayList(gameObjects.values());// ! узкое место - каждый раз создается новая коллекция
    }

    @Override
    public List<AbstractGameObject> getGameObjects(GameObjectType type) {
        return typeObjects.get(type);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {
        AbstractGameObject gameObject = gameObjects.get(coordinate);
        if (gameObject == null) {// край карты
            gameObject = new Wall(coordinate);
        }
        return gameObject;
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(int x, int y) {
        return gameObjects.get(new Coordinate(x, y));
    }

    @Override
    public void addGameObject(AbstractGameObject gameObject) {

        ArrayList<AbstractGameObject> tmpList = typeObjects.get(gameObject.getType());

        if (tmpList == null) {
            tmpList = new ArrayList<>();
        }

        tmpList.add(gameObject);

        gameObjects.put(gameObject.getCoordinate(), gameObject);
        typeObjects.put(gameObject.getType(), tmpList);

    }

    @Override
    public void moveObject(MovingDirection direction, GameObjectType gameObjectType) {
        doMoveAction(direction, gameObjectType, null);// движение по направлению (без стратегии)
    }

    @Override
    public void moveObject(MoveStrategy moveStrategy, GameObjectType gameObjectType) {
        doMoveAction(null, gameObjectType, moveStrategy);// движение по стратегии
    }

    private void doMoveAction(MovingDirection direction, GameObjectType gameObjectType, MoveStrategy moveStrategy) {
        GoldMan goldMan = (GoldMan) getGameObjects(GameObjectType.GOLDMAN).get(0);

        ActionResult actionResult = null;
        
        if (this.getGameObjects(gameObjectType)==null){
            return;
        }
        
        for (AbstractGameObject gameObject : this.getGameObjects(gameObjectType)) {
            if (gameObject instanceof AbstractMovingObject) {// дорогостоящая операция - instanceof
                AbstractMovingObject movingObject = (AbstractMovingObject) gameObject;

                if (moveStrategy != null) {// если указана стратегия движения - то берем наравления оттуда
                    direction = moveStrategy.getDirection(movingObject, goldMan, this);
                }

                Coordinate newCoordinate = movingObject.getDirectionCoordinate(direction);

                AbstractGameObject objectInNewCoordinate = getObjectByCoordinate(newCoordinate);

                actionResult = movingObject.moveToObject(direction, objectInNewCoordinate);

                switch (actionResult) {
                    case MOVE: {
                        swapObjects(movingObject, objectInNewCoordinate);
                        break;
                    }
                    case COLLECT_TREASURE: {
                        swapObjects(movingObject, new Nothing(newCoordinate));
                        break;
                    }

                    case WIN:
                    case DIE: {
                        break;
                    }

                }

                notifyMoveListeners(actionResult, movingObject);

            }


        }
    }

    private void swapObjects(AbstractGameObject obj1, AbstractGameObject obj2) {

        swapCoordinates(obj1, obj2);

        gameObjects.put(obj1.getCoordinate(), obj1);
        gameObjects.put(obj2.getCoordinate(), obj2);

    }

    private void swapCoordinates(AbstractGameObject obj1, AbstractGameObject obj2) {
        Coordinate tmpCoordinate = obj1.getCoordinate();
        obj1.setCoordinate(obj2.getCoordinate());
        obj2.setCoordinate(tmpCoordinate);
    }

    @Override
    public void notifyMoveListeners(ActionResult actionResult, AbstractMovingObject movingObject) {
        for (MoveResultListener listener : getMoveListeners()) {
            listener.notifyActionResult(actionResult, movingObject);
        }
    }

    @Override
    public void clear() {
        gameObjects.clear();
        typeObjects.clear();
    }
}
