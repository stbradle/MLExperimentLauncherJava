package gov.nasa.modecounting.ml.experiments.menus;

import com.google.common.collect.ImmutableList;
import gov.nasa.modecounting.ml.experiments.reponses.Response;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class Menu {
  private final List<String> options;
  private final Map<String, Response> responses;
  final Scanner inputScanner = new Scanner(System.in);

  public Menu(final Map<String, Response> responses) {
    this.options = ImmutableList.copyOf(responses.keySet());
    this.responses = responses;
  }

  protected int getResponseFromUser() {
    if (inputScanner.hasNextInt()) {
      int resp = inputScanner.nextInt();
      return resp;
    } else {
      return -1;
    }
  }

  public Response getResponse() {
    this.displayOptions();
    // Options are indexed starting with 1 in CLI, actual list is 0 indexed.
    final int userResponse = this.getResponseFromUser() - 1;
    return this.responses.get(options.get(userResponse));
  }

  public void displayOptions() {
    int i = 1;
    for (final String option : options) {
      System.out.println(String.format("[%d] %s", i++, option));
    }
  }
}
