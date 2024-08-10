package com.finalproject.controllers;

import com.finalproject.dao.SurplusFoodAlertDAO;
import com.finalproject.services.SurplusFoodAlertService;

public class SurplusFoodAlertController {
  private SurplusFoodAlertService surplusFoodAlertService;

  public SurplusFoodAlertController(SurplusFoodAlertService surplusFoodAlertService) {
    this.surplusFoodAlertService = surplusFoodAlertService;
  }

  public void subscribeAlert(SurplusFoodAlert surplusFoodAlert) {
    surplusFoodAlertService.subscribeAlert(surplusFoodAlert);
  }

  public void unsubscribeAlert(int userId) {
    surplusFoodAlertService.unsubscribeAlert(userId);
  }

  public void notifyUsers() {
    surplusFoodAlertService.notifyUsers();
  }

}
