package sample.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SampleRepository {

   @Autowired
   private SqlSessionTemplate sqlSession;
   
   public String sample() {
      System.out.println("연결1");
      String sample = sqlSession.selectOne("mm.sample");
      return sample;
   }
}