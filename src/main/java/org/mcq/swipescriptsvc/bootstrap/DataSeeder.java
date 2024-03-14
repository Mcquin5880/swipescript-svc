package org.mcq.swipescriptsvc.bootstrap;

import lombok.RequiredArgsConstructor;
import org.mcq.swipescriptsvc.entity.AppUser;
import org.mcq.swipescriptsvc.entity.Photo;
import org.mcq.swipescriptsvc.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        userRepository.deleteAll();

        AppUser user1 = AppUser.builder()
                .username("lisa")
                .password(passwordEncoder.encode("password"))
                .authority("ROLE_USER")
                .knownAs("Lisa")
                .gender("female")
                .introduction("Sunt esse aliqua ullamco in incididunt consequat commodo. Nisi ad esse elit ipsum commodo fugiat est ad. Incididunt nostrud incididunt nostrud sit excepteur occaecat.")
                .lookingFor("Dolor anim cupidatat occaecat aliquip et Lorem ut elit fugiat.")
                .interests("Sit sit incididunt proident velit.")
                .city("Greenbush")
                .country("Martinique")
                .dateOfBirth(LocalDate.of(1956, 7, 22))
                .photos(Collections.singletonList(
                        Photo.builder()
                                .url("https://randomuser.me/api/portraits/women/54.jpg")
                                .isMain(true)
                                .publicId("photo1")
                                .build()
                ))
                .build();

        user1.getPhotos().forEach(photo -> photo.setAppUser(user1));

        AppUser user2 = AppUser.builder()
                .username("karen")
                .password(passwordEncoder.encode("password"))
                .authority("ROLE_USER")
                .knownAs("Karen")
                .gender("female")
                .introduction("Laborum dolore aliquip voluptate sunt cupidatat fugiat. Aliqua cillum deserunt do sunt ullamco aute Lorem nisi irure velit esse excepteur ex qui.")
                .lookingFor("Dolor magna eu reprehenderit nostrud do et. Amet voluptate ut laboris ut officia eiusmod exercitation elit labore anim.")
                .interests("Dolor aliquip velit amet aliqua minim labore sit laboris non aliquip cillum.")
                .city("Celeryville")
                .country("Grenada")
                .dateOfBirth(LocalDate.of(1995, 10, 12))
                .photos(Collections.singletonList(
                        Photo.builder()
                                .url("https://randomuser.me/api/portraits/women/50.jpg")
                                .isMain(true)
                                .publicId("photo1")
                                .build()
                ))
                .build();

        user2.getPhotos().forEach(photo -> photo.setAppUser(user2));

        AppUser user3 = AppUser.builder()
                .username("margo")
                .password(passwordEncoder.encode("password"))
                .authority("ROLE_USER")
                .knownAs("Margo")
                .gender("female")
                .introduction("Dolor ut mollit sunt fugiat magna do eu et aliqua. Dolor consectetur reprehenderit irure non adipisicing ad irure sint id amet reprehenderit esse consectetur ex.")
                .lookingFor("Magna consectetur amet sint aliqua cillum proident commodo. Irure aute ad do dolore sunt aliqua sint aliqua sint.")
                .interests("Commodo do eiusmod quis labore est non.")
                .city("Rosewood")
                .country("Svalbard and Jan Mayen Islands")
                .dateOfBirth(LocalDate.of(1959, 1, 24))
                .photos(Collections.singletonList(
                        Photo.builder()
                                .url("https://randomuser.me/api/portraits/women/14.jpg")
                                .isMain(true)
                                .publicId("photo1")
                                .build()
                ))
                .build();

        user3.getPhotos().forEach(photo -> photo.setAppUser(user3));

        AppUser user4 = AppUser.builder()
                .username("lois")
                .password(passwordEncoder.encode("password"))
                .authority("ROLE_USER")
                .knownAs("Lois")
                .gender("female")
                .introduction("Cillum elit nostrud enim laboris pariatur labore ipsum ut. Quis elit irure sint velit laboris anim Lorem laboris.")
                .lookingFor("Dolor est cupidatat dolor cupidatat cillum amet veniam eiusmod aliqua adipisicing aliquip proident adipisicing. Non nulla ex nisi magna ut cillum Lorem ad.")
                .interests("Duis in est laboris anim pariatur incididunt mollit laboris ea velit aliquip cillum.")
                .city("Orviston")
                .country("Zimbabwe")
                .dateOfBirth(LocalDate.of(1988, 6, 22))
                .photos(Collections.singletonList(
                        Photo.builder()
                                .url("https://randomuser.me/api/portraits/women/11.jpg")
                                .isMain(true)
                                .publicId("photo1")
                                .build()
                ))
                .build();

        user4.getPhotos().forEach(photo -> photo.setAppUser(user4));

        AppUser user5 = AppUser.builder()
                .username("ruthie")
                .password(passwordEncoder.encode("password"))
                .authority("ROLE_USER")
                .knownAs("Ruthie")
                .gender("female")
                .introduction("Qui ipsum voluptate exercitation officia nisi velit adipisicing exercitation sint nulla do.")
                .lookingFor("Est quis dolore duis excepteur exercitation reprehenderit ipsum elit aliquip dolor nostrud. Sint incididunt sunt deserunt pariatur pariatur minim velit voluptate.")
                .interests("Elit Lorem aliquip deserunt cupidatat ex aliquip ullamco.")
                .city("Germanton")
                .country("Antigua and Barbuda")
                .dateOfBirth(LocalDate.of(1956, 1, 12))
                .photos(Collections.singletonList(
                        Photo.builder()
                                .url("https://randomuser.me/api/portraits/women/84.jpg")
                                .isMain(true)
                                .publicId("photo1")
                                .build()
                ))
                .build();

        user5.getPhotos().forEach(photo -> photo.setAppUser(user5));

        AppUser user6 = AppUser.builder()
                .username("todd")
                .password(passwordEncoder.encode("password"))
                .authority("ROLE_USER")
                .knownAs("Todd")
                .gender("male")
                .introduction("Mollit elit cillum dolore ea laboris consequat excepteur eiusmod eiusmod qui magna mollit occaecat. Sint qui ut veniam non.")
                .lookingFor("Magna ex non ullamco ipsum commodo minim cupidatat sit. Sint dolor enim amet cupidatat. Anim et ea officia ea officia veniam adipisicing tempor.")
                .interests("Esse cillum deserunt fugiat deserunt irure ea esse deserunt quis exercitation velit do nisi reprehenderit.")
                .city("Cliff")
                .country("British Indian Ocean Territory")
                .dateOfBirth(LocalDate.of(1950, 2, 7))
                .photos(Collections.singletonList(
                        Photo.builder()
                                .url("https://randomuser.me/api/portraits/men/90.jpg")
                                .isMain(true)
                                .publicId("photo1")
                                .build()
                ))
                .build();

        user6.getPhotos().forEach(photo -> photo.setAppUser(user6));

        AppUser user7 = AppUser.builder()
                .username("porter")
                .password(passwordEncoder.encode("password"))
                .authority("ROLE_USER")
                .knownAs("Porter")
                .gender("male")
                .introduction("Qui adipisicing enim mollit magna fugiat. Quis laborum sit adipisicing Lorem veniam magna. Aliqua ex occaecat id duis aute excepteur quis eu eiusmod.")
                .lookingFor("Officia id adipisicing duis culpa aute voluptate Lorem quis aliquip qui. Cupidatat aliquip amet reprehenderit excepteur amet et est dolore est.")
                .interests("Aliquip proident pariatur excepteur incididunt irure et.")
                .city("Welda")
                .country("Christmas Island")
                .dateOfBirth(LocalDate.of(1967, 4, 9))
                .photos(Collections.singletonList(
                        Photo.builder()
                                .url("https://randomuser.me/api/portraits/men/87.jpg")
                                .isMain(true)
                                .publicId("photo1")
                                .build()
                ))
                .build();

        user7.getPhotos().forEach(photo -> photo.setAppUser(user7));

        AppUser user8 = AppUser.builder()
                .username("mayo")
                .password(passwordEncoder.encode("password"))
                .authority("ROLE_USER")
                .knownAs("Mayo")
                .gender("male")
                .introduction("Aliquip labore nisi veniam exercitation sit laborum nisi pariatur dolore tempor irure. Ad officia et eu cupidatat qui irure pariatur qui excepteur dolor ut eiusmod.")
                .lookingFor("Duis tempor amet officia irure amet do ipsum est dolore culpa id Lorem exercitation labore. Cupidatat minim duis nulla occaecat excepteur anim laboris id.")
                .interests("Duis consectetur proident labore velit minim irure proident incididunt officia duis.")
                .city("Clarence")
                .country("Burkina Faso")
                .dateOfBirth(LocalDate.of(1990, 3, 23))
                .photos(Collections.singletonList(
                        Photo.builder()
                                .url("https://randomuser.me/api/portraits/men/57.jpg")
                                .isMain(true)
                                .publicId("photo1")
                                .build()
                ))
                .build();

        user8.getPhotos().forEach(photo -> photo.setAppUser(user8));

        AppUser user9 = AppUser.builder()
                .username("skinner")
                .password(passwordEncoder.encode("password"))
                .authority("ROLE_USER")
                .knownAs("Skinner")
                .gender("male")
                .introduction("Cupidatat dolor irure officia qui consequat ea laborum excepteur esse. Esse qui cupidatat minim laborum velit occaecat officia.")
                .lookingFor("Sunt est cillum nisi officia cupidatat sit ullamco. Labore aliquip pariatur amet velit labore cillum irure dolor. Anim ut cupidatat qui pariatur veniam eu.")
                .interests("Pariatur qui ut commodo laboris officia.")
                .city("Herald")
                .country("Poland")
                .dateOfBirth(LocalDate.of(1952, 12, 1))
                .photos(Collections.singletonList(
                        Photo.builder()
                                .url("https://randomuser.me/api/portraits/men/23.jpg")
                                .isMain(true)
                                .publicId("photo1")
                                .build()
                ))
                .build();

        user9.getPhotos().forEach(photo -> photo.setAppUser(user9));

        AppUser user10 = AppUser.builder()
                .username("davis")
                .password(passwordEncoder.encode("password"))
                .authority("ROLE_USER")
                .knownAs("Davis")
                .gender("male")
                .introduction("Voluptate sunt adipisicing ea nisi ex ullamco veniam dolor. Dolor do et exercitation in. Aute enim pariatur amet commodo.")
                .lookingFor("Do do minim est incididunt minim qui aliqua nulla pariatur culpa pariatur culpa non. Aliquip esse quis ullamco sint voluptate.")
                .interests("Labore consectetur labore ut nulla voluptate nulla quis labore tempor dolor laborum.")
                .city("Lupton")
                .country("Luxembourg")
                .dateOfBirth(LocalDate.of(1978, 3, 20))
                .photos(Collections.singletonList(
                        Photo.builder()
                                .url("https://randomuser.me/api/portraits/men/95.jpg")
                                .isMain(true)
                                .publicId("photo1")
                                .build()
                ))
                .build();

        user10.getPhotos().forEach(photo -> photo.setAppUser(user10));

        userRepository.saveAll(List.of(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10));
    }
}
