package ru.javabegin.training.goldman.interfaces.gamemap;

import java.awt.Component;
import ru.javabegin.training.goldman.abstracts.AbstractGameMap;

public interface DrawableMap {
    
    Component getMapComponent();
    
    AbstractGameMap getGameMap();
    
    boolean drawMap();    

}
