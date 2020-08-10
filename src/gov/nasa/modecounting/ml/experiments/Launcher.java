package gov.nasa.modecounting.ml.experiments;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import gov.nasa.modecounting.ml.experiments.actions.Action;
import gov.nasa.modecounting.ml.experiments.actions.MenuAction;
import gov.nasa.modecounting.ml.experiments.actions.QuitAction;
import gov.nasa.modecounting.ml.experiments.configuration.LauncherConfiguration;
import gov.nasa.modecounting.ml.experiments.menus.MainMenu;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.Scanner;

@Log4j2
public class Launcher {
  public static void main(String[] args) {

    try {
      final LauncherConfiguration launcherConfiguration =
          LauncherConfiguration.fromJson(
              FileUtils.readFileToString(
                  new File(
                      Paths.get("")
                          .resolve("configuration/launcher_configuration.json")
                          .toAbsolutePath()
                          .toString()),
                  Charset.defaultCharset()));

      final DefaultDockerClientConfig config =
          DefaultDockerClientConfig.createDefaultConfigBuilder().build();

      final DockerClient client = DockerClientBuilder.getInstance(config).build();

      System.out.println("What would you like to do:");

      Action nextAction = MenuAction.builder().menu(new MainMenu(launcherConfiguration)).build();

      do {
        nextAction = nextAction.performAction();
      } while (!(nextAction instanceof QuitAction));

    } catch (final IOException e) {
      throw new RuntimeException("Failed to read configuration file.", e);
    }
  }
}
