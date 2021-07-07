package com.toyota.dto;
import java.sql.Date;

public class FaultDTO {
    public FaultDTO() {
    }

    private Long id;
    private Date create_date;


    private String creator_user;



    private String requester_user;



    private String requester_phone;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getCreator_user() {
        return creator_user;
    }

    public void setCreator_user(String creator_user) {
        this.creator_user = creator_user;
    }

    public String getRequester_user() {
        return requester_user;
    }

    public void setRequester_user(String requester_user) {
        this.requester_user = requester_user;
    }

    public String getRequester_phone() {
        return requester_phone;
    }

    public void setRequester_phone(String requester_phone) {
        this.requester_phone = requester_phone;
    }

    public String getFault() {
        return fault;
    }

    public void setFault(String fault) {
        this.fault = fault;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCompletion_date() {
        return completion_date;
    }

    public void setCompletion_date(Date completion_date) {
        this.completion_date = completion_date;
    }

    private String fault;


    private String place;


    private String shop;



    private String assignee;



    private boolean urgent;


    private String description;


    private Date completion_date;
}
