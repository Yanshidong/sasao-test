package com.wd7.sso;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
    @AllArgsConstructor
//    @NoArgsConstructor
public class AUser implements Serializable {
    private static final long serialVersionUID = -7898194272883238670L;
    private Integer in;
    private String name;
    private boolean isBoy;

}
