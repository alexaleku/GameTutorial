package ru.javabegin.training.goldman.gamemap.interfaces;

import java.awt.Component;

public interface DrawableMap extends MainMap{
    
    Component getMapComponent();
    
    boolean drawMap();    

}
