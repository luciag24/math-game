package org.example.mapper;

import org.example.models.MathExample;
import org.example.dto.MathExampleDTO;
import org.springframework.stereotype.Component;

/**
 * Mapper trieda na konverziu medzi entitou MathExample a DTO MathExampleDTO.
 * Slúži na transformáciu údajov medzi aplikačnými vrstvami.
 */
@Component
public class MathExampleMapper {

    /**
     * Konvertuje entitu MathExample na DTO MathExampleDTO.
     *
     * @param example Inštancia triedy MathExample.
     * @return DTO reprezentácia matematického príkladu.
     */
    public static MathExampleDTO toDTO(MathExample example) {
        MathExampleDTO dto = new MathExampleDTO(
                example.getQuestion(),
                example.getCorrectAnswer(),
                example.getUserAnswer()
                );
        return dto;
    }

    /**
     * Konvertuje DTO MathExampleDTO na entitu MathExample.
     *
     * @param dto Inštancia triedy MathExampleDTO.
     * @return Entita MathExample pripravená na uloženie do databázy.
     */
    public static MathExample toEntity(MathExampleDTO dto) {
        MathExample example = new MathExample(
                dto.getQuestion(),
                dto.getCorrectAnswer()
        );
        example.setUserAnswer(dto.getUserAnswer());
        return example;
    }
}