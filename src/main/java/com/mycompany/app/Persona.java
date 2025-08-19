/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;

import java.time.LocalDate;
import java.time.Period;

public class Persona {

   private String nombre;

   public void setNombre(String valor){
       this.nombre = valor;
   }

   public String getNombre(){
        return this.nombre;
   }

   
   private LocalDate fechaNacimiento;

   public void setFechaNacimiento(LocalDate valor) {
      this.fechaNacimiento = valor;
   }

   public LocalDate getFechaNacimiento() {
      return this.fechaNacimiento;
   }

   public int edad() {
      //Option 1
      //int year = LocalDate.now().getYear();      
      //return year - this.getFechaNacimiento().getYear();

      //option 2
      return Period.between(this.getFechaNacimiento(), 
                           LocalDate.now()).getYears();
   }

}
