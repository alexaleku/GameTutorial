package ru.javabegin.training.goldman.objects;

import ru.javabegin.training.goldman.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.enums.GameObjectType;


/**
 * класс отвечает за работу объекта TREASURE
 */
public class Treasure extends AbstractGameObject {

    public Treasure(Coordinate coordinate) {
        super.setType(GameObjectType.TREASURE);
        super.setCoordinate(coordinate);
        super.setIcon(getImageIcon("/ru/javabegin/training/goldman/images/gold.png"));
    }
    
    
    private int score = 5;// каждое сокровище будет давать 5 очков игроку

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
