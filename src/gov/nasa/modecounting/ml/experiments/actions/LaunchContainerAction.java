package gov.nasa.modecounting.ml.experiments.actions;

import gov.nasa.modecounting.ml.experiments.configuration.LauncherConfiguration;
import gov.nasa.modecounting.ml.experiments.menus.MainMenu;
import lombok.Builder;

@Builder
public class LaunchContainerAction implements Action {
  private final LauncherConfiguration config;
  private final String containerId;

  @Override
  public Action performAction() {
    System.out.println(String.format("Launch a container with container id: %s", containerId));
    return MenuAction.builder().menu(new MainMenu(this.config)).build();
  }
}
