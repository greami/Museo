package org.user.service.adapter.mapper;

import javax.annotation.processing.Generated;
import org.openapitools.model.UtenteResponse;
import org.springframework.stereotype.Component;
import org.user.service.adapter.repository.entity.UtenteEntity;
import org.user.service.domain.model.UtenteRecord;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-11T21:02:24+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.2.1 (Homebrew)"
)
@Component
public class UtenteMapperImpl implements UtenteMapper {

    @Override
    public UtenteResponse toUtenteResponse(UtenteRecord utenteRecord) {
        if ( utenteRecord == null ) {
            return null;
        }

        UtenteResponse utenteResponse = new UtenteResponse();

        utenteResponse.setIdUtente( utenteRecord.id() );
        utenteResponse.setNomeUtente( utenteRecord.nomeUtente() );
        utenteResponse.setNome( utenteRecord.nome() );
        utenteResponse.setCognome( utenteRecord.cognome() );
        utenteResponse.setEmail( utenteRecord.email() );

        return utenteResponse;
    }

    @Override
    public UtenteRecord toUtenteRecord(UtenteResponse utenteResponse) {
        if ( utenteResponse == null ) {
            return null;
        }

        Integer id = null;
        String nomeUtente = null;
        String nome = null;
        String cognome = null;
        String email = null;

        id = utenteResponse.getIdUtente();
        nomeUtente = utenteResponse.getNomeUtente();
        nome = utenteResponse.getNome();
        cognome = utenteResponse.getCognome();
        email = utenteResponse.getEmail();

        String password = null;

        UtenteRecord utenteRecord = new UtenteRecord( id, nomeUtente, nome, cognome, email, password );

        return utenteRecord;
    }

    @Override
    public UtenteEntity toUtenteEntity(UtenteRecord utenteRecord) {
        if ( utenteRecord == null ) {
            return null;
        }

        UtenteEntity.UtenteEntityBuilder utenteEntity = UtenteEntity.builder();

        utenteEntity.id( utenteRecord.id() );
        utenteEntity.nomeUtente( utenteRecord.nomeUtente() );
        utenteEntity.nome( utenteRecord.nome() );
        utenteEntity.cognome( utenteRecord.cognome() );
        utenteEntity.email( utenteRecord.email() );
        utenteEntity.password( utenteRecord.password() );

        return utenteEntity.build();
    }
}
