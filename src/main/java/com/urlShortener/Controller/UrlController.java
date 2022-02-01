package com.urlShortener.Controller;

import com.urlShortener.Controller.Validation.UrlValidation;
import com.urlShortener.Controller.Validation.UserValidation;
import com.urlShortener.DTO.UrlRequestDTO;
import com.urlShortener.DTO.UrlResponseDTO;
import com.urlShortener.Exception.UserException.UserCreateException;
import com.urlShortener.Model.Url;
import com.urlShortener.Model.User;
import com.urlShortener.Service.Interface.IUrlService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UrlController {

    @Autowired
    private IUrlService iUrlService;

    @Autowired
    private UserValidation userValidation;

    @Autowired
    private UrlValidation urlValidation;

    @RequestMapping(produces = "application/json", value = "/url", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<UrlResponseDTO>> getAll(){

        List<UrlResponseDTO> urls = iUrlService.findAll();

        return new ResponseEntity<List<UrlResponseDTO>>(urls, HttpStatus.OK);

    }

    @RequestMapping(produces = "application/json", value = "/url/user/{userId}", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<UrlResponseDTO> create(@RequestBody UrlRequestDTO url, @PathVariable long userId) throws UserCreateException {

        urlValidation.validationCreate(url, userId);

        User user = userValidation.UserExists(userId);

        UrlResponseDTO newUrl = iUrlService.create(url, user);

        return new ResponseEntity<UrlResponseDTO>(newUrl, HttpStatus.CREATED);

    }

}