/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.javabegin.training.goldman.objects.game.interfaces;

import javax.swing.ImageIcon;
import ru.javabegin.goldman.game.enums.MovingDirection;
import ru.javabegin.training.goldman.objects.common.AbstractGameObject;

/**
 *
 * поведение для всех движущихся объектов: 
 */
public interface MovingObject extends StaticObject{
    
    void move(MovingDirection direction);
    
    void getMoveResult(AbstractGameObject objectInNewCoordinate);
    
    // иконки при движении в разные стороны
    ImageIcon getIconLeft();

    ImageIcon getIconUp();

    ImageIcon getIconDown();

    ImageIcon getIconRight();

   
   
}
