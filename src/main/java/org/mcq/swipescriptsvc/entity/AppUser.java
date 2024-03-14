package org.mcq.swipescriptsvc.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String authority;
    private String knownAs;
    private String gender;
    private String introduction;
    private String lookingFor;
    private String interests;
    private String city;
    private String country;
    private LocalDate dateOfBirth;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appUser", orphanRemoval = true)
    private List<Photo> photos;

    @CreationTimestamp
    private Instant created;

    @UpdateTimestamp
    private Instant lastActive;

}
