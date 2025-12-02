package com.codegnan.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    private boolean isApiRequest(HttpServletRequest request) {
        String path = request.getRequestURI();
        return path != null && path.startsWith(request.getContextPath() + "/api/");
    }

    @ExceptionHandler(NoteNotFoundException.class)
    public Object handleNotFound(NoteNotFoundException ex, HttpServletRequest request) {
        if (isApiRequest(request)) {
            ApiError err = new ApiError(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    ex.getMessage(),
                    request.getRequestURI()
            );
            return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
        } else {
            ModelMap mm = new ModelMap();
            mm.addAttribute("errorMessage", ex.getMessage());
            mm.addAttribute("status", HttpStatus.NOT_FOUND.value());
            return new ModelAndView("error", mm);
        }
    }

    @ExceptionHandler(Exception.class)
    public Object handleGeneric(Exception ex, HttpServletRequest request) {
        ex.printStackTrace(); // replace with a logger in production

        if (isApiRequest(request)) {
            ApiError err = new ApiError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                    "An unexpected error occurred. " + ex.getMessage(),
                    request.getRequestURI()
            );
            return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            ModelMap mm = new ModelMap();
            mm.addAttribute("errorMessage", "An unexpected error occurred. " + ex.getMessage());
            mm.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ModelAndView("error", mm);
        }
    }
}