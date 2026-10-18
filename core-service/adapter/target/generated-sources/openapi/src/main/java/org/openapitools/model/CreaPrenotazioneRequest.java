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
 * CreaPrenotazioneRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-11T21:02:32.013908+02:00[Europe/Rome]")
public class CreaPrenotazioneRequest {

  private Integer idUtente;

  private Integer idEvento;

  private Integer numeroPartecipanti;

  public CreaPrenotazioneRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreaPrenotazioneRequest(Integer idUtente, Integer idEvento, Integer numeroPartecipanti) {
    this.idUtente = idUtente;
    this.idEvento = idEvento;
    this.numeroPartecipanti = numeroPartecipanti;
  }

  public CreaPrenotazioneRequest idUtente(Integer idUtente) {
    this.idUtente = idUtente;
    return this;
  }

  /**
   * Get idUtente
   * minimum: 1000
   * @return idUtente
  */
  @NotNull @Min(1000) 
  @Schema(name = "idUtente", example = "123456789", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idUtente")
  public Integer getIdUtente() {
    return idUtente;
  }

  public void setIdUtente(Integer idUtente) {
    this.idUtente = idUtente;
  }

  public CreaPrenotazioneRequest idEvento(Integer idEvento) {
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

  public CreaPrenotazioneRequest numeroPartecipanti(Integer numeroPartecipanti) {
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
    CreaPrenotazioneRequest creaPrenotazioneRequest = (CreaPrenotazioneRequest) o;
    return Objects.equals(this.idUtente, creaPrenotazioneRequest.idUtente) &&
        Objects.equals(this.idEvento, creaPrenotazioneRequest.idEvento) &&
        Objects.equals(this.numeroPartecipanti, creaPrenotazioneRequest.numeroPartecipanti);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idUtente, idEvento, numeroPartecipanti);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreaPrenotazioneRequest {\n");
    sb.append("    idUtente: ").append(toIndentedString(idUtente)).append("\n");
    sb.append("    idEvento: ").append(toIndentedString(idEvento)).append("\n");
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

