package ru.javabegin.training.goldman.objects.listeners;

import java.util.List;
import ru.javabegin.training.goldman.enums.ActionResult;
import ru.javabegin.training.goldman.objects.GoldMan;

public interface MoveResultNotifier {
    
    List<MoveResultListener> getMoveListeners();

    void addMoveListener(MoveResultListener listener);

    public void removeMoveListener(MoveResultListener listener);

    public void removeAllLMoveisteners();

    public void notifyMoveListeners(ActionResult actionResult, GoldMan goldMan);

}
