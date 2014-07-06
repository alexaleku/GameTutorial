package ru.javabegin.training.goldman.objects.listeners;

import ru.javabegin.training.goldman.enums.ActionResult;
import ru.javabegin.training.goldman.objects.GoldMan;

public interface MoveResultListener {
    
     public void notifyActionResult(ActionResult actionResult, GoldMan goldMan);

}
