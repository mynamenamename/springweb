package sample.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.repository.SampleRepository;

@Service
public class SampleService {

   @Autowired
   private SampleRepository sampleRepository;
   
   
   public String sample() {
      System.out.println("연결2");
      return sampleRepository.sample();
   }
}