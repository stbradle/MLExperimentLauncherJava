package gov.nasa.modecounting.ml.experiments.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ExperimentContainer {
   DATA_GENERATION("dataGenerator"),
   DATA_CURATION("dataCurator"),
   PREDICTION_ENGINE("predictionModel"),
   RESULTS_CURATOR("resultsCurator");

   @Getter private final String containerName;
}
