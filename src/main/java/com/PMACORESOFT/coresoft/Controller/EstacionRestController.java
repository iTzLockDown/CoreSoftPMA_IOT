package com.PMACORESOFT.coresoft.Controller;

import com.PMACORESOFT.coresoft.Entidades.Estacion;
import com.PMACORESOFT.coresoft.Entidades.Informacion;
import com.PMACORESOFT.coresoft.Servicios.Contrato.IEstacionService;
import com.PMACORESOFT.coresoft.Util.UtilRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(UtilRest.APLICACION_ROUTER)
public class EstacionRestController {
    @Autowired
    private IEstacionService estacionService;

    @GetMapping("/estacion")
    public List<Estacion> index()
    {
        return estacionService.findAll();
    }

    @GetMapping("/estacion/{id}")
    public ResponseEntity<?> show(@PathVariable Long id)
    {
        Estacion estacion = null;
        Map<String, Object> response = new HashMap<>();
        try {
            estacion = estacionService.findById(id);
        }
        catch(DataAccessException e)
        {
            response.put("mensaje", "Error al consultar la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR );
        }
        if (estacion==null)
        {
            response.put("mensaje", "La informacion ID:".concat(id.toString().concat(" No existe en la Base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Estacion>(estacion, HttpStatus.OK);

    }


    @PostMapping("/estacion")
    public ResponseEntity<?> create(@Valid @RequestBody Estacion estacion, BindingResult result)
    {
        Estacion estacionNuevo = null;
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors())
        {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '"+err.getField()+"' "+err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST );
        }

        try
        {
            estacionNuevo = estacionService.save(estacion);
        }catch (DataAccessException e)
        {
            response.put("mensaje", "Error al realizar el registro en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR );
        }
        response.put("mensaje", "La estacion se ha registrado con exito!");
        response.put("estacion", estacionNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/estacion/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Estacion estacion, BindingResult result, @PathVariable Long id)
    {
        Estacion estacionActual = estacionService.findById(id);
        Estacion estacionUpdate = null;

        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors())
        {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '"+err.getField()+"' "+err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST );
        }
        if (estacionActual==null)
        {
            response.put("mensaje", "Error: no se pudo actualizar:".concat(id.toString().concat(" No existe en la Base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            estacionActual.setNombre(estacion.getNombre());
            estacionActual.setEstado(estacion.getEstado());
            estacionActual.setLocalidad(estacion.getLocalidad());
            estacionUpdate=	estacionService.save(estacionActual);
        }catch (DataAccessException e)
        {
            response.put("mensaje", "Error al actualizar la estacion en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR );
        }
        response.put("mensaje", "Informacion actualizado con éxito!");
        response.put("estacion", estacionUpdate);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/estacion/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        Map<String, Object> response = new HashMap<>();
        try
        {
            estacionService.delete(id);
        }
        catch (DataAccessException e)
        {
            response.put("mensaje", "Error al eliminar la estacion en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR );
        }
        response.put("mensaje", "Estacion eliminada con exito");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
