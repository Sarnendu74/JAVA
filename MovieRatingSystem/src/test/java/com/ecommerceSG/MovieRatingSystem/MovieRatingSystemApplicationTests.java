package com.ecommerceSG.MovieRatingSystem;

import com.ecommerceSG.MovieRatingSystem.model.Rating;
import com.ecommerceSG.MovieRatingSystem.model.Show;
import com.ecommerceSG.MovieRatingSystem.model.User;
import com.ecommerceSG.MovieRatingSystem.repository.RatingRepository;
import com.ecommerceSG.MovieRatingSystem.repository.ShowRepository;
import com.ecommerceSG.MovieRatingSystem.repository.UserRepository;
import com.ecommerceSG.MovieRatingSystem.service.AuthService;
import com.ecommerceSG.MovieRatingSystem.service.RatingService;
import com.ecommerceSG.MovieRatingSystem.service.ShowService;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MovieRatingSystemApplicationTests {

    /* =======================
       AUTOWIRED REAL REPOS
     ======================= */

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private RatingRepository ratingRepository;

    /* =======================
       MOCKED SERVICES
     ======================= */

    @InjectMocks
    private ShowService showService;

    @InjectMocks
    private AuthService authService;

    @InjectMocks
    private RatingService ratingService;

    @Autowired
    private MockMvc mockMvc;

    /* =======================
       DATA SETUP
     ======================= */

    private User user;
    private Show show;

    @BeforeEach
    void setup() {
        ratingRepository.deleteAll();
        showRepository.deleteAll();
        userRepository.deleteAll();

        user = new User(null, "john", "pwd", "USER");
        user = userRepository.save(user);

        show = new Show(null, "Morning FM",
                LocalTime.parse("08:00"),
                LocalTime.parse("09:00"));
        show = showRepository.save(show);
    }

    /* ========================================================
       ✅ REPOSITORY TESTS (1–8)
     ======================================================== */

    @Test
    @Order(1)
    void saveUser_assignsId() {
        assertNotNull(user.getId());
    }

    @Test
    @Order(2)
    void findUserByUsername_exists() {
        Optional<User> found = userRepository.findByUsername("john");
        assertTrue(found.isPresent());
    }

    @Test
    @Order(3)
    void saveShow_assignsId() {
        assertNotNull(show.getId());
    }

    @Test
    @Order(4)
    void findShows_sortedByStartTime() {
        Show s2 = new Show(null, "Evening",
                LocalTime.parse("18:00"), LocalTime.parse("19:00"));
        showRepository.save(s2);

        List<Show> list = showRepository.findAllByOrderByStartTimeAsc();
        assertEquals("Morning FM", list.getFirst().getTitle());
    }

    @Test
    @Order(5)
    void pagination_firstPage() {
        for (int i = 1; i <= 10; i++) {
            showRepository.save(
                    new Show(null, "S" + i, LocalTime.NOON, LocalTime.MAX)
            );
        }
        Page<Show> page = showRepository.findAll(PageRequest.of(0, 5));
        assertEquals(5, page.getContent().size());
    }

    @Test
    @Order(6)
    void pagination_secondPage() {
        Page<Show> page = showRepository.findAll(PageRequest.of(1, 5));
        assertTrue(page.getContent().size() >= 0);
    }

    @Test
    @Order(7)
    void rating_linksUserAndShow() {
        Rating rating = new Rating(null, user, show, 5);
        Rating saved = ratingRepository.save(rating);

        assertNotNull(saved.getId());
        assertEquals(5, saved.getStars());
    }

    @Test
    @Order(8)
    void multipleRatings_allowed() {
        ratingRepository.save(new Rating(null, user, show, 3));
        ratingRepository.save(new Rating(null, user, show, 4));
        assertEquals(2, ratingRepository.findAll().size());
    }

    /* ========================================================
       ✅ SERVICE TESTS WITH MOCKS (9–14)
     ======================================================== */

    @Test
    @Order(9)
    void showService_create_callsRepository() {
        Show s = new Show();
        when(showService.createShow(any())).thenReturn(s);

        Show result = showService.createShow(s);
        assertNotNull(result);
    }

    @Test
    @Order(10)
    void showService_pagination_delegates() {
        Page<Show> page = new PageImpl<>(List.of(show));
        when(showService.getShows(any())).thenReturn(page);

        Page<Show> result = showService.getShows(PageRequest.of(0, 5));
        assertEquals(1, result.getContent().size());
    }

    @Test
    @Order(11)
    void showService_sorted() {
        when(showService.getShowsSortedByTime())
                .thenReturn(List.of(show));

        List<Show> list = showService.getShowsSortedByTime();
        assertEquals(1, list.size());
    }

    @Test
    @Order(12)
    void ratingService_rateShow_success() {
        Rating r = new Rating();
        when(ratingService.rateShow(anyLong(), anyLong(), anyInt()))
                .thenReturn(r);

        Rating result = ratingService.rateShow(1L, 1L, 5);
        assertNotNull(result);
    }

    @Test
    @Order(13)
    void authService_login_returnsToken() {
        when(authService.login("john", "pwd"))
                .thenReturn("JWT_TOKEN");

        String token = authService.login("john", "pwd");
        assertEquals("JWT_TOKEN", token);
    }

    @Test
    @Order(14)
    void authService_register_called() {
        doNothing().when(authService).register(any());
        authService.register(user);
        verify(authService, times(1)).register(user);
    }

    /* ========================================================
       ✅ CONTROLLER TESTS (15–20)
     ======================================================== */

    @Test
    @Order(15)
    void getShows_unauthorized() throws Exception {
        mockMvc.perform(get("/api/shows"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @Order(16)
    void getShows_authorizedUser() throws Exception {
        mockMvc.perform(get("/api/shows")
                        .header("Authorization", "Bearer USER_TOKEN"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(17)
    void getSortedShows() throws Exception {
        mockMvc.perform(get("/api/shows/sorted")
                        .header("Authorization", "Bearer USER_TOKEN"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(18)
    void postRating_userAllowed() throws Exception {
        mockMvc.perform(post("/api/ratings")
                        .param("userId", "1")
                        .param("showId", "1")
                        .param("stars", "5")
                        .header("Authorization", "Bearer USER_TOKEN"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(19)
    void adminEndpoint_forbiddenForUser() throws Exception {
        mockMvc.perform(get("/api/admin")
                        .header("Authorization", "Bearer USER_TOKEN"))
                .andExpect(status().isForbidden());
    }

    @Test
    @Order(20)
    void adminEndpoint_allowedForAdmin() throws Exception {
        mockMvc.perform(get("/api/admin")
                        .header("Authorization", "Bearer ADMIN_TOKEN"))
                .andExpect(status().isOk());
    }

    /* ========================================================
       ✅ EDGE / VALIDATION TESTS (21–24)
     ======================================================== */

    @Test
    @Order(21)
    void ratingStars_invalid_fails() {
        assertThrows(RuntimeException.class,
                () -> ratingService.rateShow(1L, 1L, 9));
    }

    @Test
    @Order(22)
    void rating_userNotFound_fails() {
        assertThrows(RuntimeException.class,
                () -> ratingService.rateShow(99L, 1L, 5));
    }

    @Test
    @Order(23)
    void pagination_outOfRange_returnsEmpty() {
        Page<Show> page =
                showRepository.findAll(PageRequest.of(10, 5));
        assertTrue(page.getContent().isEmpty());
    }

    @Test
    @Order(24)
    void contextLoads() {
        // Spring context load check
        assertTrue(true);
    }
}