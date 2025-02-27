package org.example.mapper;

import org.example.models.MathExample;
import org.example.dto.MathExampleDTO;
import org.springframework.stereotype.Component;


@Component
public class MathExampleMapper {
    public static MathExampleDTO toDTO(MathExample example) {
        MathExampleDTO dto = new MathExampleDTO(
                example.getQuestion(),
                example.getCorrectAnswer(),
                example.getUserAnswer()
                );

        return dto;

    }
    public static MathExample toEntity(MathExampleDTO dto) {
        return new MathExample(
                dto.getQuestion(),
                dto.getCorrectAnswer()
        );
    }

}