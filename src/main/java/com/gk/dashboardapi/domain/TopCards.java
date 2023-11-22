package com.gk.dashboardapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "top_cards")
public class TopCards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "header")
    @JsonProperty("header")
    private String header;

    @Column(name = "sub_header")
    @JsonProperty("sub_header")
    private String subHeader;

    @Column(name = "value")
    @JsonProperty("value")
    private Integer value;

    public TopCards(Integer id, String header, String subHeader, Integer value) {
        this.id = id;
        this.header = header;
        this.subHeader = subHeader;
        this.value = value;
    }

    public TopCards() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSubHeader() {
        return subHeader;
    }

    public void setSubHeader(String subHeader) {
        this.subHeader = subHeader;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TopCards{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", subHeader='" + subHeader + '\'' +
                ", value=" + value +
                '}';
    }
}
