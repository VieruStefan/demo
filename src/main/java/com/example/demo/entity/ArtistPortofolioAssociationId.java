package com.example.demo.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class ArtistPortofolioAssociationId implements Serializable {
    private String uuid;
    private int recordId;

    public ArtistPortofolioAssociationId() {
    }

    public ArtistPortofolioAssociationId(String uuid, int recordId) {
        this.uuid = uuid;
        this.recordId = recordId;
    }
}
