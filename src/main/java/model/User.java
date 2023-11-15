package model;
import java.io.Serializable;

public class User implements Serializable {
  private String id; // ユーザー名
  private String pass; // パスワード
  private String mail;
  private String name;
  private int age;

  public User(String id,String name, String pass,String mail,int age) {
    this.name = name;
    this.pass = pass;
    this.id = id;
    this.mail = mail;
    this.age = age;
  }
  public String getName() { return name; }
  public String getPass() { return pass; }
  public String getId() { return id; }
  public String getMail() { return mail; }
  public int getAge() { return age; }
}