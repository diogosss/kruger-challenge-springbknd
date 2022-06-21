/*
 * Coded by Diego Salazar for the Kruger CHallenge
 * */

package com.kruger.salazardiego.inventariovac.domain.service;

import com.kruger.salazardiego.inventariovac.domain.respository.EmpleadoRepository;
import com.kruger.salazardiego.inventariovac.persistence.crud.EmpleadoCrudRepository;
import com.kruger.salazardiego.inventariovac.persistence.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public EmpleadoService() {
    }

    public List<Empleado> saveAllEmployee(List<Empleado> empleados){
        return empleadoRepository.saveAll(empleados);
    }

    public Empleado saveEmployee(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    public void deleteEmployee(Integer id){
        empleadoRepository.deleteById(id);
    }

    public List<Empleado> findAllEmployees(){
        return empleadoRepository.findAll();
    }

    public List<Empleado> findAllEmployeesByIds(List<Integer> ids){
        return empleadoRepository.findAllById(ids);
    }

    public List<Empleado> findEmployeesByIds(List<Integer> ids){
        return empleadoRepository.findAllById(ids);
    }

    public Empleado findEmployeeById(int id){
        return empleadoRepository.findById(id);
    }

    ///Queries del ejercicio

    public List<Empleado> findEmmpleadosporEstadovacuna(boolean estado){
        return empleadoRepository.findByEstadovac(estado);
    }

    public List<Empleado> findEmmpleadosporTipovacuna(String tipovac){
        return empleadoRepository.findByTipovac(tipovac);
    }

    ///Updates
    public Empleado updateNacimientoWithCedula(Long cedula, java.sql.Date nacimiento) throws ParseException {

        //Date nacimiento=new SimpleDateFormat("dd/MM/yyyy").parse(nacimientoS);

        Empleado emp = empleadoRepository.findByCedula(cedula);
        emp.setNacimiento(nacimiento);
        return empleadoRepository.save(emp);
    }

    public Empleado updateDireccionWithCedula(Long cedula, String direcc) {
        Empleado emp = empleadoRepository.findByCedula(cedula);
        emp.setDireccion(direcc);
        return empleadoRepository.save(emp);
    }

    public Empleado updateTelefonoWithCedula(Long cedula, Long telefono) {
        Empleado emp = empleadoRepository.findByCedula(cedula);
        emp.setTelefono(telefono);
        return empleadoRepository.save(emp);
    }

    public Empleado updateEstadovacWithCedula(Long cedula, boolean estadovac) {
        Empleado emp = empleadoRepository.findByCedula(cedula);
        emp.setEstadovac(estadovac);
        return empleadoRepository.save(emp);
    }

    public Empleado updateDTipoVacWithCedula(Long cedula, String tipovac) {
        Empleado emp = empleadoRepository.findByCedula(cedula);
        emp.setTipovac(tipovac);
        return empleadoRepository.save(emp);
    }

    public Optional<Object> findEmpleadoByCedula(Long cedula) {
        return Optional.ofNullable(empleadoRepository.findByCedula(cedula));
    }

    //***

    public Empleado updateFechaVacuna(Long cedula, Date sqlDate) {
        Empleado emp = empleadoRepository.findByCedula(cedula);
        emp.setFechavacuna(sqlDate);
        return empleadoRepository.save(emp);
    }

    public Empleado updateNumDosis(Long cedula, Integer dosis) {
        Empleado emp = empleadoRepository.findByCedula(cedula);
        emp.setNumdosis(dosis);
        return empleadoRepository.save(emp);
    }

}
