package com.line.ticket.common.entity.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demo implements Serializable {
    private static final long serialVersionUID = -894499789767930658L;
    private Integer id;
    private String name;
    private String phoneNumber;
    private Integer sex;        //性别,0代表未知、1代表男、2代表女
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdateTime;
}
