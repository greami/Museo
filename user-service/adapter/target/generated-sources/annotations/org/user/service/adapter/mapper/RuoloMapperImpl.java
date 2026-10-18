package org.user.service.adapter.mapper;

import javax.annotation.processing.Generated;
import org.openapitools.model.RuoloResponse;
import org.springframework.stereotype.Component;
import org.user.service.adapter.repository.entity.RuoloEntity;
import org.user.service.domain.model.RuoloRecord;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-11T21:02:25+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.2.1 (Homebrew)"
)
@Component
public class RuoloMapperImpl implements RuoloMapper {

    @Override
    public RuoloResponse toRuoloResponse(RuoloRecord ruoloRecord) {
        if ( ruoloRecord == null ) {
            return null;
        }

        RuoloResponse ruoloResponse = new RuoloResponse();

        if ( ruoloRecord.id() != null ) {
            ruoloResponse.setIdRuolo( ruoloRecord.id().intValue() );
        }
        ruoloResponse.setNome( ruoloRecord.nome() );
        ruoloResponse.setDescrizione( ruoloRecord.descrizione() );

        return ruoloResponse;
    }

    @Override
    public RuoloRecord toRuoloRecord(RuoloResponse ruoloResponse) {
        if ( ruoloResponse == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        String descrizione = null;

        if ( ruoloResponse.getIdRuolo() != null ) {
            id = ruoloResponse.getIdRuolo().longValue();
        }
        nome = ruoloResponse.getNome();
        descrizione = ruoloResponse.getDescrizione();

        RuoloRecord ruoloRecord = new RuoloRecord( id, nome, descrizione );

        return ruoloRecord;
    }

    @Override
    public RuoloEntity toRuoloEntity(RuoloRecord ruoloRecord) {
        if ( ruoloRecord == null ) {
            return null;
        }

        RuoloEntity.RuoloEntityBuilder ruoloEntity = RuoloEntity.builder();

        if ( ruoloRecord.id() != null ) {
            ruoloEntity.id( ruoloRecord.id().intValue() );
        }
        ruoloEntity.nome( ruoloRecord.nome() );
        ruoloEntity.descrizione( ruoloRecord.descrizione() );

        return ruoloEntity.build();
    }
}
