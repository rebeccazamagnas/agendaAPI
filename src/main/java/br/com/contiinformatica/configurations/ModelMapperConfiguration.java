package br.com.contiinformatica.configurations;

import java.text.SimpleDateFormat;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.contiinformatica.dtos.TarefaRequestDto;
import br.com.contiinformatica.entities.Tarefa;

@Configuration
public class ModelMapperConfiguration {

	@Bean
    public ModelMapper modelMapper() {
		
        ModelMapper modelMapper = new ModelMapper();

        //Mapeamento para copiar os dados de 'TarefaRequestDto' para 'Tarefa'
        modelMapper.typeMap(TarefaRequestDto.class, Tarefa.class).addMappings(mapper -> {          
            mapper.using(ctx -> {
                TarefaRequestDto dto = (TarefaRequestDto) ctx.getSource();
                try {
                    String dataHoraStr = dto.getData() + " " + dto.getHora();
                    return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dataHoraStr);
                } catch (Exception e) {
                    return null;
                }
            }).map(src -> src, Tarefa::setDataHora);
        });

        return modelMapper;
    }
}