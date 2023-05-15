package com.iuvity.hulkstore.product.api.controller;

import com.iuvity.hulkstore.product.domain.entities.KardexEntity;
import com.iuvity.hulkstore.product.infraestructure.service.KardexService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.iuvity.hulkstore.util.ConstanManager.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
//@Transactional
//@AllArgsConstructor
@RequiredArgsConstructor
@RestController
@RequestMapping("/kardex")
//@CrossOrigin(origins = {"http://localhost:4200"})
public class KardexRestController {

    private final KardexService kardexService;


    @GetMapping()
    private ResponseEntity<List<KardexEntity>> findAll() {
        Map<String, Object> response = new HashMap<>();
        List<KardexEntity> list = null;
        try {
            list = kardexService.findAll();
        } catch (Exception e) {
            response.put(MESSAGE, MESSAGE_ERROR_KARDEX);
            response.put(ERROR, e.getMessage().concat(SEPARATOR).concat(e.getLocalizedMessage()));
        }

        if (list == null || list.isEmpty()) {
            response.put(MESSAGE, MESSAGE_NOT_FOUND_KARDEX);
//            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            return new ResponseEntity<List<KardexEntity>>(list, HttpStatus.NOT_FOUND);
        }
        response.put(LIST, list);
        return new ResponseEntity<List<KardexEntity>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        Optional<KardexEntity> kardex = null;
        Map<String, Object> response = new HashMap<>();

        try {
            kardex = kardexService.findById(id);
        } catch (DataAccessException e) {
            response.put(MESSAGE, MESSAGE_ERROR_KARDEX);
            response.put(ERROR, e.getMessage().concat(SEPARATOR).concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (kardex.isEmpty()) {
            response.put(MESSAGE, THE_ID.concat(id.toString().concat(NOT_EXIST_IN_DDBB)));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<KardexEntity>(kardex.get(), HttpStatus.OK);
    }

    @PostMapping("")
    private ResponseEntity<?> save(@Validated @RequestBody KardexEntity kardex, BindingResult result) {
        log.info("### Guardando el  kardex : " + kardex.toString());
        KardexEntity kardexNew = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> THE_FIELD + err.getField() + PRESENT_ERRORS + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put(ERRORS, errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            kardexNew = kardexService.save(kardex);
        } catch (DataAccessException e) {
            response.put(MESSAGE, MESSAGE_ERROR_INSERT_KARDEX);
            response.put(ERROR, e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put(MESSAGE, MESSAGE_OK_INSERT);
        response.put(TABLE_NAME_KARDEX, kardexNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@RequestParam(value = "id") Long id) {
        log.info("### Eliminando Kardex por el id: " + id);
        Map<String, Object> response = new HashMap<>();

        try {
            Optional<KardexEntity> kardex = kardexService.findById(id);
            if (kardex.isEmpty()) {
                response.put(MESSAGE, String.format(MESSAGE_NOT_POSIBLE_DELETE, id));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            kardexService.remove(id);
        } catch (DataAccessException e) {
            response.put(MESSAGE, MESSAGE_ERROR_DELETE_KARDEX);
            response.put(ERROR, e.getMessage().concat(SEPARATOR).concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put(MESSAGE, MESSAGE_DELETE_OK);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
