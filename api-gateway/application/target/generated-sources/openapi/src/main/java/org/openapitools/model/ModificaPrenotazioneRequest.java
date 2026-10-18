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
 * ModificaPrenotazioneRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-11T21:02:39.028177+02:00[Europe/Rome]")
public class ModificaPrenotazioneRequest {

  private Integer numeroPartecipanti;

  public ModificaPrenotazioneRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ModificaPrenotazioneRequest(Integer numeroPartecipanti) {
    this.numeroPartecipanti = numeroPartecipanti;
  }

  public ModificaPrenotazioneRequest numeroPartecipanti(Integer numeroPartecipanti) {
    this.numeroPartecipanti = numeroPartecipanti;
    return this;
  }

  /**
   * Get numeroPartecipanti
   * minimum: 2
   * @return numeroPartecipanti
  */
  @NotNull @Min(2) 
  @Schema(name = "numeroPartecipanti", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("numeroPartecipanti")
  public Integer getNumeroPartecipanti() {
    return numeroPartecipanti;
  }

  public void setNumeroPartecipanti(Integer numeroPartecipanti) {
    this.numeroPartecipanti = numeroPartecipanti;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModificaPrenotazioneRequest modificaPrenotazioneRequest = (ModificaPrenotazioneRequest) o;
    return Objects.equals(this.numeroPartecipanti, modificaPrenotazioneRequest.numeroPartecipanti);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numeroPartecipanti);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModificaPrenotazioneRequest {\n");
    sb.append("    numeroPartecipanti: ").append(toIndentedString(numeroPartecipanti)).append("\n");
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

