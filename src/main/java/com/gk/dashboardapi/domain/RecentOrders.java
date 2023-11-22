package com.gk.dashboardapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.swing.text.SimpleAttributeSet;
import java.time.LocalDateTime;

@Entity
@Table(name = "recent_orders")
public class RecentOrders {
    @Id
    @JsonProperty("id")
    private String id;

    @Column(name = "Name")
    @JsonProperty("name")
    private String name;

    @Column(name = "Product")
    @JsonProperty("product")
    private String product;

    @Column(name = "Delivery_Date")
    @JsonProperty("delivery_date")
    private LocalDateTime delivery_date;

    @Column(name = "status")
    @JsonProperty("status")
    private String status;

    @Column(name = "tracking_no")
    @JsonProperty("tracking_no")
    private String tracking_no;

    @Column(name = "shipping")
    @JsonProperty("shipping")
    private boolean shipping;

    public RecentOrders() {
    }

    public RecentOrders(String id, String name, String product, LocalDateTime delivery_date, String status, String tracking_no, boolean shipping) {
        this.id = id;
        this.name = name;
        this.product = product;
        this.delivery_date = delivery_date;
        this.status = status;
        this.tracking_no = tracking_no;
        this.shipping = shipping;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public LocalDateTime getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(LocalDateTime delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTracking_no() {
        return tracking_no;
    }

    public void setTracking_no(String tracking_no) {
        this.tracking_no = tracking_no;
    }

    public boolean isShipping() {
        return shipping;
    }

    public void setShipping(boolean shipping) {
        this.shipping = shipping;
    }

    @Override
    public String toString() {
        return "RecentOrders{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", product='" + product + '\'' +
                ", delivery_date=" + delivery_date +
                ", status='" + status + '\'' +
                ", tracking_no='" + tracking_no + '\'' +
                ", shipping=" + shipping +
                '}';
    }
}
