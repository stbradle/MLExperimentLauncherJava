package gov.nasa.modecounting.ml.experiments.actions;

import gov.nasa.modecounting.ml.experiments.menus.Menu;
import lombok.Builder;

@Builder
public class MenuAction implements Action {
   final Menu menu;
   public Action performAction() {
      return this.menu.getResponse().nextAction();
   }
}
