package com.utnphones.UTNPhonesDiazFtMurrie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponseDto
{
    //region Properties:
    @JsonProperty
    int code;
    @JsonProperty
    String description;
    //endregion

    //region Constructors:
    public ErrorResponseDto(int code, String description)
    {
        this.code = code;
        this.description = description;
    }
    //endregion

    //region Methods:
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //endregion
}
