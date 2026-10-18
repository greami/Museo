package org.core.adapter.mapper;

import javax.annotation.processing.Generated;
import org.core.adapter.repository.entity.FeedbackEventiEntity;
import org.core.domain.model.FeedbackEventiRecord;
import org.openapitools.model.FeedbackEventi;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-11T21:02:33+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.2.1 (Homebrew)"
)
@Component
public class FeedbackEventiMapperImpl implements FeedbackEventiMapper {

    @Override
    public FeedbackEventi toFeedbackEventi(FeedbackEventiRecord feedbackEventiRecord) {
        if ( feedbackEventiRecord == null ) {
            return null;
        }

        FeedbackEventi feedbackEventi = new FeedbackEventi();

        feedbackEventi.setIdFeedback( feedbackEventiRecord.id() );
        feedbackEventi.setIdUtente( feedbackEventiRecord.idUtente() );
        feedbackEventi.setIdEvento( feedbackEventiRecord.idEvento() );
        feedbackEventi.setVoto( feedbackEventiRecord.voto() );
        feedbackEventi.setNote( feedbackEventiRecord.note() );

        return feedbackEventi;
    }

    @Override
    public FeedbackEventiRecord toFeedbackEventiRecord(FeedbackEventi feedbackEventi) {
        if ( feedbackEventi == null ) {
            return null;
        }

        Integer id = null;
        Integer idUtente = null;
        Integer idEvento = null;
        Integer voto = null;
        String note = null;

        id = feedbackEventi.getIdFeedback();
        idUtente = feedbackEventi.getIdUtente();
        idEvento = feedbackEventi.getIdEvento();
        voto = feedbackEventi.getVoto();
        note = feedbackEventi.getNote();

        FeedbackEventiRecord feedbackEventiRecord = new FeedbackEventiRecord( id, idUtente, idEvento, voto, note );

        return feedbackEventiRecord;
    }

    @Override
    public FeedbackEventiEntity toFeedbackEventiEntity(FeedbackEventiRecord record) {
        if ( record == null ) {
            return null;
        }

        FeedbackEventiEntity.FeedbackEventiEntityBuilder feedbackEventiEntity = FeedbackEventiEntity.builder();

        feedbackEventiEntity.idUtente( record.idUtente() );
        feedbackEventiEntity.idEvento( record.idEvento() );
        feedbackEventiEntity.voto( record.voto() );
        feedbackEventiEntity.note( record.note() );
        feedbackEventiEntity.id( record.id() );

        return feedbackEventiEntity.build();
    }

    @Override
    public FeedbackEventiRecord toFeedbackEventiRecord(FeedbackEventiEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Integer id = null;
        Integer idUtente = null;
        Integer idEvento = null;
        Integer voto = null;
        String note = null;

        id = entity.getId();
        idUtente = entity.getIdUtente();
        idEvento = entity.getIdEvento();
        voto = entity.getVoto();
        note = entity.getNote();

        FeedbackEventiRecord feedbackEventiRecord = new FeedbackEventiRecord( id, idUtente, idEvento, voto, note );

        return feedbackEventiRecord;
    }
}
