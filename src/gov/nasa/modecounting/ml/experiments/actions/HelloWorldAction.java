package gov.nasa.modecounting.ml.experiments.actions;

import lombok.AllArgsConstructor;
import lombok.Builder;

public class HelloWorldAction implements Action {
   @Override
   public Action performAction() {
      System.out.println("HELLO WORLD");
      return new QuitAction();
   }
}
