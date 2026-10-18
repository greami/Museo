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
 * CreaEventoRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-11T21:02:39.028177+02:00[Europe/Rome]")
public class CreaEventoRequest {

  private Integer numeroPosti;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime data;

  private Integer durata;

  private String nome;

  public CreaEventoRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreaEventoRequest(Integer numeroPosti, LocalDateTime data, Integer durata, String nome) {
    this.numeroPosti = numeroPosti;
    this.data = data;
    this.durata = durata;
    this.nome = nome;
  }

  public CreaEventoRequest numeroPosti(Integer numeroPosti) {
    this.numeroPosti = numeroPosti;
    return this;
  }

  /**
   * Get numeroPosti
   * @return numeroPosti
  */
  @NotNull 
  @Schema(name = "numeroPosti", example = "30", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("numeroPosti")
  public Integer getNumeroPosti() {
    return numeroPosti;
  }

  public void setNumeroPosti(Integer numeroPosti) {
    this.numeroPosti = numeroPosti;
  }

  public CreaEventoRequest data(LocalDateTime data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @NotNull @Valid 
  @Schema(name = "data", example = "2026-07-27T10:30Z", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("data")
  public LocalDateTime getData() {
    return data;
  }

  public void setData(LocalDateTime data) {
    this.data = data;
  }

  public CreaEventoRequest durata(Integer durata) {
    this.durata = durata;
    return this;
  }

  /**
   * Get durata
   * @return durata
  */
  @NotNull 
  @Schema(name = "durata", example = "8", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("durata")
  public Integer getDurata() {
    return durata;
  }

  public void setDurata(Integer durata) {
    this.durata = durata;
  }

  public CreaEventoRequest nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
  */
  @NotNull @Size(min = 1000) 
  @Schema(name = "Nome", example = "123456789", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("Nome")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreaEventoRequest creaEventoRequest = (CreaEventoRequest) o;
    return Objects.equals(this.numeroPosti, creaEventoRequest.numeroPosti) &&
        Objects.equals(this.data, creaEventoRequest.data) &&
        Objects.equals(this.durata, creaEventoRequest.durata) &&
        Objects.equals(this.nome, creaEventoRequest.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numeroPosti, data, durata, nome);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreaEventoRequest {\n");
    sb.append("    numeroPosti: ").append(toIndentedString(numeroPosti)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    durata: ").append(toIndentedString(durata)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
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

