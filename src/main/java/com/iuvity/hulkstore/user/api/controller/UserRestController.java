package com.iuvity.hulkstore.user.api.controller;

import com.iuvity.hulkstore.product.domain.entities.KardexEntity;
import com.iuvity.hulkstore.user.infraestructure.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.iuvity.hulkstore.util.ConstanManager.*;

@Slf4j
//@Transactional
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserRestController {

    private final UserService userService;


}
