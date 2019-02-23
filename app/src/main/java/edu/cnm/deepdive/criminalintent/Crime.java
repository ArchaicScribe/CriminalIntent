package edu.cnm.deepdive.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {

  private UUID Id;
  private String Title;
  private java.util.Date Date;
  private boolean Solved;

  public Crime() {
    Id = UUID.randomUUID();
    Date = new Date();

  }

  public UUID getId() {
    return Id;
  }


  public String getTitle() {
    return Title;
  }

  public void setTitle(String title) {
    Title = title;
  }

  public java.util.Date getDate() {
    return Date;
  }

  public boolean isSolved() {
    return Solved;
  }

  public void setSolved(boolean solved) {
    Solved = solved;
  }
}
