package com.codecool.seriesapp.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false , unique = true)
    private String username;

    private LocalDate birthDate;

    private String email;

    @Singular("series")
    @OneToMany(mappedBy = "member" , cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private Set<FavouriteSeries> favouriteSeries;

}
