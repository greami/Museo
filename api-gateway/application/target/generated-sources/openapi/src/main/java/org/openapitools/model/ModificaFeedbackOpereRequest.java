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
 * ModificaFeedbackOpereRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-11T21:02:39.028177+02:00[Europe/Rome]")
public class ModificaFeedbackOpereRequest {

  private Integer voto;

  private String note;

  public ModificaFeedbackOpereRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ModificaFeedbackOpereRequest(Integer voto, String note) {
    this.voto = voto;
    this.note = note;
  }

  public ModificaFeedbackOpereRequest voto(Integer voto) {
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

  public ModificaFeedbackOpereRequest note(String note) {
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
    ModificaFeedbackOpereRequest modificaFeedbackOpereRequest = (ModificaFeedbackOpereRequest) o;
    return Objects.equals(this.voto, modificaFeedbackOpereRequest.voto) &&
        Objects.equals(this.note, modificaFeedbackOpereRequest.note);
  }

  @Override
  public int hashCode() {
    return Objects.hash(voto, note);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModificaFeedbackOpereRequest {\n");
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

