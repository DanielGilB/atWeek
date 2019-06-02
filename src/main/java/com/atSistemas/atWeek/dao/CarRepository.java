package com.atSistemas.atWeek.dao;

import com.atSistemas.atWeek.model.entity.Car;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {

    Optional<Car> findByCarPlate(String carPlate);


    //README: Se quiere buscar el coche que más beneficio aporta en un intervalo de fechas
    // Entiendo -y así lo hago- que el beneficio se genera el día en el que se hace la reserva
    // y no durante su transcurso, es por lo que uso la fecha de creación en la consulta
    @Query(value = "select c.id from Car c inner join Rental r on c.id = r.car" +
                    " where r.createdDate between :startDate and :endDate" +
                    " group by r.car order by sum(r.price) desc")
    List<Integer> findTopProfitableCar(@Param("startDate") LocalDate startDate,
                                       @Param("endDate") LocalDate endDate,
                                       Pageable pageable); //limit 1 ?

}
