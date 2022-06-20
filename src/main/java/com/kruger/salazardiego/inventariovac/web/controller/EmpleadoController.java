package com.kruger.salazardiego.inventariovac.web.controller;

import com.kruger.salazardiego.inventariovac.domain.respository.EmpleadoRepository;
import com.kruger.salazardiego.inventariovac.domain.service.EmpleadoService;
import com.kruger.salazardiego.inventariovac.persistence.entity.Empleado;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    EmpleadoRepository empleadoRepository;

    @PostMapping("/addempleados")
    @ApiOperation("Anade una lista de empleados")
    @ApiResponse(code = 200, message = "Created")
    public List<Empleado> addAllEmployees(@Valid @RequestBody List<Empleado> empleados){
        return empleadoService.saveAllEmployee(empleados);
    }

    @GetMapping("/all")
    @ApiOperation("Consultar todos los empleados")
    @ApiResponse(code = 200, message = "Created")
    public List<Empleado> getAllEmployees(){
        return empleadoService.findAllEmployees();
    }

/*
    @GetMapping("/empid")
    public Empleado getEmployeeById(@RequestParam int id){
        return empleadoService.findEmployeeById(id);
    }



    @GetMapping("/empsids")
    public List<Empleado> getEmployeeById(@RequestBody List<Integer> ids){
        return empleadoService.findAllEmployeesByIds(ids);
    }

 */

    /*----*/
    @PostMapping("/save")
    @ApiOperation("Guarda un solo empleado con la informacion basica")
    @ApiResponse(code = 200, message = "Created")
    private ResponseEntity<Empleado> guardar(@Valid @RequestBody Empleado persona){
        Empleado temp = empleadoService.saveEmployee(persona);

        try{
            return ResponseEntity.created(new URI("/api/"+temp.getId_emp())).body(temp);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    //Update data from employees

    @PatchMapping("/updateb/{cedula}/{nacimiento}")
    @ApiOperation("Actualiza la fecha de nacimiento de acuerdo al numero cedula")
    @ApiResponse(code = 200, message = "Updated")
    public Empleado updateNacimiento(@Valid @ApiParam(value = "Numero de cedula",example = "1714125263")
                                         @PathVariable("cedula") Long cedula,
                                     @ApiParam(value = "Fecha de nacimiento",example = "1990-12-05")
                                     @PathVariable("nacimiento")
                                     @DateTimeFormat(pattern = "yyyy-MM-dd") String nacimiento) throws ParseException {
        System.out.println("nacimientoJava:  " + cedula +"-- " + nacimiento);
        Date dates=new SimpleDateFormat("yyyy-MM-dd").parse(nacimiento);
        java.sql.Date sqlDate = new java.sql.Date(dates.getTime());
        System.out.println("nacimientoJavasql:  " + cedula + "-- " + sqlDate);
        return empleadoService.updateNacimientoWithCedula(cedula, sqlDate);

    }

    /*
    @RequestMapping(value = "/{dateString}", method = RequestMethod.GET)
    @ResponseBody
    public HttpStatus getDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String dateString) {
        System.out.println("nacimientoJavaString:  " +  dateString);
        //java.sql.Date sqlDate = new java.sql.Date(dateString.getTime());
        //System.out.println("nacimientoJavasql:  " + dateString + sqlDate);
        return OK;
    }
     */

    @PatchMapping("/updated/{cedula}/{direcc}")
    @ApiOperation("Actualiza la direccion de acuerdo al numero cedula")
    @ApiResponse(code = 200, message = "Updated")
    public Empleado updateDireccion(@Valid
                                        @ApiParam(value = "Numero de cedula",example = "1714125263")
                                        @PathVariable("cedula") Long cedula,
                                    @ApiParam(value = "Direccion",example = "Av Patria y Av Colon S56-78")
                                    @PathVariable("direcc") String direcc){
        return empleadoService.updateDireccionWithCedula(cedula,direcc);
    }

    @PatchMapping("/updatet/{cedula}/{telefono}")
    @ApiOperation("Actualiza el numero de telefono de acuerdo al numero cedula")
    @ApiResponse(code = 200, message = "Updated")
    public Empleado updateTelefono(@Valid
                                       @ApiParam(value = "Numero de cedula",example = "1714125263")
                                       @PathVariable("cedula") Long cedula,
                                   @ApiParam(value = "Telefono",example = "0987521465")
                                   @PathVariable("telefono") Long telefono){
        return empleadoService.updateTelefonoWithCedula(cedula,telefono);
    }

    @PatchMapping("/updates/{cedula}/{estadovac}")
    @ApiOperation("Actualiza el estado de vacunacion de acuerdo al numero cedula")
    @ApiResponse(code = 200, message = "Updated")
    public Empleado updateEstadovac(@Valid
                                        @ApiParam(value = "Numero de cedula",example = "1714125263")
                                        @PathVariable("cedula") Long cedula,
                                    @ApiParam(value = "Estado Vacunacion",example = "true/false")
                                    @PathVariable("estadovac") boolean estadovac){
        return empleadoService.updateEstadovacWithCedula(cedula,estadovac);
    }

    @PatchMapping("/updatetv/{cedula}/{tipovac}")
    @ApiOperation("Actualizael tipo de vacuna recibida de acuerdo al numero cedula")
    @ApiResponse(code = 200, message = "Updated")
    public Empleado updateTipoVac(@Valid
                                      @ApiParam(value = "Numero de cedula",example = "1714125263")
                                      @PathVariable("cedula") Long cedula,
                                  @ApiParam(value = "Tipo de vacuna",example = "Sputnik, AstraZeneca, Pfizer y Jhonson&Jhonson")
                                  @PathVariable("tipovac") String tipovac){
        return empleadoService.updateDTipoVacWithCedula(cedula,tipovac);
    }

    //****
    @PatchMapping("/updatefv/{cedula}/{fecha}")
    @ApiOperation("Actualiza la fecha de vacunacion de acuerdo al numero cedula")
    @ApiResponse(code = 200, message = "Updated")
    public Empleado updateFechaVacuna(@Valid
                                          @ApiParam(value = "Numero de cedula",example = "1714125263")
                                          @PathVariable("cedula") Long cedula,
                                      @ApiParam(value = "Fecha de vacunacion",example = "2021-05-05")
                                      @PathVariable("fecha")
                                      @DateTimeFormat(pattern = "yyyy-MM-dd") String fecha) throws ParseException {
        System.out.println("fechavacJava:  " + cedula +"-- " + fecha);
        Date dates=new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        java.sql.Date sqlDate = new java.sql.Date(dates.getTime());
        System.out.println("fechavacJavasql:  " + cedula + "-- " + sqlDate);
        return empleadoService.updateFechaVacuna(cedula, sqlDate);
    }

    @PatchMapping("/updatedosis/{cedula}/{dosis}")
    @ApiOperation("Actualiza el numero de dosis recibidas de acuerdo al numero cedula")
    @ApiResponse(code = 200, message = "Updated")
    public Empleado updateNumDosis(@Valid
                                       @ApiParam(value = "Numero de cedula",example = "1714125263")
                                       @PathVariable("cedula") Long cedula,
                                   @ApiParam(value = "Numero de dosis",example = "2")
                                   @PathVariable("dosis") Integer dosis){
        return empleadoService.updateNumDosis(cedula,dosis);
    }

    //Update one method jsonPatch


    // Filters
    @GetMapping("/tipovac/{vac}")
    @ApiOperation("Filtro para encontrar empleados por tipo de vacuna recibida")
    @ApiResponse(code = 200, message = "OK")
    public List<Empleado> getEmplTipoVac(@ApiParam(value = "Tipo de Vacuna",example = "Sputnik, AstraZeneca, Pfizer y Jhonson&Jhonson")
                                             @PathVariable("vac") String tipovac){
        return empleadoRepository.findByTipovac(tipovac);
    }

    @GetMapping("/estvac/{estado}")
    @ApiOperation("Filtro para encontrar empleados por su estado de vacunacion Vacunado/No Vacunado")
    @ApiResponse(code = 200, message = "Ok")
    public List<Empleado> getEstadoVac(
            @ApiParam(value = "Estado de vacunacion",example ="true/false")
            @PathVariable("estado") boolean estadovac){
        return empleadoRepository.findByEstadovac(estadovac);
    }

    @GetMapping("/rango/{fechini}/{fechfin}")
    @ApiOperation("Filtro para encontrar empleados vacunados en un rango de fechas de vacunacion")
    @ApiResponse(code = 200, message = "Ok")
    public List<Empleado> getRangoFechasVacuna(
                                             @ApiParam(value = "Fecha limite inferior",example ="2020-05-05")
                                             @PathVariable("fechini")
                                               @DateTimeFormat(pattern = "yyyy-MM-dd") String fecha1,
                                                @ApiParam(value = "Fecha limite inferior",example ="2022-05-05")
                                               @DateTimeFormat(pattern = "yyyy-MM-dd")
                                               @PathVariable("fechfin") String fecha2) throws ParseException {

        Date dates=new SimpleDateFormat("yyyy-MM-dd").parse(fecha1);
        java.sql.Date f1 = new java.sql.Date(dates.getTime());
        dates=new SimpleDateFormat("yyyy-MM-dd").parse(fecha2);
        java.sql.Date f2 = new java.sql.Date(dates.getTime());
        //return empleadoRepository.findAllByFechavacunaLessThanEqualAndFechavacunaGreaterThanEqual(f1,f2);
        return empleadoRepository.findAllByFechavacunaBetween(f1,f2);
    }


}
