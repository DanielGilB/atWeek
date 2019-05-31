package com.atSistemas.atWeek.mapper.rate;

import com.atSistemas.atWeek.model.dto.RateDTO;
import com.atSistemas.atWeek.model.entity.Client;
import com.atSistemas.atWeek.model.entity.Rate;

import java.time.format.DateTimeParseException;
import java.util.List;

public interface RateMapper {

    /**
     * map RateDTO to rate entity
     * @param dto
     * @return
     * @throws DateTimeParseException
     */
    Rate map(RateDTO dto) throws DateTimeParseException;

    /**
     * map rate entity to RateDTO
     * @param rate
     * @return
     */
    RateDTO map(Rate rate);

    /**
     * map a list of Rates to list of RateDTOs
     * @param rate
     * @return
     */
    List<RateDTO> map(List<Rate> rate);
}
