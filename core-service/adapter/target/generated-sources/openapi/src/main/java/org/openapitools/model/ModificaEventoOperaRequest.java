package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ModificaEventoOperaRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-11T21:02:32.250328+02:00[Europe/Rome]")
public class ModificaEventoOperaRequest {

  private Integer idOperaNuova;

  public ModificaEventoOperaRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ModificaEventoOperaRequest(Integer idOperaNuova) {
    this.idOperaNuova = idOperaNuova;
  }

  public ModificaEventoOperaRequest idOperaNuova(Integer idOperaNuova) {
    this.idOperaNuova = idOperaNuova;
    return this;
  }

  /**
   * Get idOperaNuova
   * minimum: 1000
   * @return idOperaNuova
  */
  @NotNull @Min(1000) 
  @Schema(name = "idOperaNuova", example = "123456789", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idOperaNuova")
  public Integer getIdOperaNuova() {
    return idOperaNuova;
  }

  public void setIdOperaNuova(Integer idOperaNuova) {
    this.idOperaNuova = idOperaNuova;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModificaEventoOperaRequest modificaEventoOperaRequest = (ModificaEventoOperaRequest) o;
    return Objects.equals(this.idOperaNuova, modificaEventoOperaRequest.idOperaNuova);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idOperaNuova);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModificaEventoOperaRequest {\n");
    sb.append("    idOperaNuova: ").append(toIndentedString(idOperaNuova)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

