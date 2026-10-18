package org.core.adapter.mapper;

import javax.annotation.processing.Generated;
import org.core.adapter.repository.entity.FeedbackOpereEntity;
import org.core.domain.model.FeedbackOpereRecord;
import org.openapitools.model.FeedbackOpere;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-11T21:02:33+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.2.1 (Homebrew)"
)
@Component
public class FeedbackOpereMapperImpl implements FeedbackOpereMapper {

    @Override
    public FeedbackOpere toFeedbackOpere(FeedbackOpereRecord feedbackOpereRecord) {
        if ( feedbackOpereRecord == null ) {
            return null;
        }

        FeedbackOpere feedbackOpere = new FeedbackOpere();

        feedbackOpere.setIdFeedback( feedbackOpereRecord.id() );
        feedbackOpere.setIdUtente( feedbackOpereRecord.idUtente() );
        feedbackOpere.setIdOpera( feedbackOpereRecord.idOpera() );
        feedbackOpere.setVoto( feedbackOpereRecord.voto() );
        feedbackOpere.setNote( feedbackOpereRecord.note() );

        return feedbackOpere;
    }

    @Override
    public FeedbackOpereRecord toFeedbackOpereRecord(FeedbackOpere feedbackOpere) {
        if ( feedbackOpere == null ) {
            return null;
        }

        Integer id = null;
        Integer idUtente = null;
        Integer idOpera = null;
        Integer voto = null;
        String note = null;

        id = feedbackOpere.getIdFeedback();
        idUtente = feedbackOpere.getIdUtente();
        idOpera = feedbackOpere.getIdOpera();
        voto = feedbackOpere.getVoto();
        note = feedbackOpere.getNote();

        FeedbackOpereRecord feedbackOpereRecord = new FeedbackOpereRecord( id, idUtente, idOpera, voto, note );

        return feedbackOpereRecord;
    }

    @Override
    public FeedbackOpereEntity toFeedbackOpereEntity(FeedbackOpereRecord record) {
        if ( record == null ) {
            return null;
        }

        FeedbackOpereEntity.FeedbackOpereEntityBuilder feedbackOpereEntity = FeedbackOpereEntity.builder();

        feedbackOpereEntity.idUtente( record.idUtente() );
        feedbackOpereEntity.idOpera( record.idOpera() );
        feedbackOpereEntity.voto( record.voto() );
        feedbackOpereEntity.note( record.note() );
        feedbackOpereEntity.id( record.id() );

        return feedbackOpereEntity.build();
    }

    @Override
    public FeedbackOpereRecord toFeedbackOpereRecord(FeedbackOpereEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Integer id = null;
        Integer idUtente = null;
        Integer idOpera = null;
        Integer voto = null;
        String note = null;

        id = entity.getId();
        idUtente = entity.getIdUtente();
        idOpera = entity.getIdOpera();
        voto = entity.getVoto();
        note = entity.getNote();

        FeedbackOpereRecord feedbackOpereRecord = new FeedbackOpereRecord( id, idUtente, idOpera, voto, note );

        return feedbackOpereRecord;
    }
}
