package com.finalproject.observer;

import com.finalproject.models.SurplusFoodAlert;

public interface SurplusFoodAlertSubject {
  
  public void addObserver(SurplusFoodAlertObserver observer);

  public void removeObserver(SurplusFoodAlertObserver observer);

  public void notifyObservers(SurplusFoodAlert surplusFoodAlert );

}
