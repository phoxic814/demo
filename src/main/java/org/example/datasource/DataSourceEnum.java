package org.example.datasource;

import lombok.Getter;

@Getter
public enum DataSourceEnum {
    MASTER, SLAVE;

    DataSourceEnum() {
    }
}
