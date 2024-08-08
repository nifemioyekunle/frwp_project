package com.finalproject.services;

import com.finalproject.models.SurplusFoodAlert;

import java.util.List;

import com.finalproject.dao.SurplusFoodAlertDAO;

public class SurplusFoodAlertService {

  private SurplusFoodAlertDAO surplusFoodAlertDAO;
  private List<SurplusFoodAlertObserver> observers = new ArrayList<SurplusFoodAlertObserver>();

  public SurplusFoodAlertService() {
    this.surplusFoodAlertDAO = new SurplusFoodAlertDAO();
  }

  public void subscribeAlert(SurplusFoodAlert surplusFoodAlert) {
    this.surplusFoodAlertDAO.addSurplusFoodAlert(surplusFoodAlert);
    surplusFoodAlert.subscribe(); //TODO: implement this
  }

  public void unsubscribeAlert(SurplusFoodAlert surplusFoodAlert) {
    this.surplusFoodAlertDAO.deleteSurplusFoodAlert(surplusFoodAlert);
    surplusFoodAlert.unsubscribe(); //TODO: implement this
  }

  public void notifyUsers(SurplusFoodAlert surplusFoodAlert) { //!WORK ON THIS
    // List <SurplusFoodAlert> surplusFoodAlerts = this.surplusFoodAlertDAO.getSurplusFoodAlerts();
    // this.surplusFoodAlertDAO.notifyUsers();

    for (SurplusFoodAlertObserver observer : observers) {
      observer.update(surplusFoodAlert); //TODO: implement this
    }
  }

  public void addObserver(SurplusFoodAlertObserver observer) {
    this.observers.add(observer);
  }

  public void removeObserver(SurplusFoodAlertObserver observer) {
    this.observers.remove(observer);
  }

}
