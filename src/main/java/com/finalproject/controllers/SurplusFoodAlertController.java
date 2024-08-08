package com.finalproject.controllers;

import com.finalproject.services.SurplusFoodAlertService;

public class SurplusFoodAlertController {
  private SurplusFoodAlertService surplusFoodAlertService;

  public SurplusFoodAlertController() {
    this.surplusFoodAlertService = new SurplusFoodAlertService();
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
