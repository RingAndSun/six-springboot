package com.sixweb.sixspringboot.result;

/**
 * Created by RogueMonkey on 2019/10/18.
 */
public class Result {
    private int code;

    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
