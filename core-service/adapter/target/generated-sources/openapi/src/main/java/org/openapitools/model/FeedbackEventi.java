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
 * FeedbackEventi
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-11T21:02:32.282514+02:00[Europe/Rome]")
public class FeedbackEventi {

  private Integer idFeedback;

  private Integer idUtente;

  private Integer idEvento;

  private Integer voto;

  private String note;

  public FeedbackEventi() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FeedbackEventi(Integer idFeedback, Integer idUtente, Integer idEvento, Integer voto, String note) {
    this.idFeedback = idFeedback;
    this.idUtente = idUtente;
    this.idEvento = idEvento;
    this.voto = voto;
    this.note = note;
  }

  public FeedbackEventi idFeedback(Integer idFeedback) {
    this.idFeedback = idFeedback;
    return this;
  }

  /**
   * Get idFeedback
   * minimum: 1000
   * @return idFeedback
  */
  @NotNull @Min(1000) 
  @Schema(name = "idFeedback", example = "123456789", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idFeedback")
  public Integer getIdFeedback() {
    return idFeedback;
  }

  public void setIdFeedback(Integer idFeedback) {
    this.idFeedback = idFeedback;
  }

  public FeedbackEventi idUtente(Integer idUtente) {
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

  public FeedbackEventi idEvento(Integer idEvento) {
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

  public FeedbackEventi voto(Integer voto) {
    this.voto = voto;
    return this;
  }

  /**
   * Get voto
   * minimum: 1
   * maximum: 5
   * @return voto
  */
  @NotNull @Min(1) @Max(5) 
  @Schema(name = "voto", example = "5", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("voto")
  public Integer getVoto() {
    return voto;
  }

  public void setVoto(Integer voto) {
    this.voto = voto;
  }

  public FeedbackEventi note(String note) {
    this.note = note;
    return this;
  }

  /**
   * Get note
   * @return note
  */
  @NotNull @Size(min = 1) 
  @Schema(name = "note", example = "Analisi curata e molto utile.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("note")
  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FeedbackEventi feedbackEventi = (FeedbackEventi) o;
    return Objects.equals(this.idFeedback, feedbackEventi.idFeedback) &&
        Objects.equals(this.idUtente, feedbackEventi.idUtente) &&
        Objects.equals(this.idEvento, feedbackEventi.idEvento) &&
        Objects.equals(this.voto, feedbackEventi.voto) &&
        Objects.equals(this.note, feedbackEventi.note);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idFeedback, idUtente, idEvento, voto, note);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FeedbackEventi {\n");
    sb.append("    idFeedback: ").append(toIndentedString(idFeedback)).append("\n");
    sb.append("    idUtente: ").append(toIndentedString(idUtente)).append("\n");
    sb.append("    idEvento: ").append(toIndentedString(idEvento)).append("\n");
    sb.append("    voto: ").append(toIndentedString(voto)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
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

