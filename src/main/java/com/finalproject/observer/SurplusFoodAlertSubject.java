package com.finalproject.observer;

public class SurplusFoodAlertSubject {
  
  public void addObserver(SurplusFoodAlertObserver observer);

  public void removeObserver(SurplusFoodAlertObserver observer);

  public void notifyObservers(SurplusFoodAlert surplusFoodAlert );

}
