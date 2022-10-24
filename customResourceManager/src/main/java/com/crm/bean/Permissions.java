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
public class Permissions {

    private Integer id;

    private String resource_name;

    private String resource_permissions;

    private Integer state;

    private Integer created_by;

    private LocalDateTime created_time;

    private Integer updated_by;

    private LocalDateTime updated_time;
}
