package com.atSistemas.atWeek.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepository<T, ID> extends JpaRepository<T, ID>{
}
