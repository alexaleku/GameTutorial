package ru.javabegin.training.goldman.listeners.interfaces;

import java.util.List;
import ru.javabegin.training.goldman.enums.ActionResult;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractMovingObject;

public interface MoveResultNotifier {
    
    List<MoveResultListener> getMoveListeners();

    void addMoveListener(MoveResultListener listener);

    public void removeMoveListener(MoveResultListener listener);

    public void removeAllMoveListeners();

    public void notifyMoveListeners(ActionResult actionResult, AbstractMovingObject abstractMovingObject);

}
