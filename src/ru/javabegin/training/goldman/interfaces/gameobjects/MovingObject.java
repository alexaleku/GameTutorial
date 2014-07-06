/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.javabegin.training.goldman.interfaces.gameobjects;

import ru.javabegin.training.goldman.abstracts.AbstractGameMap;
import ru.javabegin.training.goldman.enums.MovingDirection;

/**
 *
 * поведение для всех движущихся объектов: 
 */
public interface MovingObject extends StaticObject{
    
    void move(MovingDirection direction, AbstractGameMap abstractGameMap);
    
    int getStep();
   
}
