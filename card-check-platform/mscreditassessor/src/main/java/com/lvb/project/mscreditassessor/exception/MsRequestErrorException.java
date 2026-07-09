package com.lvb.project.mscreditassessor.exception;

import lombok.Getter;

@Getter
public class MsRequestErrorException extends RuntimeException {

    private final Integer status;

    public MsRequestErrorException(String msg, Integer status) {
        super(msg);
        this.status = status;
    }
}
