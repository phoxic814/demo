package org.example.excution.order;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import org.springframework.stereotype.Component;

@Component
public class CustomListener implements ServletRequestListener {

   /**
    * first time will before dispatcher servlet
    */
   @Override
   public void requestInitialized(ServletRequestEvent sre) {
      System.out.println("custom listener start");
   }

   @Override
   public void requestDestroyed(ServletRequestEvent sre) {
      System.out.println("custom listener end");
   }
}
