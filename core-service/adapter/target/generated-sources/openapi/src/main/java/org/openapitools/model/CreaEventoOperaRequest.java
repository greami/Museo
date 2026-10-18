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
 * CreaEventoOperaRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-11T21:02:32.250328+02:00[Europe/Rome]")
public class CreaEventoOperaRequest {

  private Integer idEvento;

  private Integer idOpera;

  public CreaEventoOperaRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreaEventoOperaRequest(Integer idEvento, Integer idOpera) {
    this.idEvento = idEvento;
    this.idOpera = idOpera;
  }

  public CreaEventoOperaRequest idEvento(Integer idEvento) {
    this.idEvento = idEvento;
    return this;
  }

  /**
   * Get idEvento
   * minimum: 1000
   * @return idEvento
  */
  @NotNull @Min(1000) 
  @Schema(name = "idEvento", example = "123456789", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idEvento")
  public Integer getIdEvento() {
    return idEvento;
  }

  public void setIdEvento(Integer idEvento) {
    this.idEvento = idEvento;
  }

  public CreaEventoOperaRequest idOpera(Integer idOpera) {
    this.idOpera = idOpera;
    return this;
  }

  /**
   * Get idOpera
   * minimum: 1000
   * @return idOpera
  */
  @NotNull @Min(1000) 
  @Schema(name = "idOpera", example = "123456789", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idOpera")
  public Integer getIdOpera() {
    return idOpera;
  }

  public void setIdOpera(Integer idOpera) {
    this.idOpera = idOpera;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreaEventoOperaRequest creaEventoOperaRequest = (CreaEventoOperaRequest) o;
    return Objects.equals(this.idEvento, creaEventoOperaRequest.idEvento) &&
        Objects.equals(this.idOpera, creaEventoOperaRequest.idOpera);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEvento, idOpera);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreaEventoOperaRequest {\n");
    sb.append("    idEvento: ").append(toIndentedString(idEvento)).append("\n");
    sb.append("    idOpera: ").append(toIndentedString(idOpera)).append("\n");
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

