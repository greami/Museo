package org.core.adapter.mapper;

import javax.annotation.processing.Generated;
import org.core.adapter.repository.entity.OperaEntity;
import org.core.domain.model.OperaRecord;
import org.openapitools.model.Opera;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-11T21:02:33+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.2.1 (Homebrew)"
)
@Component
public class OperaMapperImpl implements OperaMapper {

    @Override
    public Opera toOpera(OperaRecord operaRecord) {
        if ( operaRecord == null ) {
            return null;
        }

        Opera opera = new Opera();

        opera.setIdOpera( operaRecord.idOpera() );
        opera.setNome( operaRecord.nome() );
        opera.setAutore( operaRecord.autore() );
        opera.setTipo( operaRecord.tipo() );

        return opera;
    }

    @Override
    public OperaRecord toOperaRecord(Opera opera) {
        if ( opera == null ) {
            return null;
        }

        Integer idOpera = null;
        String nome = null;
        String autore = null;
        Integer tipo = null;

        idOpera = opera.getIdOpera();
        nome = opera.getNome();
        autore = opera.getAutore();
        tipo = opera.getTipo();

        OperaRecord operaRecord = new OperaRecord( idOpera, nome, autore, tipo );

        return operaRecord;
    }

    @Override
    public OperaEntity toOperaEntity(OperaRecord record) {
        if ( record == null ) {
            return null;
        }

        OperaEntity.OperaEntityBuilder operaEntity = OperaEntity.builder();

        operaEntity.nome( record.nome() );
        operaEntity.autore( record.autore() );
        operaEntity.tipo( record.tipo() );

        return operaEntity.build();
    }

    @Override
    public OperaRecord toOperaRecord(OperaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Integer idOpera = null;
        String nome = null;
        String autore = null;
        Integer tipo = null;

        idOpera = entity.getId();
        nome = entity.getNome();
        autore = entity.getAutore();
        tipo = entity.getTipo();

        OperaRecord operaRecord = new OperaRecord( idOpera, nome, autore, tipo );

        return operaRecord;
    }
}
