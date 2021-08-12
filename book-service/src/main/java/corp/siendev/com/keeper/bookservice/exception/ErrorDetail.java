/*
 * Copyright (c) 2020
 * Ghost Rider aka Golubnichenko Yuriy
 */

package corp.siendev.com.keeper.bookservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetail {

    private String title;
    private String details;
    private String developerMessage;
    private int statusCode;
    private long timeStamp;
}
