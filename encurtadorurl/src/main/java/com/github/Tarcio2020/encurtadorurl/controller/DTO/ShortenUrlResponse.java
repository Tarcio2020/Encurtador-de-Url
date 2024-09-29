package com.github.Tarcio2020.encurtadorurl.controller.DTO;

public class ShortenUrlResponse {
    private String redirectUrl;

    public ShortenUrlResponse(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
