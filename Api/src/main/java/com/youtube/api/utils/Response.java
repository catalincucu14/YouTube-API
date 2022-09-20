package com.youtube.api.utils;

import java.util.*;

public class Response<T> {
    public boolean success;

    public T data;

    public List<String> errors;

    public Response() {
    }

    public Response(boolean success) {
        this.success = success;
        this.data = null;
        this.errors = new ArrayList<>();
    }

    public Response(T data) {
        this.success = false;
        this.data = data;
        this.errors = new ArrayList<>();
    }

    public Response(List<String> errors) {
        this.success = false;
        this.data = null;
        this.errors = errors;
    }

    public Response(boolean success, T data) {
        this.success = success;
        this.data = data;
        this.errors = new ArrayList<>();
    }

    public Response(boolean success, List<String> errors) {
        this.success = success;
        this.data = null;
        this.errors = errors;
    }
}
