package gov.nasa.modecounting.ml.experiments.menus;

import com.google.common.collect.ImmutableMap;
import gov.nasa.modecounting.ml.experiments.actions.LaunchContainerAction;
import gov.nasa.modecounting.ml.experiments.actions.QuitAction;
import gov.nasa.modecounting.ml.experiments.configuration.LauncherConfiguration;
import gov.nasa.modecounting.ml.experiments.reponses.Response;

public class MainMenu extends Menu {
  public MainMenu(final LauncherConfiguration config) {
    super(
        ImmutableMap.of(
            "Generate Data.",
            new Response(
                LaunchContainerAction.builder()
                    .config(config)
                    .containerId(config.getDataGeneratorId())
                    .build()),
            "Clean Data.",
            new Response(
                LaunchContainerAction.builder()
                    .config(config)
                    .containerId(config.getDataCuratorId())
                    .build()),
            "Train Model.",
            new Response(
                LaunchContainerAction.builder()
                    .config(config)
                    .containerId(config.getMlEngineId())
                    .build()),
            "Quit",
            new Response(new QuitAction())));
  }
}
