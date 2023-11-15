package model;

import dao.RegisterDAO;

public class RegisterLogic {
  public void execute(User user) { 
    RegisterDAO dao = new RegisterDAO();
    dao.create(user);
  }
}