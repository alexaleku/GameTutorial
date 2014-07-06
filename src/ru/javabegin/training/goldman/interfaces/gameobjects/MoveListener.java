package ru.javabegin.training.goldman.interfaces.gameobjects;

import java.util.List;
import ru.javabegin.training.goldman.abstracts.AbstractGameObject;

public interface MoveListener {

    List<GameObjectMoveListener> getListeners();

    void addListener(GameObjectMoveListener listener);

    public void removeListener(GameObjectMoveListener listener);

    public void removeAllListeners();

    public void notifyListeners(AbstractGameObject obj1, AbstractGameObject obj2);
}
