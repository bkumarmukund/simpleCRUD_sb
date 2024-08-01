package com.mutha.pankaj.hellopankaj.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@NoArgsConstructor 
@AllArgsConstructor @EqualsAndHashCode
public class User {
    private String name;
    private int age;
}
