package com.example.demo_1.dto;

import lombok.*;

import org.springframework.stereotype.Service;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class NationDTO {
    private String name;
    private String capital;
    private long population;
}
