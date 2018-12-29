/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outbottle.models;

import java.util.List;

/**
 *
 * @author Admin
 */
public class PeopleDTO {
    
  private List<PersonDTO> people;

  public PeopleDTO() {}

  public PeopleDTO(List<PersonDTO> people) {
    this.people = people;
  }

  public List<PersonDTO> getPeople() {
    return people;
  }

  public void setPeople() {
    this.people = people;
  }
}
