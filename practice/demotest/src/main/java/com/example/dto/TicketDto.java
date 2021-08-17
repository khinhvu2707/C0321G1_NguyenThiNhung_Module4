package com.example.dto;

import com.example.model.entity.Movie;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TicketDto implements Validator {
    private Long id;
    @NotBlank(message = "Please fill out the form")
    @Pattern(regexp = "^CI-\\d{4}$", message = "Not valid (CI-xxxx)")
    private String code;
    private Movie movie;
    @NotBlank(message = "Please fill out the form")
    private String datetime;
    @Min(1)
    private int ticket;
    private int flag;

    public TicketDto() {
    }

    public TicketDto(Long id, String code, Movie movie, String datetime, int ticket, int flag) {
        this.id = id;
        this.code = code;
        this.movie = movie;
        this.datetime = datetime;
        this.ticket = ticket;
        this.flag = flag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        TicketDto ticketDto = (TicketDto) target;
        Date dateNow = new java.sql.Date(System.currentTimeMillis());
        try {
           Date dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(ticketDto.getDatetime());
            if (dateFormat.before(dateNow)) {
                errors.rejectValue("datetime", "", "Movie day can't before day now");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
