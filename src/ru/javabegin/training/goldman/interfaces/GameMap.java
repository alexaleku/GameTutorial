package ru.javabegin.training.goldman.interfaces;

/**
 * интерфейс для игровой карты
 */
public interface GameMap {
    
    int getHeight();
    
    int getWidth();
    
    boolean loadMap();
    
    boolean saveMap();

    boolean drawMap();
    
    int getTimeLimit();
    
}
