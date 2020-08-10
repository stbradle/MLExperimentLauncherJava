package gov.nasa.modecounting.ml.experiments.actions;

public class QuitAction implements Action {
   @Override
   public Action performAction() {
      //Do nothing.
      throw new RuntimeException("Oops this is never supposed to be called.");
   }
}
