package com.PMACORESOFT.coresoft.Controller;

import com.PMACORESOFT.coresoft.Entidades.Dispositivo;
import com.PMACORESOFT.coresoft.Entidades.Estacion;
import com.PMACORESOFT.coresoft.Servicios.Contrato.IDispositivoService;
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

public class DispositivoRestController {
    @Autowired
    private IDispositivoService dispositivoService;


    @GetMapping("/dispositivo")
    public List<Dispositivo> index()
    {
        return dispositivoService.findAll();
    }

    @GetMapping("/dispositivo/{id}")
    public ResponseEntity<?> show(@PathVariable Long id)
    {
        Dispositivo dispositivo = null;
        Map<String, Object> response = new HashMap<>();
        try {
            dispositivo = dispositivoService.findById(id);
        }
        catch(DataAccessException e)
        {
            response.put("mensaje", "Error al consultar la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR );
        }
        if (dispositivo==null)
        {
            response.put("mensaje", "La dispositivo ID:".concat(id.toString().concat(" No existe en la Base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Dispositivo>(dispositivo, HttpStatus.OK);

    }


    @PostMapping("/dispositivo")
    public ResponseEntity<?> create(@Valid @RequestBody Dispositivo dispositivo, BindingResult result)
    {
        Dispositivo dispositivoNuevo = null;
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
            dispositivoNuevo = dispositivoService.save(dispositivo);
        }catch (DataAccessException e)
        {
            response.put("mensaje", "Error al realizar el registro en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR );
        }
        response.put("mensaje", "La dispositivo se ha registrado con exito!");
        response.put("dispositivo", dispositivoNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/dispositivo/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Dispositivo dispositivo, BindingResult result, @PathVariable Long id)
    {
        Dispositivo dispositivoActual = dispositivoService.findById(id);
        Dispositivo dispositivoUpdate = null;

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
        if (dispositivoActual==null)
        {
            response.put("mensaje", "Error: no se pudo actualizar:".concat(id.toString().concat(" No existe en la Base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            dispositivoActual.setNombre(dispositivo.getNombre());
            dispositivoActual.setEstado(dispositivo.getEstado());
            dispositivoUpdate=	dispositivoService.save(dispositivoActual);
        }catch (DataAccessException e)
        {
            response.put("mensaje", "Error al actualizar el dispositivo en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR );
        }
        response.put("mensaje", "Dispositivo actualizado con éxito!");
        response.put("estacion", dispositivoUpdate);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/dispositivo/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        Map<String, Object> response = new HashMap<>();
        try
        {
            dispositivoService.delete(id);
        }
        catch (DataAccessException e)
        {
            response.put("mensaje", "Error al eliminar la estacion en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR );
        }
        response.put("mensaje", "Dispositivo eliminada con exito");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


}
