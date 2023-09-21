package com.geoTwo.project_name.entity;

import com.geoTwo.project_name.entity.base.AbsEntityLong;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class District extends AbsEntityLong {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;
}
