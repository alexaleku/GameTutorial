package ru.javabegin.training.goldman.interfaces.gameobjects;

import ru.javabegin.training.goldman.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.enums.ActionResult;
import ru.javabegin.training.goldman.enums.MovingDirection;

/**
 *
 * поведение для всех движущихся объектов: 
 */
public interface MovingObject extends StaticObject{
    
    ActionResult moveToObject(MovingDirection direction, AbstractGameObject gameObject); 
    
    int getStep();
       
}
