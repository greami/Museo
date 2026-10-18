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
 * UtenteResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-11T21:02:24.189691+02:00[Europe/Rome]")
public class UtenteResponse {

  private String nomeUtente;

  private String nome;

  private String cognome;

  private String email;

  private Integer idUtente;

  public UtenteResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UtenteResponse(String nomeUtente, String nome, String cognome, String email, Integer idUtente) {
    this.nomeUtente = nomeUtente;
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.idUtente = idUtente;
  }

  public UtenteResponse nomeUtente(String nomeUtente) {
    this.nomeUtente = nomeUtente;
    return this;
  }

  /**
   * Get nomeUtente
   * @return nomeUtente
  */
  @NotNull @Size(max = 50) 
  @Schema(name = "nomeUtente", example = "user01", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nomeUtente")
  public String getNomeUtente() {
    return nomeUtente;
  }

  public void setNomeUtente(String nomeUtente) {
    this.nomeUtente = nomeUtente;
  }

  public UtenteResponse nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
  */
  @NotNull @Size(max = 50) 
  @Schema(name = "nome", example = "Luca", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public UtenteResponse cognome(String cognome) {
    this.cognome = cognome;
    return this;
  }

  /**
   * Get cognome
   * @return cognome
  */
  @NotNull @Size(max = 50) 
  @Schema(name = "cognome", example = "Rossi", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cognome")
  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public UtenteResponse email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @NotNull @Size(max = 100) @jakarta.validation.constraints.Email
  @Schema(name = "email", example = "user01@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UtenteResponse idUtente(Integer idUtente) {
    this.idUtente = idUtente;
    return this;
  }

  /**
   * Get idUtente
   * minimum: 1
   * @return idUtente
  */
  @NotNull @Min(1) 
  @Schema(name = "idUtente", example = "5000", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idUtente")
  public Integer getIdUtente() {
    return idUtente;
  }

  public void setIdUtente(Integer idUtente) {
    this.idUtente = idUtente;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UtenteResponse utenteResponse = (UtenteResponse) o;
    return Objects.equals(this.nomeUtente, utenteResponse.nomeUtente) &&
        Objects.equals(this.nome, utenteResponse.nome) &&
        Objects.equals(this.cognome, utenteResponse.cognome) &&
        Objects.equals(this.email, utenteResponse.email) &&
        Objects.equals(this.idUtente, utenteResponse.idUtente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nomeUtente, nome, cognome, email, idUtente);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UtenteResponse {\n");
    sb.append("    nomeUtente: ").append(toIndentedString(nomeUtente)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    idUtente: ").append(toIndentedString(idUtente)).append("\n");
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

