package com.atSistemas.atWeek.mapper.rental;

import com.atSistemas.atWeek.mapper.car.CarMapper;
import com.atSistemas.atWeek.mapper.client.ClientMapper;
import com.atSistemas.atWeek.model.dto.RentalDTO;
import com.atSistemas.atWeek.model.entity.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RentalMapperImp implements RentalMapper {

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private CarMapper carMapper;

    @Override
    public Rental map(RentalDTO dto) {

        Rental rental = new Rental();
        Optional<RentalDTO> rentalDTO = Optional.ofNullable(dto);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-[uuuu][uu]");

        rentalDTO.map(RentalDTO::getId).ifPresent(rental::setId);
        rentalDTO.map(RentalDTO::getPrice).ifPresent(rental::setPrice);
        rentalDTO.map(RentalDTO::getStartDate).ifPresent(date -> {
                    try { rental.setStartDate(LocalDate.parse(dto.getStartDate(), formatter)); }
                    catch (DateTimeParseException e) { throw e; }
                });
        rentalDTO.map(RentalDTO::getEndDate).ifPresent(date -> {
                    try { rental.setEndDate( LocalDate.parse(dto.getEndDate(), formatter)); }
                    catch (DateTimeParseException e){ throw e; }
                });

        rentalDTO.map(RentalDTO::getClient).ifPresent( client -> {
            rental.setClient(clientMapper.map(client));
        });

        rentalDTO.map(RentalDTO::getCar).ifPresent( car -> {
            rental.setCar(carMapper.map(car));
        });

        return rental;
    }


    @Override
    public RentalDTO map(Rental rental) {

        RentalDTO dto = new RentalDTO();
        Optional<Rental> rentalEntity = Optional.ofNullable(rental);

        rentalEntity.map(Rental::getId).ifPresent(dto::setId);
        rentalEntity.map(Rental::getPrice).ifPresent(dto::setPrice);
        rentalEntity.map(Rental::getStartDate).ifPresent(date -> {
                    dto.setStartDate(date.toString());
                });
        rentalEntity.map(Rental::getEndDate).ifPresent(date -> {
                    dto.setEndDate(date.toString());
                });


        rentalEntity.map(Rental::getClient).ifPresent( client -> {
                dto.setClient(clientMapper.map(client));
            });

        rentalEntity.map(Rental::getCar).ifPresent( car -> {
            dto.setCar(carMapper.map(car));
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
