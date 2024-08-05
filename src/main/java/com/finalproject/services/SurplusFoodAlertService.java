package com.finalproject.services;

import com.finalproject.models.SurplusFoodAlert;
import com.finalproject.dao.SurplusFoodAlertDAO;

public class SurplusFoodAlertService {

  private SurplusFoodAlertDAO surplusFoodAlertDAO;

  public SurplusFoodAlertService() {
    this.surplusFoodAlertDAO = new SurplusFoodAlertDAO();
  }

  public void subscribeAlert(SurplusFoodAlert surplusFoodAlert) {
    this.surplusFoodAlertDAO.addSurplusFoodAlert(surplusFoodAlert);
  }

  public void unsubscribeAlert(int userId) {
    this.surplusFoodAlertDAO.deleteSurplusFoodAlert(userId);
  }

  public void notifyUsers() { //!WORK ON THIS
    List <SurplusFoodAlert> surplusFoodAlerts = this.surplusFoodAlertDAO.getSurplusFoodAlerts();
    this.surplusFoodAlertDAO.notifyUsers();
  }

}
