package org.mcq.swipescriptsvc.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Photos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    private Boolean isMain;
    private String publicId;

    @ManyToOne
    private AppUser appUser;
}
