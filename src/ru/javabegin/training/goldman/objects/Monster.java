package ru.javabegin.training.goldman.objects;

import ru.javabegin.training.goldman.abstracts.AbstractMovingObject;
import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.enums.MovingDirection;

/**
 * класс отвечает за работу объекта MONSTER
 */
public class Monster extends AbstractMovingObject {

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





}
