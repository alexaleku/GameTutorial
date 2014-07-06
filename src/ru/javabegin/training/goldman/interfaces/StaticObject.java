/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.javabegin.training.goldman.interfaces;

import ru.javabegin.training.goldman.objects.Coordinate;
import javax.swing.ImageIcon;
import ru.javabegin.training.goldman.enums.GameObjectType;

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
