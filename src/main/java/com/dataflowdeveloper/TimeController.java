package com.dataflowdeveloper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "/time/**", produces = "application/json")
public class TimeController {

  @RequestMapping(value = "/now")
  @ResponseBody
  public Map<String,String> getTime() {
    Map<String,String> map = new HashMap<>();
    map.put("time", ""+System.currentTimeMillis());
    return map;
  }
}
