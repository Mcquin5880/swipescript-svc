package org.mcq.swipescriptsvc.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhotoDto {

    private Long id;
    private String url;
    private boolean isMain;
}
