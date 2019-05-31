package com.atSistemas.atWeek.mapper.rate;

import com.atSistemas.atWeek.model.dto.RateDTO;
import com.atSistemas.atWeek.model.entity.Rate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Component
public class RateMapperImp implements RateMapper {
    @Override
    public Rate map(RateDTO dto) {

        Rate rate = new Rate();
        Optional<RateDTO> rateDTO = Optional.ofNullable(dto);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-[uuuu][uu]");

        rateDTO.map(RateDTO::getId).ifPresent(rate::setId);
        rateDTO.map(RateDTO::getPrice).ifPresent(rate::setPrice);
        rateDTO.map(RateDTO::getStartDate).ifPresent(date -> {
                    try { rate.setStartDate( LocalDate.parse(dto.getStartDate(), formatter)); }
                    catch (DateTimeParseException e){ throw e; }
                });


        rateDTO.map(RateDTO::getEndDate).ifPresent(date -> {
            try { rate.setEndDate( LocalDate.parse(dto.getEndDate(), formatter)); }
            catch (DateTimeParseException e){ throw e; }
        });

        return rate;
    }

    @Override
    public RateDTO map(Rate rate) {

        RateDTO dto = new RateDTO();
        Optional<Rate> rateEntity = Optional.ofNullable(rate);

        rateEntity.map(Rate::getId).ifPresent(dto::setId);
        rateEntity.map(Rate::getPrice).ifPresent(dto::setPrice);
        rateEntity.map(Rate::getStartDate).ifPresent(date -> {
                dto.setStartDate(date.toString());
            });
        rateEntity.map(Rate::getEndDate).ifPresent(date -> {
            dto.setEndDate(date.toString());
        });

        return dto;
    }

    @Override
    public List<RateDTO> map(List<Rate> rate) {
        return null;
    }
}
