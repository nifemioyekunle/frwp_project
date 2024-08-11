package com.finalproject.servlets;

import com.finalproject.services.SurplusFoodAlertService;
import com.finalproject.dao.SurplusFoodAlertDAO;
import com.finalproject.observer.SurplusFoodAlertObserver;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/notification")
public class NotificationServlet extends HttpServlet{
  private SurplusFoodAlertService surplusFoodAlertService;

  @Override
  public void init() throws ServletException {
    super.init();
    surplusFoodAlertService = new SurplusFoodAlertService(new SurplusFoodAlertDAO());
    surplusFoodAlertService.addObserver(new SurplusFoodAlertObserver());
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if ("subscribe".equals(action)) {
      handleSubcribe(request, response);
    } else if ("unsubscribe".equals(action)) {
      unhandleSubscribe(request, response);
    }
  }

  private void handleSubcribe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int userId = Integer.parseInt(request.getParameter("userId"));
    String location = request.getParameter("location");
    String communicationMethod = request.getParameter("communicationMethod");
    String foodPreferences = request.getParameter("foodPreferences");

    SurplusFoodAlert surplusFoodAlert = new SurplusFoodAlert(userId, location, CommunicationMethod.valueOf(communicationMethod), foodPreferences);
    surplusFoodAlertService.subscribeAlert(surplusFoodAlert);
    response.getWriter().println("Subscribed successfully");
  }

  private void unhandleSubscribe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int userId = Integer.parseInt(request.getParameter("alertId"));

    SurplusFoodAlert surplusFoodAlert = new SurplusFoodAlert(alertId, o, null, null, null);
    surplusFoodAlertService.unsubscribeAlert(surplusFoodAlert);
    response.getWriter().println("Unsubscribed successfully");
  }

}
