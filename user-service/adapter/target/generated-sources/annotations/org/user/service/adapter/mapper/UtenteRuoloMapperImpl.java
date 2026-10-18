package org.user.service.adapter.mapper;

import javax.annotation.processing.Generated;
import org.openapitools.model.UtenteRuoloResponse;
import org.springframework.stereotype.Component;
import org.user.service.adapter.repository.entity.UtenteRuoloEntity;
import org.user.service.domain.model.UtenteRuoloRecord;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-11T21:02:25+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.2.1 (Homebrew)"
)
@Component
public class UtenteRuoloMapperImpl implements UtenteRuoloMapper {

    @Override
    public UtenteRuoloResponse toUtenteRuoloResponse(UtenteRuoloRecord utenteRuoloRecord) {
        if ( utenteRuoloRecord == null ) {
            return null;
        }

        UtenteRuoloResponse utenteRuoloResponse = new UtenteRuoloResponse();

        if ( utenteRuoloRecord.id() != null ) {
            utenteRuoloResponse.setIdUtenteRuolo( utenteRuoloRecord.id().intValue() );
        }
        if ( utenteRuoloRecord.idUtente() != null ) {
            utenteRuoloResponse.setIdUtente( utenteRuoloRecord.idUtente().intValue() );
        }
        if ( utenteRuoloRecord.idRuolo() != null ) {
            utenteRuoloResponse.setIdRuolo( utenteRuoloRecord.idRuolo().intValue() );
        }

        return utenteRuoloResponse;
    }

    @Override
    public UtenteRuoloRecord toUtenteRuoloRecord(UtenteRuoloResponse utenteRuoloResponse) {
        if ( utenteRuoloResponse == null ) {
            return null;
        }

        Long id = null;
        Long idUtente = null;
        Long idRuolo = null;

        if ( utenteRuoloResponse.getIdUtenteRuolo() != null ) {
            id = utenteRuoloResponse.getIdUtenteRuolo().longValue();
        }
        if ( utenteRuoloResponse.getIdUtente() != null ) {
            idUtente = utenteRuoloResponse.getIdUtente().longValue();
        }
        if ( utenteRuoloResponse.getIdRuolo() != null ) {
            idRuolo = utenteRuoloResponse.getIdRuolo().longValue();
        }

        UtenteRuoloRecord utenteRuoloRecord = new UtenteRuoloRecord( id, idUtente, idRuolo );

        return utenteRuoloRecord;
    }

    @Override
    public UtenteRuoloEntity toUtenteRuoloEntity(UtenteRuoloRecord utenteRuoloRecord) {
        if ( utenteRuoloRecord == null ) {
            return null;
        }

        UtenteRuoloEntity.UtenteRuoloEntityBuilder utenteRuoloEntity = UtenteRuoloEntity.builder();

        if ( utenteRuoloRecord.id() != null ) {
            utenteRuoloEntity.id( utenteRuoloRecord.id().intValue() );
        }
        utenteRuoloEntity.idUtente( utenteRuoloRecord.idUtente() );
        utenteRuoloEntity.idRuolo( utenteRuoloRecord.idRuolo() );

        return utenteRuoloEntity.build();
    }
}
