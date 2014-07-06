package ru.javabegin.training.goldman.interfaces.gameobjects;

import ru.javabegin.training.goldman.abstracts.AbstractGameObject;

public interface GameObjectMoveListener {
    
    public void moveAction(AbstractGameObject obj1, AbstractGameObject obj2);

}
