package com.finalproject.controllers;

import com.finalproject.models.SurplusFoodAlert;
import com.finalproject.observer.SurplusFoodAlertSubject;
//import com.finalproject.dao.SurplusFoodAlertDAO;
import com.finalproject.services.SurplusFoodAlertService;

public class SurplusFoodAlertController {
  private SurplusFoodAlertService surplusFoodAlertService;

  public SurplusFoodAlertController(SurplusFoodAlertService surplusFoodAlertService) {
    this.surplusFoodAlertService = surplusFoodAlertService;
  }

  public void subscribeAlert(SurplusFoodAlert surplusFoodAlert) {
    surplusFoodAlertService.subscribeAlert(surplusFoodAlert);
  }

  public void unsubscribeAlert(SurplusFoodAlert surplusFoodAlert) {
    surplusFoodAlertService.unsubscribeAlert(surplusFoodAlert);
  }

  public void notifyUsers(SurplusFoodAlert surplusFoodAlert) {
    surplusFoodAlertService.notifyObservers(surplusFoodAlert);
  }
  

}
