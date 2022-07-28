package com.flagcamp.tripadvisor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "pointofinterest")
@JsonDeserialize(builder = PointOfInterest.Builder.class)
public class PointOfInterest implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String address;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public PointOfInterest() {}

    private PointOfInterest(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.address = builder.address;
    }

    public static class Builder {

        @JsonProperty("id")
        private Long id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("description")
        private String description;

        @JsonProperty("address")
        private String address;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public PointOfInterest build() {
            return new PointOfInterest(this);
        }
    }
}

