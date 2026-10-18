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
 * PrenotazioniDisponibiliEvento
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-11T21:02:32.013908+02:00[Europe/Rome]")
public class PrenotazioniDisponibiliEvento {

  private Integer idEvento;

  private Integer numeroPostiTotali;

  private Integer numeroPostiDispobili;

  public PrenotazioniDisponibiliEvento() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PrenotazioniDisponibiliEvento(Integer idEvento, Integer numeroPostiTotali, Integer numeroPostiDispobili) {
    this.idEvento = idEvento;
    this.numeroPostiTotali = numeroPostiTotali;
    this.numeroPostiDispobili = numeroPostiDispobili;
  }

  public PrenotazioniDisponibiliEvento idEvento(Integer idEvento) {
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

  public PrenotazioniDisponibiliEvento numeroPostiTotali(Integer numeroPostiTotali) {
    this.numeroPostiTotali = numeroPostiTotali;
    return this;
  }

  /**
   * Get numeroPostiTotali
   * minimum: 0
   * @return numeroPostiTotali
  */
  @NotNull @Min(0) 
  @Schema(name = "numeroPostiTotali", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("numeroPostiTotali")
  public Integer getNumeroPostiTotali() {
    return numeroPostiTotali;
  }

  public void setNumeroPostiTotali(Integer numeroPostiTotali) {
    this.numeroPostiTotali = numeroPostiTotali;
  }

  public PrenotazioniDisponibiliEvento numeroPostiDispobili(Integer numeroPostiDispobili) {
    this.numeroPostiDispobili = numeroPostiDispobili;
    return this;
  }

  /**
   * Get numeroPostiDispobili
   * minimum: 0
   * @return numeroPostiDispobili
  */
  @NotNull @Min(0) 
  @Schema(name = "numeroPostiDispobili", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("numeroPostiDispobili")
  public Integer getNumeroPostiDispobili() {
    return numeroPostiDispobili;
  }

  public void setNumeroPostiDispobili(Integer numeroPostiDispobili) {
    this.numeroPostiDispobili = numeroPostiDispobili;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrenotazioniDisponibiliEvento prenotazioniDisponibiliEvento = (PrenotazioniDisponibiliEvento) o;
    return Objects.equals(this.idEvento, prenotazioniDisponibiliEvento.idEvento) &&
        Objects.equals(this.numeroPostiTotali, prenotazioniDisponibiliEvento.numeroPostiTotali) &&
        Objects.equals(this.numeroPostiDispobili, prenotazioniDisponibiliEvento.numeroPostiDispobili);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEvento, numeroPostiTotali, numeroPostiDispobili);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PrenotazioniDisponibiliEvento {\n");
    sb.append("    idEvento: ").append(toIndentedString(idEvento)).append("\n");
    sb.append("    numeroPostiTotali: ").append(toIndentedString(numeroPostiTotali)).append("\n");
    sb.append("    numeroPostiDispobili: ").append(toIndentedString(numeroPostiDispobili)).append("\n");
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

