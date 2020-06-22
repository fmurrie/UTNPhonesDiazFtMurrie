package com.utnphones.UTNPhonesDiazFtMurrie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CallAddRequestDto
{
    //region Properties:
    @NotNull
    private PhoneLine phoneLineOrigin ;

    @NotNull
    private PhoneLine phoneLineDestiny ;

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date initTime;

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    //endregion
}
