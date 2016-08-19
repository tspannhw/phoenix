package com.dataflowdeveloper;

/**
 * Created by sgupta on 11/1/14.
 */
public class DatesResponse {
  private final String formattedDate;
  private final String year;
  private final String month;

  public DatesResponse(String formattedDate, String year, String month) {
    this.formattedDate = formattedDate;
    this.year = year;
    this.month = month;
  }

  public String getFormattedDate() {
    return formattedDate;
  }

  public String getYear() {
    return year;
  }

  public String getMonth() {
    return month;
  }
}
