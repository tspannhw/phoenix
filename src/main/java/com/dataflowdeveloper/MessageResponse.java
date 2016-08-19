package com.dataflowdeveloper;

/**
 * Created by sgupta on 11/3/14.
 */
public class MessageResponse {
  private final String status;
  private final String message;


  public MessageResponse(String status, String message) {
    this.status = status;
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }

  public static MessageResponse okResponse(String message) {
    return new MessageResponse("ok", message);
  }

  public static MessageResponse errorResponse(String message) {
    return new MessageResponse("error", message);
  }
}
