package com.mutha.pankaj.hellopankaj.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserUpdateRequest {
    private User oldUser;
    private User newUser;
}
