package com.crm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {

    private Integer id;

    private String role;

    private String role_name;

    private Integer state;

    private Integer created_by;

    private LocalDateTime created_time;

    private Integer updated_by;

    private LocalDateTime updated_time;


}
