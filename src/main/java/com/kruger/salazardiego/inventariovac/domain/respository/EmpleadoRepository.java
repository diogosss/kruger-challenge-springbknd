package com.kruger.salazardiego.inventariovac.domain.respository;

import com.kruger.salazardiego.inventariovac.persistence.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    Empleado findById(int id);
    Empleado findByCedula(long cedula);

    //Queries
    //a. Filtrar por estado de vacunación.
    List<Empleado> findByEstadovac(Boolean estado);
    //b. Filtrar por tipo de vacuna.
    List<Empleado> findByTipovac(String tipovac);
    //c. Filtrar por rango de fecha de vacunación.
    List<Empleado> findAllByFechavacunaBetween(Date f1, Date f2);

    ///Queries necesarias
    Empleado findByCedula(Long cedula);

    //Test rango vacunacion
    List<Empleado> findAllByFechavacunaLessThanEqualAndFechavacunaGreaterThanEqual(Date f1, Date f2);


}
