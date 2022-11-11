package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sample.Service.SampleService;

@Controller
public class SampleController {
   @Autowired
   SampleService sampleService;
   
   @RequestMapping("sample.do")
   public String sample(Model m) {
      System.out.println("연결3");
      String sample = sampleService.sample();
      m.addAttribute("serverTime",sample);
      return "home";
   }
}