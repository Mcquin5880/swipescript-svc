package org.mcq.swipescriptsvc.bootstrap;

import lombok.RequiredArgsConstructor;
import org.mcq.swipescriptsvc.entity.AppUser;
import org.mcq.swipescriptsvc.entity.Photo;
import org.mcq.swipescriptsvc.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) {
        userRepository.deleteAll();

        AppUser user = AppUser.builder()
                .username("johndoe")
                .password("password")
                .authority("ROLE_USER")
                .knownAs("John")
                .gender("Male")
                .introduction("Just a humble programmer.")
                .lookingFor("Friendship")
                .interests("Coding, Skiing")
                .city("New York")
                .country("USA")
                .dateOfBirth(LocalDate.of(1990, 5, 15))
                .photos(Arrays.asList(
                        Photo.builder()
                                .url("http://example.com/photo1.jpg")
                                .isMain(true)
                                .publicId("photo1")
                                .build(),
                        Photo.builder()
                                .url("http://example.com/photo2.jpg")
                                .isMain(false)
                                .publicId("photo2")
                                .build()
                ))
                .build();

        user.getPhotos().forEach(photo -> photo.setAppUser(user));

        AppUser secondUser = AppUser.builder()
                .username("janedoe")
                .password("password")
                .authority("ROLE_USER")
                .knownAs("Jane")
                .gender("Female")
                .introduction("Enthusiast of outdoor adventures and photography.")
                .lookingFor("Networking")
                .interests("Hiking, Photography")
                .city("San Francisco")
                .country("USA")
                .dateOfBirth(LocalDate.of(1992, 8, 24))
                .photos(Arrays.asList(
                        Photo.builder()
                                .url("http://example.com/photo3.jpg")
                                .isMain(true)
                                .publicId("photo3")
                                .build(),
                        Photo.builder()
                                .url("http://example.com/photo4.jpg")
                                .isMain(false)
                                .publicId("photo4")
                                .build(),
                        Photo.builder()
                                .url("http://example.com/photo5.jpg")
                                .isMain(false)
                                .publicId("photo5")
                                .build()
                ))
                .build();

        secondUser.getPhotos().forEach(photo -> photo.setAppUser(secondUser));

        userRepository.save(user);
        userRepository.save(secondUser);
    }
}
