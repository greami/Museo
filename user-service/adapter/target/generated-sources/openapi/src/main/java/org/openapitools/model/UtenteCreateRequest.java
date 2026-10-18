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
 * UtenteCreateRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-11T21:02:24.189691+02:00[Europe/Rome]")
public class UtenteCreateRequest {

  private String nomeUtente;

  private String nome;

  private String cognome;

  private String email;

  private String password;

  public UtenteCreateRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UtenteCreateRequest(String nomeUtente, String nome, String cognome, String email, String password) {
    this.nomeUtente = nomeUtente;
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.password = password;
  }

  public UtenteCreateRequest nomeUtente(String nomeUtente) {
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

  public UtenteCreateRequest nome(String nome) {
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

  public UtenteCreateRequest cognome(String cognome) {
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

  public UtenteCreateRequest email(String email) {
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

  public UtenteCreateRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  @NotNull @Size(min = 1, max = 255) 
  @Schema(name = "password", example = "pwd01", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UtenteCreateRequest utenteCreateRequest = (UtenteCreateRequest) o;
    return Objects.equals(this.nomeUtente, utenteCreateRequest.nomeUtente) &&
        Objects.equals(this.nome, utenteCreateRequest.nome) &&
        Objects.equals(this.cognome, utenteCreateRequest.cognome) &&
        Objects.equals(this.email, utenteCreateRequest.email) &&
        Objects.equals(this.password, utenteCreateRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nomeUtente, nome, cognome, email, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UtenteCreateRequest {\n");
    sb.append("    nomeUtente: ").append(toIndentedString(nomeUtente)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

