package com.example.demo.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterExceptionHandler extends AbstractException {

    protected FilterExceptionHandler(HttpStatus httpStatus, String userMessage) throws IOException {
        super(httpStatus, userMessage);
    }

    public void handleException(HttpServletResponse response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setStatus(getHttpStatus().value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");

        ErrorResponse errorResponse = new ErrorResponse("error", getUserMessage());

        response.getWriter().write(
            objectMapper.writeValueAsString(errorResponse)
        );
    }

    public class ErrorResponse {
        private final long timestamp;
        private final String errorCode;
        private final String errorMessage;

        public ErrorResponse(String errorCode, String errorMessage) {
            this.timestamp = System.currentTimeMillis();
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}
