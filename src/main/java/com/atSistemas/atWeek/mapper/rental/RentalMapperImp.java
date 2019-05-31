package com.atSistemas.atWeek.mapper.rental;

import com.atSistemas.atWeek.model.dto.RentalDTO;
import com.atSistemas.atWeek.model.entity.Rental;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RentalMapperImp implements RentalMapper {
    @Override
    public Rental map(RentalDTO dto) {

        Rental rental = new Rental();
        Optional<RentalDTO> rentalDTO = Optional.ofNullable(dto);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-[uuuu][uu]");

        rentalDTO.map(RentalDTO::getId).ifPresent(rental::setId);
        rentalDTO.map(RentalDTO::getCar).ifPresent(rental::setCar);
        rentalDTO.map(RentalDTO::getClient).ifPresent(rental::setClient);
        rentalDTO.map(RentalDTO::getPrice).ifPresent(rental::setPrice);
        rentalDTO.map(RentalDTO::getStartDate).ifPresent(date -> {
                    try { rental.setStartDate(LocalDate.parse(dto.getStartDate(), formatter)); }
                    catch (DateTimeParseException e) { throw e; }
                });
        rentalDTO.map(RentalDTO::getEndDate).ifPresent(date -> {
                    try { rental.setEndDate( LocalDate.parse(dto.getEndDate(), formatter)); }
                    catch (DateTimeParseException e){ throw e; }
                });

        return rental;
    }

    @Override
    public RentalDTO map(Rental rental) {

        RentalDTO dto = new RentalDTO();
        Optional<Rental> rentalEntity = Optional.ofNullable(rental);

        rentalEntity.map(Rental::getId).ifPresent(dto::setId);
        rentalEntity.map(Rental::getPrice).ifPresent(dto::setPrice);
        rentalEntity.map(Rental::getCar).ifPresent(dto::setCar);
        rentalEntity.map(Rental::getClient).ifPresent(dto::setClient);
        rentalEntity.map(Rental::getStartDate).ifPresent(date -> {
                    dto.setStartDate(date.toString());
                });
        rentalEntity.map(Rental::getEndDate).ifPresent(date -> {
                    dto.setEndDate(date.toString());
                });

        return dto;
    }

    @Override
    public List<RentalDTO> map(List<Rental> rentals) {
        return rentals.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
