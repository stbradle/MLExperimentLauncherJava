package gov.nasa.modecounting.ml.experiments.reponses;

import gov.nasa.modecounting.ml.experiments.actions.Action;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class Response {
  @NonNull protected final Action nextAction;

  public Action nextAction() {
    return nextAction;
  }
}
