package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.RuoloResponse;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UtenteConRuoliResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-10-11T21:02:38.874217+02:00[Europe/Rome]")
public class UtenteConRuoliResponse {

  private String nomeUtente;

  private String nome;

  private String cognome;

  private String email;

  private Integer idUtente;

  @Valid
  private List<@Valid RuoloResponse> ruoli = new ArrayList<>();

  private String password;

  public UtenteConRuoliResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UtenteConRuoliResponse(String nomeUtente, String nome, String cognome, String email, Integer idUtente, List<@Valid RuoloResponse> ruoli, String password) {
    this.nomeUtente = nomeUtente;
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.idUtente = idUtente;
    this.ruoli = ruoli;
    this.password = password;
  }

  public UtenteConRuoliResponse nomeUtente(String nomeUtente) {
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

  public UtenteConRuoliResponse nome(String nome) {
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

  public UtenteConRuoliResponse cognome(String cognome) {
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

  public UtenteConRuoliResponse email(String email) {
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

  public UtenteConRuoliResponse idUtente(Integer idUtente) {
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

  public UtenteConRuoliResponse ruoli(List<@Valid RuoloResponse> ruoli) {
    this.ruoli = ruoli;
    return this;
  }

  public UtenteConRuoliResponse addRuoliItem(RuoloResponse ruoliItem) {
    if (this.ruoli == null) {
      this.ruoli = new ArrayList<>();
    }
    this.ruoli.add(ruoliItem);
    return this;
  }

  /**
   * Get ruoli
   * @return ruoli
  */
  @NotNull @Valid 
  @Schema(name = "ruoli", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("ruoli")
  public List<@Valid RuoloResponse> getRuoli() {
    return ruoli;
  }

  public void setRuoli(List<@Valid RuoloResponse> ruoli) {
    this.ruoli = ruoli;
  }

  public UtenteConRuoliResponse password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  @NotNull @Size(max = 255) 
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
    UtenteConRuoliResponse utenteConRuoliResponse = (UtenteConRuoliResponse) o;
    return Objects.equals(this.nomeUtente, utenteConRuoliResponse.nomeUtente) &&
        Objects.equals(this.nome, utenteConRuoliResponse.nome) &&
        Objects.equals(this.cognome, utenteConRuoliResponse.cognome) &&
        Objects.equals(this.email, utenteConRuoliResponse.email) &&
        Objects.equals(this.idUtente, utenteConRuoliResponse.idUtente) &&
        Objects.equals(this.ruoli, utenteConRuoliResponse.ruoli) &&
        Objects.equals(this.password, utenteConRuoliResponse.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nomeUtente, nome, cognome, email, idUtente, ruoli, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UtenteConRuoliResponse {\n");
    sb.append("    nomeUtente: ").append(toIndentedString(nomeUtente)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    idUtente: ").append(toIndentedString(idUtente)).append("\n");
    sb.append("    ruoli: ").append(toIndentedString(ruoli)).append("\n");
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

