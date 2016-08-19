package com.dataflowdeveloper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 */
@Controller
@RequestMapping(value = "/admin/**", produces = "application/json")
public class AdminController {

  @RequestMapping(value = "/kill", method = RequestMethod.GET)
  @ResponseBody
  public MessageResponse kill() {
	System.err.println("Killing instance");
    System.exit(-1);
    return MessageResponse.errorResponse("system killed");
  }
}