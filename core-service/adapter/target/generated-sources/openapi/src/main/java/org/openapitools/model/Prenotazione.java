package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Prenotazione
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-11T21:02:32.013908+02:00[Europe/Rome]")
public class Prenotazione {

  private Integer idPrenotazione;

  private Integer idUtente;

  private Integer idEvento;

  private Integer numeroPartecipanti;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime dataCreazione;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime dataUltimaModifica;

  public Prenotazione() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Prenotazione(Integer idPrenotazione, Integer idUtente, Integer idEvento, Integer numeroPartecipanti, LocalDateTime dataCreazione, LocalDateTime dataUltimaModifica) {
    this.idPrenotazione = idPrenotazione;
    this.idUtente = idUtente;
    this.idEvento = idEvento;
    this.numeroPartecipanti = numeroPartecipanti;
    this.dataCreazione = dataCreazione;
    this.dataUltimaModifica = dataUltimaModifica;
  }

  public Prenotazione idPrenotazione(Integer idPrenotazione) {
    this.idPrenotazione = idPrenotazione;
    return this;
  }

  /**
   * Get idPrenotazione
   * minimum: 1000
   * @return idPrenotazione
  */
  @NotNull @Min(1000) 
  @Schema(name = "idPrenotazione", example = "123456789", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idPrenotazione")
  public Integer getIdPrenotazione() {
    return idPrenotazione;
  }

  public void setIdPrenotazione(Integer idPrenotazione) {
    this.idPrenotazione = idPrenotazione;
  }

  public Prenotazione idUtente(Integer idUtente) {
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

  public Prenotazione idEvento(Integer idEvento) {
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

  public Prenotazione numeroPartecipanti(Integer numeroPartecipanti) {
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

  public Prenotazione dataCreazione(LocalDateTime dataCreazione) {
    this.dataCreazione = dataCreazione;
    return this;
  }

  /**
   * Get dataCreazione
   * @return dataCreazione
  */
  @NotNull @Valid 
  @Schema(name = "dataCreazione", example = "2024-06-01T12:00Z", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dataCreazione")
  public LocalDateTime getDataCreazione() {
    return dataCreazione;
  }

  public void setDataCreazione(LocalDateTime dataCreazione) {
    this.dataCreazione = dataCreazione;
  }

  public Prenotazione dataUltimaModifica(LocalDateTime dataUltimaModifica) {
    this.dataUltimaModifica = dataUltimaModifica;
    return this;
  }

  /**
   * Get dataUltimaModifica
   * @return dataUltimaModifica
  */
  @NotNull @Valid 
  @Schema(name = "dataUltimaModifica", example = "2024-06-01T12:00Z", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dataUltimaModifica")
  public LocalDateTime getDataUltimaModifica() {
    return dataUltimaModifica;
  }

  public void setDataUltimaModifica(LocalDateTime dataUltimaModifica) {
    this.dataUltimaModifica = dataUltimaModifica;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Prenotazione prenotazione = (Prenotazione) o;
    return Objects.equals(this.idPrenotazione, prenotazione.idPrenotazione) &&
        Objects.equals(this.idUtente, prenotazione.idUtente) &&
        Objects.equals(this.idEvento, prenotazione.idEvento) &&
        Objects.equals(this.numeroPartecipanti, prenotazione.numeroPartecipanti) &&
        Objects.equals(this.dataCreazione, prenotazione.dataCreazione) &&
        Objects.equals(this.dataUltimaModifica, prenotazione.dataUltimaModifica);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPrenotazione, idUtente, idEvento, numeroPartecipanti, dataCreazione, dataUltimaModifica);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Prenotazione {\n");
    sb.append("    idPrenotazione: ").append(toIndentedString(idPrenotazione)).append("\n");
    sb.append("    idUtente: ").append(toIndentedString(idUtente)).append("\n");
    sb.append("    idEvento: ").append(toIndentedString(idEvento)).append("\n");
    sb.append("    numeroPartecipanti: ").append(toIndentedString(numeroPartecipanti)).append("\n");
    sb.append("    dataCreazione: ").append(toIndentedString(dataCreazione)).append("\n");
    sb.append("    dataUltimaModifica: ").append(toIndentedString(dataUltimaModifica)).append("\n");
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

