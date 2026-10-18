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
 * Opera
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-11T21:02:32.212102+02:00[Europe/Rome]")
public class Opera {

  private Integer idOpera;

  private String nome;

  private String autore;

  private Integer tipo;

  public Opera() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Opera(Integer idOpera, String nome, String autore, Integer tipo) {
    this.idOpera = idOpera;
    this.nome = nome;
    this.autore = autore;
    this.tipo = tipo;
  }

  public Opera idOpera(Integer idOpera) {
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

  public Opera nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
  */
  @NotNull @Size(min = 1) 
  @Schema(name = "nome", example = "Guernica", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Opera autore(String autore) {
    this.autore = autore;
    return this;
  }

  /**
   * Get autore
   * @return autore
  */
  @NotNull 
  @Schema(name = "autore", example = "Italo Calvino", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("autore")
  public String getAutore() {
    return autore;
  }

  public void setAutore(String autore) {
    this.autore = autore;
  }

  public Opera tipo(Integer tipo) {
    this.tipo = tipo;
    return this;
  }

  /**
   * Get tipo
   * @return tipo
  */
  @NotNull 
  @Schema(name = "tipo", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tipo")
  public Integer getTipo() {
    return tipo;
  }

  public void setTipo(Integer tipo) {
    this.tipo = tipo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Opera opera = (Opera) o;
    return Objects.equals(this.idOpera, opera.idOpera) &&
        Objects.equals(this.nome, opera.nome) &&
        Objects.equals(this.autore, opera.autore) &&
        Objects.equals(this.tipo, opera.tipo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idOpera, nome, autore, tipo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Opera {\n");
    sb.append("    idOpera: ").append(toIndentedString(idOpera)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    autore: ").append(toIndentedString(autore)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
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

