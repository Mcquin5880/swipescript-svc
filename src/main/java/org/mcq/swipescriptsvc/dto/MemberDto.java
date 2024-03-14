package org.mcq.swipescriptsvc.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class MemberDto {

    private Long id;

    private String username;
    private String knownAs;
    private String gender;
    private int age;
    private String introduction;
    private String lookingFor;
    private String interests;
    private String city;
    private String country;
    private String photoUrl;

    private List<PhotoDto> photos;

    @CreationTimestamp
    private Instant created;

    @UpdateTimestamp
    private Instant lastActive;
}
