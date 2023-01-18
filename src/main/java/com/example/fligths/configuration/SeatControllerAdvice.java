package com.example.fligths.configuration;

import com.example.fligths.exception.CouldNotSaveSeatException;
import com.example.fligths.exception.ErrorResponse;
import com.example.fligths.model.response.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class SeatControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CouldNotSaveSeatException.class)
	@ResponseStatus(BAD_REQUEST)
	public ApiError handleSeatException(CouldNotSaveSeatException seatException) {
		return seatException::getMessage;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
																  HttpHeaders headers,
																  HttpStatusCode status,
																  WebRequest request) {
		return ex.getBindingResult().getAllErrors()
				.stream()
				.map(ObjectError::getDefaultMessage)
				.collect(collectingAndThen(
						toList(),
						details -> ResponseEntity.badRequest()
								.body(new ErrorResponse("Something wrong happens", details))
				));
	}
}
