/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.javabegin.training.goldman.objects.game.interfaces;

import ru.javabegin.training.goldman.objects.common.Coordinate;
import javax.swing.ImageIcon;
import ru.javabegin.goldman.game.enums.GameObjectType;

/**
 *
 * @author Tim
 */
public interface StaticObject {
 
    // объект должен иметь иконку
    ImageIcon getIcon();

    // координаты
    Coordinate getCoordinate();

    // тип объекта
    GameObjectType getType();
    
            
}
