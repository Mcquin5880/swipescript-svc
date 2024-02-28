package org.mcq.swipescriptsvc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private boolean isMain;
    private String publicId;

    @ManyToOne
    // todo remove this annotation if possible after debugging
    @JsonBackReference
    private AppUser appUser;
}
