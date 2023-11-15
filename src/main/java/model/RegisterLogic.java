package model;

import dao.MuttersDAO;

public class RegisterLogic {
  public void execute(Mutter mutter) { 
    MuttersDAO dao = new MuttersDAO();
    dao.create(mutter);
  }
}