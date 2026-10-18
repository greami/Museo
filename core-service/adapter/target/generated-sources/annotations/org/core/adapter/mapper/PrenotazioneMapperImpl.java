package org.core.adapter.mapper;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.core.adapter.repository.entity.PrenotazioneEntity;
import org.core.domain.model.PrenotazioneRecord;
import org.openapitools.model.Prenotazione;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-11T21:02:33+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.2.1 (Homebrew)"
)
@Component
public class PrenotazioneMapperImpl implements PrenotazioneMapper {

    @Override
    public Prenotazione toPrenotazione(PrenotazioneRecord prenotazioneRecord) {
        if ( prenotazioneRecord == null ) {
            return null;
        }

        Prenotazione prenotazione = new Prenotazione();

        prenotazione.setIdPrenotazione( prenotazioneRecord.id() );
        prenotazione.setIdUtente( prenotazioneRecord.idUtente() );
        prenotazione.setIdEvento( prenotazioneRecord.idEvento() );
        prenotazione.setNumeroPartecipanti( prenotazioneRecord.numeroPosti() );
        prenotazione.setDataCreazione( prenotazioneRecord.dataPrenotazione() );
        prenotazione.setDataUltimaModifica( prenotazioneRecord.dataModifica() );

        return prenotazione;
    }

    @Override
    public PrenotazioneRecord toPrenotazioneRecord(Prenotazione prenotazione) {
        if ( prenotazione == null ) {
            return null;
        }

        Integer id = null;
        Integer idUtente = null;
        Integer idEvento = null;
        Integer numeroPosti = null;
        LocalDateTime dataPrenotazione = null;
        LocalDateTime dataModifica = null;

        id = prenotazione.getIdPrenotazione();
        idUtente = prenotazione.getIdUtente();
        idEvento = prenotazione.getIdEvento();
        numeroPosti = prenotazione.getNumeroPartecipanti();
        dataPrenotazione = prenotazione.getDataCreazione();
        dataModifica = prenotazione.getDataUltimaModifica();

        PrenotazioneRecord prenotazioneRecord = new PrenotazioneRecord( id, idUtente, idEvento, numeroPosti, dataPrenotazione, dataModifica );

        return prenotazioneRecord;
    }

    @Override
    public PrenotazioneEntity toPrenotazioneEntity(PrenotazioneRecord record) {
        if ( record == null ) {
            return null;
        }

        PrenotazioneEntity.PrenotazioneEntityBuilder prenotazioneEntity = PrenotazioneEntity.builder();

        prenotazioneEntity.idUtente( record.idUtente() );
        prenotazioneEntity.idEvento( record.idEvento() );
        prenotazioneEntity.numeroPosti( record.numeroPosti() );
        prenotazioneEntity.dataPrenotazione( record.dataPrenotazione() );
        prenotazioneEntity.dataModifica( record.dataModifica() );
        prenotazioneEntity.id( record.id() );

        return prenotazioneEntity.build();
    }
}
