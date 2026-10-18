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
 * RuoloUpdateRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-11T21:02:38.874217+02:00[Europe/Rome]")
public class RuoloUpdateRequest {

  private String nome;

  private String descrizione;

  private Integer idRuolo;

  public RuoloUpdateRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RuoloUpdateRequest(String nome, String descrizione, Integer idRuolo) {
    this.nome = nome;
    this.descrizione = descrizione;
    this.idRuolo = idRuolo;
  }

  public RuoloUpdateRequest nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
  */
  @NotNull @Size(max = 100) 
  @Schema(name = "nome", example = "standard", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public RuoloUpdateRequest descrizione(String descrizione) {
    this.descrizione = descrizione;
    return this;
  }

  /**
   * Get descrizione
   * @return descrizione
  */
  @NotNull @Size(max = 255) 
  @Schema(name = "descrizione", example = "Utente standard", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("descrizione")
  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public RuoloUpdateRequest idRuolo(Integer idRuolo) {
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
    RuoloUpdateRequest ruoloUpdateRequest = (RuoloUpdateRequest) o;
    return Objects.equals(this.nome, ruoloUpdateRequest.nome) &&
        Objects.equals(this.descrizione, ruoloUpdateRequest.descrizione) &&
        Objects.equals(this.idRuolo, ruoloUpdateRequest.idRuolo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, descrizione, idRuolo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RuoloUpdateRequest {\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
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

