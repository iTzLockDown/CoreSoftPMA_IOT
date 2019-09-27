package com.PMACORESOFT.coresoft.Controller;

import com.PMACORESOFT.coresoft.Entidades.Informacion;
import com.PMACORESOFT.coresoft.Entidades.Usuario;
import com.PMACORESOFT.coresoft.Servicios.Contrato.IInformacionService;
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
public class InformacionRestController {
    @Autowired
    private IInformacionService informacionService;

    @GetMapping("/informacion")
    public List<Informacion> index()
    {
        return informacionService.findAll();
    }



    @GetMapping("/informacion/{id}")
    public ResponseEntity<?> show(@PathVariable Long id)
    {
        Informacion informacion = null;
        Map<String, Object> response = new HashMap<>();
        try {
            informacion = informacionService.findById(id);
        }
        catch(DataAccessException e)
        {
            response.put("mensaje", "Error al consultar la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR );
        }
        if (informacion==null)
        {
            response.put("mensaje", "La informacion ID:".concat(id.toString().concat(" No existe en la Base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Informacion>(informacion, HttpStatus.OK);

    }


    @PostMapping("/informacion")
    public ResponseEntity<?> create(@Valid @RequestBody Informacion informacion, BindingResult result)
    {
        Informacion informacionNuevo = null;
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
            informacionNuevo = informacionService.save(informacion);
        }catch (DataAccessException e)
        {
            response.put("mensaje", "Error al realizar el registro en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR );
        }
        response.put("mensaje", "La informacion se ha registrado con exito!");
        response.put("informacion", informacionNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/informacion/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Informacion informacion, BindingResult result, @PathVariable Long id)
    {
        Informacion informacionActual = informacionService.findById(id);
        Informacion informacionUpdate = null;

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
        if (informacionActual==null)
        {
            response.put("mensaje", "Error: no se pudo actualizar:".concat(id.toString().concat(" No existe en la Base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            informacionActual.setUnidadMedida(informacion.getUnidadMedida());
            informacionActual.setValorMedida(informacion.getValorMedida());
            informacionActual.setEstado(informacion.getEstado());
            informacionActual.setEstacionInformacion(informacion.getEstacionInformacion());
            informacionActual.setTipoDispositivo(informacion.getTipoDispositivo());
            informacionUpdate=	informacionService.save(informacionActual);
        }catch (DataAccessException e)
        {
            response.put("mensaje", "Error al actualizar lainformació en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR );
        }
        response.put("mensaje", "Informacion actualizado con éxito!");
        response.put("informacion", informacionUpdate);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/informacion/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        Map<String, Object> response = new HashMap<>();
        try
        {
            informacionService.delete(id);
        }
        catch (DataAccessException e)
        {
            response.put("mensaje", "Error al eliminar la informacion en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR );
        }
        response.put("mensaje", "Informacion eliminada con exito");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }



}
