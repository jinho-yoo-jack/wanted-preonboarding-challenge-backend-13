package com.wanted.preonboarding.global;

import lombok.Getter;

@Getter
public class Response<T> {
    private String resultCode;
    private T result;

    public Response() {}

    public Response(String resultCode, T result) {
        this.resultCode = resultCode;
        this.result = result;
    }

    public static <T> Response<T> success() {
        return new Response<>("SUCCESS", null);
    }

    public static <T> Response<T> success(T result) {
        return new Response<>("SUCCESS", result);
    }

    public static Response<Void> error(String resultCode) {
        return new Response<>(resultCode, null);
    }

    @Override
    public String toString() {
        if (result == null) {
            return "{" +
                    "\"resultCode\":" + "\"" + resultCode + "\"," +
                    "\"result\":" + null +
                    "}";
        }
        return "{" +
                "\"resultCode\":" + "\"" + resultCode + "\"," +
                "\"result\":" + "\"" + result + "\"," +
                "}";
    }
}
