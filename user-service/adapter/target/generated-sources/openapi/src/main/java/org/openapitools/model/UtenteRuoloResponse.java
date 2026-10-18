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
 * UtenteRuoloResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-11T21:02:24.189691+02:00[Europe/Rome]")
public class UtenteRuoloResponse {

  private Integer idUtente;

  private Integer idRuolo;

  private Integer idUtenteRuolo;

  public UtenteRuoloResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UtenteRuoloResponse(Integer idUtente, Integer idRuolo, Integer idUtenteRuolo) {
    this.idUtente = idUtente;
    this.idRuolo = idRuolo;
    this.idUtenteRuolo = idUtenteRuolo;
  }

  public UtenteRuoloResponse idUtente(Integer idUtente) {
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

  public UtenteRuoloResponse idRuolo(Integer idRuolo) {
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

  public UtenteRuoloResponse idUtenteRuolo(Integer idUtenteRuolo) {
    this.idUtenteRuolo = idUtenteRuolo;
    return this;
  }

  /**
   * Get idUtenteRuolo
   * minimum: 1
   * @return idUtenteRuolo
  */
  @NotNull @Min(1) 
  @Schema(name = "idUtenteRuolo", example = "5000", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idUtenteRuolo")
  public Integer getIdUtenteRuolo() {
    return idUtenteRuolo;
  }

  public void setIdUtenteRuolo(Integer idUtenteRuolo) {
    this.idUtenteRuolo = idUtenteRuolo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UtenteRuoloResponse utenteRuoloResponse = (UtenteRuoloResponse) o;
    return Objects.equals(this.idUtente, utenteRuoloResponse.idUtente) &&
        Objects.equals(this.idRuolo, utenteRuoloResponse.idRuolo) &&
        Objects.equals(this.idUtenteRuolo, utenteRuoloResponse.idUtenteRuolo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idUtente, idRuolo, idUtenteRuolo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UtenteRuoloResponse {\n");
    sb.append("    idUtente: ").append(toIndentedString(idUtente)).append("\n");
    sb.append("    idRuolo: ").append(toIndentedString(idRuolo)).append("\n");
    sb.append("    idUtenteRuolo: ").append(toIndentedString(idUtenteRuolo)).append("\n");
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

