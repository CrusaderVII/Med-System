package org.hse.med.recommendation_service.model.gmfcs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hse.med.recommendation_service.model.Recommendation;

@Entity
@Table(name = "gmfcs")
@Getter
@Setter
@IdClass(GmfcsId.class)
@NoArgsConstructor
@AllArgsConstructor
public class Gmfcs {

    @Id
    private int age_category;

    @Id
    private int gmfcs_level;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "recommendation")
    private Recommendation recommendation;
}
