package org.hse.med.recommendation_service.model.gmfcs;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class GmfcsId implements Serializable {

    private int age_category;
    private int gmfcs_level;


}
