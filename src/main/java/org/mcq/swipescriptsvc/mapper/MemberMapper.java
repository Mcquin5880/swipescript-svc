package org.mcq.swipescriptsvc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mcq.swipescriptsvc.dto.MemberDto;
import org.mcq.swipescriptsvc.entity.AppUser;
import org.mcq.swipescriptsvc.entity.Photo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Mapper
public interface MemberMapper {

    // todo enable after updating dto's
    @Mappings({
            //@Mapping(target = "age", expression = "java(calculateAge(appUser.getDateOfBirth()))"),
            @Mapping(target = "photoUrl", expression = "java(getMainPhotoUrl(appUser.getPhotos()))")
    })
    MemberDto toMemberDto(AppUser appUser);

    AppUser toAppUser(MemberDto memberDto);

    default int calculateAge(LocalDate dateOfBirth) {
        return (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }

    default String getMainPhotoUrl(List<Photo> photos) {
        if (photos == null || photos.isEmpty()) {
            return null;
        }
        return photos.stream()
                .filter(Photo::getIsMain)
                .findFirst()
                .map(Photo::getUrl)
                .orElse(null);
    }
}
