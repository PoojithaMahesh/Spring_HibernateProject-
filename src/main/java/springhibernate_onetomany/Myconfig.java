package springhibernate_onetomany;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import net.bytebuddy.matcher.ElementMatcher;

@Configuration
@ComponentScan(basePackages = {"springhibernate_onetomany"})
public class Myconfig {
     @Bean
     public EntityManager getEntityManager() {
    	 return Persistence.createEntityManagerFactory("vinod").createEntityManager();
     }
     @Bean
     public Scanner getScanner() {
    	 Scanner scanner=new Scanner(System.in);
    	 return scanner;
     }
     @Bean
     public List<Item> list(){
    	 return new ArrayList<Item>();
     }
  
}
