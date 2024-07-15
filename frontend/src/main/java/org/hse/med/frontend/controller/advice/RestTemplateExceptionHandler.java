package org.hse.med.frontend.controller.advice;

import jakarta.ws.rs.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.*;
import java.util.stream.Collectors;

public class RestTemplateExceptionHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().is4xxClientError() ||
                response.getStatusCode().is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode()== HttpStatus.NOT_FOUND) {
            throw new NotFoundException(readMessageFromResponse(response.getBody()));
        }
    }

    private String readMessageFromResponse(InputStream inputStream){
        String message = new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .collect(Collectors.joining("\n"));

        return message;
    }
}
