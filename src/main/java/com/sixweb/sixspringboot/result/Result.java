package com.sixweb.sixspringboot.result;

/**
 * Created by RogueMonkey on 2019/10/18.
 */
public class Result<T> {
    private int code;

    private T data;

    public Result(int code) {
        this.code = code;
    }

    public Result(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
