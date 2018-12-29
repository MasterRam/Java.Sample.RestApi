/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outbottle.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.outbottle.models.PersonDTO;
import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.outbottle.models.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class PersonRestController {

  private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

  @RequestMapping("/getPersonDTO")
  public PersonDTO getPersonDTO(@RequestParam(value = "personDTO") String jsonPersonDTO)
      throws IOException {
    return getPersonDTOFromJson(jsonPersonDTO);
  }

  private PersonDTO getPersonDTOFromJson(final String jsonPersonDTO) throws IOException {
    return new ObjectMapper()
        .setDateFormat(simpleDateFormat)
        .readValue(jsonPersonDTO, PersonDTO.class);
  }

  @RequestMapping("/getPersonDTOList")
  public List<PersonDTO> getPersonDTOList(
      @RequestParam(value = "personDTO") String jsonPersonDTO,
      @RequestParam(value = "personDTO2") String jsonPersonDTO2)
      throws IOException {
    final PersonDTO personDTO = getPersonDTOFromJson(jsonPersonDTO);
    final PersonDTO personDTO2 = getPersonDTOFromJson(jsonPersonDTO2);
    return Arrays.asList(personDTO, personDTO2);
  }
  
  @RequestMapping("/getPeopleDTO")
  public PeopleDTO getPeopleDTO(
      @RequestParam(value = "personDTO") String jsonPersonDTO,
      @RequestParam(value = "personDTO2") String jsonPersonDTO2)
      throws IOException {
    final PersonDTO personDTO = getPersonDTOFromJson(jsonPersonDTO);
    final PersonDTO personDTO2 = getPersonDTOFromJson(jsonPersonDTO2);
    return new PeopleDTO(Arrays.asList(personDTO, personDTO2));
  }
}
