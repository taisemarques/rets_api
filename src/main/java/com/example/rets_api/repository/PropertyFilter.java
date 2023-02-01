package com.example.rets_api.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
public class PropertyFilter {
    private Long price = null;
    private String description = null;
}
