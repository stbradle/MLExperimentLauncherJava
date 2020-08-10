package gov.nasa.modecounting.ml.experiments.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@JsonDeserialize(builder = LauncherConfiguration.Builder.class)
@Builder(builderClassName = "Builder")
@AllArgsConstructor
public class LauncherConfiguration {
  @JsonProperty("container.data_generator")
  String dataGeneratorId;

  @JsonProperty("container.data_curator")
  String dataCuratorId;

  @JsonProperty("container.ml_engine")
  String mlEngineId;

  @JsonProperty("container.result_curator")
  String resultCuratorId;

  public static LauncherConfiguration fromJson(final String json) {
    final ObjectMapper mapper = new ObjectMapper();

    try {
      final JsonNode containers = mapper.readTree(json).get("container");
      return builder()
            .dataGeneratorId(containers.get("data_generator").textValue())
            .dataCuratorId(containers.get("data_curator").textValue())
            .mlEngineId(containers.get("ml_engine").textValue())
            .resultCuratorId(containers.get("result_curator").textValue())
            .build();
    } catch (final Exception e) {
      throw new RuntimeException("Failed to parse Launcher Configuration Json.", e);
    }
  }
  // Class needed to support annotations.
  @JsonPOJOBuilder
  public static class Builder {}
}
