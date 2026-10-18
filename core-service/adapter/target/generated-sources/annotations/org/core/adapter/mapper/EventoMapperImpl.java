package org.core.adapter.mapper;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.core.adapter.repository.entity.EventoEntity;
import org.core.domain.model.EventoRecord;
import org.openapitools.model.Evento;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-11T21:02:33+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.2.1 (Homebrew)"
)
@Component
public class EventoMapperImpl implements EventoMapper {

    @Override
    public Evento toEvento(EventoRecord eventoRecord) {
        if ( eventoRecord == null ) {
            return null;
        }

        Evento evento = new Evento();

        evento.setIdEvento( eventoRecord.idEvento() );
        evento.setNome( eventoRecord.nome() );
        evento.setNumeroPosti( eventoRecord.numeroPosti() );
        evento.setData( eventoRecord.data() );
        evento.setDurata( eventoRecord.durata() );

        return evento;
    }

    @Override
    public EventoRecord toEventoRecord(Evento evento) {
        if ( evento == null ) {
            return null;
        }

        Integer idEvento = null;
        String nome = null;
        Integer numeroPosti = null;
        LocalDateTime data = null;
        Integer durata = null;

        idEvento = evento.getIdEvento();
        nome = evento.getNome();
        numeroPosti = evento.getNumeroPosti();
        data = evento.getData();
        durata = evento.getDurata();

        EventoRecord eventoRecord = new EventoRecord( idEvento, nome, numeroPosti, data, durata );

        return eventoRecord;
    }

    @Override
    public EventoEntity toEventoEntity(EventoRecord record) {
        if ( record == null ) {
            return null;
        }

        EventoEntity.EventoEntityBuilder eventoEntity = EventoEntity.builder();

        eventoEntity.nome( record.nome() );
        eventoEntity.numeroPosti( record.numeroPosti() );
        eventoEntity.data( record.data() );
        eventoEntity.durata( record.durata() );

        return eventoEntity.build();
    }
}
