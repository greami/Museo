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
 * UtenteRuoloBase
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-11T21:02:38.874217+02:00[Europe/Rome]")
public class UtenteRuoloBase {

  private Integer idUtente;

  private Integer idRuolo;

  public UtenteRuoloBase() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UtenteRuoloBase(Integer idUtente, Integer idRuolo) {
    this.idUtente = idUtente;
    this.idRuolo = idRuolo;
  }

  public UtenteRuoloBase idUtente(Integer idUtente) {
    this.idUtente = idUtente;
    return this;
  }

  /**
   * Get idUtente
   * minimum: 1
   * @return idUtente
  */
  @NotNull @Min(1) 
  @Schema(name = "idUtente", example = "5000", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idUtente")
  public Integer getIdUtente() {
    return idUtente;
  }

  public void setIdUtente(Integer idUtente) {
    this.idUtente = idUtente;
  }

  public UtenteRuoloBase idRuolo(Integer idRuolo) {
    this.idRuolo = idRuolo;
    return this;
  }

  /**
   * Get idRuolo
   * minimum: 1
   * @return idRuolo
  */
  @NotNull @Min(1) 
  @Schema(name = "idRuolo", example = "5000", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idRuolo")
  public Integer getIdRuolo() {
    return idRuolo;
  }

  public void setIdRuolo(Integer idRuolo) {
    this.idRuolo = idRuolo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UtenteRuoloBase utenteRuoloBase = (UtenteRuoloBase) o;
    return Objects.equals(this.idUtente, utenteRuoloBase.idUtente) &&
        Objects.equals(this.idRuolo, utenteRuoloBase.idRuolo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idUtente, idRuolo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UtenteRuoloBase {\n");
    sb.append("    idUtente: ").append(toIndentedString(idUtente)).append("\n");
    sb.append("    idRuolo: ").append(toIndentedString(idRuolo)).append("\n");
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

