package com.finalproject.services;

import java.util.List;
import java.util.ArrayList;
import com.finalproject.models.SurplusFoodAlert;
import com.finalproject.dao.SurplusFoodAlertDAO;
import com.finalproject.observer.SurplusFoodAlertSubject;
import com.finalproject.observer.SurplusFoodAlertObserver;

public class SurplusFoodAlertService implements SurplusFoodAlertSubject {

  private SurplusFoodAlertDAO surplusFoodAlertDAO;
  private List<SurplusFoodAlertObserver> observers = new ArrayList<SurplusFoodAlertObserver>();

  public SurplusFoodAlertService(SurplusFoodAlertDAO surplusFoodAlertDAO) {
    this.surplusFoodAlertDAO = new SurplusFoodAlertDAO();
  }

  public void subscribeAlert(SurplusFoodAlert surplusFoodAlert) {
    this.surplusFoodAlertDAO.addSurplusFoodAlert(surplusFoodAlert);
    notifyObservers(surplusFoodAlert);
    surplusFoodAlert.subscribe(); //TODO: implement this
  }

  public void unsubscribeAlert(SurplusFoodAlert surplusFoodAlert) {
    this.surplusFoodAlertDAO.deleteSurplusFoodAlert(surplusFoodAlert.getSurplusFoodAlertId());
    surplusFoodAlert.unsubscribe(); //TODO: implement this
  }

  @Override
  public void notifyObservers(SurplusFoodAlert surplusFoodAlert) { //!WORK ON THIS
    // List <SurplusFoodAlert> surplusFoodAlerts = this.surplusFoodAlertDAO.getSurplusFoodAlerts();
    // this.surplusFoodAlertDAO.notifyUsers();

    for (SurplusFoodAlertObserver observer : observers) {
      observer.update(surplusFoodAlert); //TODO: implement this
    }
  }

  @Override
  public void addObserver(SurplusFoodAlertObserver observer) {
    this.observers.add(observer);
  }

  @Override
  public void removeObserver(SurplusFoodAlertObserver observer) {
    this.observers.remove(observer);
  }

}
