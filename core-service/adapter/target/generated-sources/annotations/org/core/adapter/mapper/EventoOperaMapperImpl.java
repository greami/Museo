package org.core.adapter.mapper;

import javax.annotation.processing.Generated;
import org.core.adapter.repository.entity.EventoOperaEntity;
import org.core.domain.model.EventoOperaRecord;
import org.openapitools.model.EventoOpera;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-11T21:02:33+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.2.1 (Homebrew)"
)
@Component
public class EventoOperaMapperImpl implements EventoOperaMapper {

    @Override
    public EventoOpera toEventoOpera(EventoOperaRecord eventoOperaRecord) {
        if ( eventoOperaRecord == null ) {
            return null;
        }

        EventoOpera eventoOpera = new EventoOpera();

        eventoOpera.setIdEvento( eventoOperaRecord.idEvento() );
        eventoOpera.setIdOpera( eventoOperaRecord.idOpera() );

        return eventoOpera;
    }

    @Override
    public EventoOperaRecord toEventoOperaRecord(EventoOpera eventoOpera) {
        if ( eventoOpera == null ) {
            return null;
        }

        Integer idEvento = null;
        Integer idOpera = null;

        idEvento = eventoOpera.getIdEvento();
        idOpera = eventoOpera.getIdOpera();

        EventoOperaRecord eventoOperaRecord = new EventoOperaRecord( idEvento, idOpera );

        return eventoOperaRecord;
    }

    @Override
    public EventoOperaEntity toEventoOperaEntity(EventoOperaRecord record) {
        if ( record == null ) {
            return null;
        }

        EventoOperaEntity.EventoOperaEntityBuilder eventoOperaEntity = EventoOperaEntity.builder();

        eventoOperaEntity.idEvento( record.idEvento() );
        eventoOperaEntity.idOpera( record.idOpera() );

        return eventoOperaEntity.build();
    }

    @Override
    public EventoOperaRecord toEventoOperaRecord(EventoOperaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Integer idEvento = null;
        Integer idOpera = null;

        idEvento = entity.getIdEvento();
        idOpera = entity.getIdOpera();

        EventoOperaRecord eventoOperaRecord = new EventoOperaRecord( idEvento, idOpera );

        return eventoOperaRecord;
    }
}
