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
 * RuoloBase
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-11T21:02:38.874217+02:00[Europe/Rome]")
public class RuoloBase {

  private String nome;

  private String descrizione;

  public RuoloBase() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RuoloBase(String nome, String descrizione) {
    this.nome = nome;
    this.descrizione = descrizione;
  }

  public RuoloBase nome(String nome) {
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

  public RuoloBase descrizione(String descrizione) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RuoloBase ruoloBase = (RuoloBase) o;
    return Objects.equals(this.nome, ruoloBase.nome) &&
        Objects.equals(this.descrizione, ruoloBase.descrizione);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, descrizione);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RuoloBase {\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
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

