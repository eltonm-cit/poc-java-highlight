package com.basejavaproject.configuration.log;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LogKey {

    LIMIT("limit"),
    OFFSET("offset"),
    TOTAL("total");

    private String key;
}
