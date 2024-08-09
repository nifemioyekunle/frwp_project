package com.finalproject.servlets;

import com.finalproject.dao.UserDAO;
import com.finalproject.services.UserService;
import com.finalproject.models.User;
import com.finalproject.factories.UserFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/user")
public class UserServlet extends HttpServlet {
  private UserService userService;

  @Override
  public void init() throws ServletException {
    super.init();
    userService = new UserService(new UserDAO());
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if ("register".equals(action)) {
      handleRegister(request, response);
    } else if ("login".equals(action)) {
      handleLogin(request, response);
    } else if ("logout".equals(action)) {
      handleLogout(request, response);
    }
  }

  private void handleRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String userTypeString = request.getParameter("userType");
    User.UserType userType = User.UserType.valueOf(userTypeString.toUpperCase());
    // int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    User user = UserFactory.createUser(userType, id, name, email, password);
    userService.registerUser(user);
    response.getWriter().println("Registration successful");
  }

  private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    User user = userService.loginUser(email, password);
    if (user != null) {
      request.getSession().setAttribute("user", user);
      response.getWriter().println("Login successful");
    } else {
      response.getWriter().println("Invalid email or password");
    }
    response.getWriter().println("Login successful");
  }
}
