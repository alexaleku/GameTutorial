package ru.javabegin.training.goldman.interfaces.gamemap.collections;

import java.util.List;
import ru.javabegin.training.goldman.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.enums.MovingDirection;
import ru.javabegin.training.goldman.movestrategies.MoveStrategy;
import ru.javabegin.training.goldman.objects.Coordinate;
import ru.javabegin.training.goldman.objects.listeners.MoveResultNotifier;

public interface GameCollection extends MoveResultNotifier{
    
    AbstractGameObject getObjectByCoordinate(Coordinate coordinate);
    
    AbstractGameObject getObjectByCoordinate(int x, int y);
    
    void addGameObject(AbstractGameObject gameObject);
    
    List<AbstractGameObject> getAllGameObjects();
    
    List<AbstractGameObject> getGameObjects(GameObjectType type);
    
    void moveObject(MovingDirection direction, GameObjectType gameObjectType);
    
    void moveObject(MoveStrategy moveStrategy, GameObjectType gameObjectType);
    
    

}
