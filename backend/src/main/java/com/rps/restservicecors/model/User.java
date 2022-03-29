package com.rps.restservicecors.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private final UUID id;
    private final String name;
    private final String rank;
    private final  String avatarUrl;

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("name") String name,
                @JsonProperty("rank") String rank,
                @JsonProperty("avatarUrl") String avatarUrl) {
                    this.id = id;
                    this.name = name;
                    this.rank = rank;
                    this.avatarUrl = avatarUrl;
                }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

}
