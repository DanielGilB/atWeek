package com.atSistemas.atWeek.mapper.rental;

import com.atSistemas.atWeek.model.dto.RentalDTO;
import com.atSistemas.atWeek.model.entity.Rental;

import java.util.List;

public interface RentalMapper {
    /**
     * map RentalDTO to client entity
     * @param dto
     * @return
     */
    Rental map(RentalDTO dto);

    /**
     * map client entity to RentalDTO
     * @param rental
     * @return
     */
    RentalDTO map(Rental rental);

    /**
     * map a list of Rentals to list of RentalDTOs
     * @param rentals
     * @return
     */
    List<RentalDTO> map(List<Rental> rentals);
}
