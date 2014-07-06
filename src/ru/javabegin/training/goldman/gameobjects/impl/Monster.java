package ru.javabegin.training.goldman.gameobjects.impl;

import javax.sound.sampled.Clip;
import ru.javabegin.training.goldman.enums.ActionResult;
import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.enums.MovingDirection;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractSoundObject;

/**
 * класс отвечает за работу объекта MONSTER
 */
public class Monster extends AbstractSoundObject{

    private transient Clip clip;

    public Monster(Coordinate coordinate) {
        super.setType(GameObjectType.MONSTER);
        super.setCoordinate(coordinate);
        super.setIcon(getImageIcon("/ru/javabegin/training/goldman/images/monster_up.jpg"));// иконку по-умолчанию (можно сделать реализацию случайного выбора иконки)

    }

    @Override
    public void changeIcon(MovingDirection direction) {
        switch (direction) {
            case DOWN:
                super.setIcon(getImageIcon("/ru/javabegin/training/goldman/images/monster_down.jpg"));
                break;
            case LEFT:
                super.setIcon(getImageIcon("/ru/javabegin/training/goldman/images/monster_right.jpg"));
                break;
            case RIGHT:
                super.setIcon(getImageIcon("/ru/javabegin/training/goldman/images/monster_right.jpg"));
                break;
            case UP:
                super.setIcon(getImageIcon("/ru/javabegin/training/goldman/images/monster_up.jpg"));
                break;
        }
    }

    @Override
    public ActionResult doAction(AbstractGameObject gameObject) {

        switch (gameObject.getType()) {
       
            case TREASURE:
            case MONSTER:
            case TREE:
            { // монстр не может наступать на сокровище, дерево и на других монстров
                return ActionResult.NO_ACTION;
            }

            case GOLDMAN: {
                return ActionResult.DIE;
            }

        }

        return super.doAction(gameObject);
    }

    @Override
    public Clip getSoundClip(ActionResult actionResult) {
        switch (actionResult) {
            case DIE:
                return super.getDieClip();

        }

        return null;
    }
}