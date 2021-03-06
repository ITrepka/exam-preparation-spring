package com.example.pretkej.springpreparation.point12.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateBookDto {
    private String title;
    private String author;
}
