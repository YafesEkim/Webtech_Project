package de.htwberlin.Webtechnologien.web;


import de.htwberlin.Webtechnologien.service.FirmaService;
import de.htwberlin.Webtechnologien.web.api.Firma;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FirmaRestController.class)
class FirmaRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FirmaService firmaService;


    @Test
    @DisplayName("Test")
    void fetchLessons() throws Exception {


        var firmen = List.of(
                new Firma(1, "YM AG", "Kudamm", "4523452", null),
                new Firma(2, "YM GmbH", "Kreuzberg", "3245245", null)
        );

        doReturn(firmen).when(firmaService).findAll();
        mockMvc.perform(get("/api/v1/firma"))
                .andExpect(status().isOk())

                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].firmaName").value("YM AG"))
                .andExpect(jsonPath("$[0].address").value("Kudamm"))
                .andExpect(jsonPath("$[0].ust_id").value("4523452"))

                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].firmaName").value("YM GmbH"))
                .andExpect(jsonPath("$[1].address").value("Kreuzberg"))
                .andExpect(jsonPath("$[1].ust_id").value("3245245"));
    }
    @Test
    @DisplayName("should return 404 if firma is not found")
    void should_return_404_if_firma_is_not_found() throws Exception {
        // given
        doReturn(null).when(firmaService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/firma/123"))
                // then
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating a firma")
    void should_return_201_http_status_and_location_header_when_creating_a_firma() throws Exception {
        // given
        String firmaToCreateAsJson = "{\"firmaName\": \"YM AG\", \"address\":\"Kurfürstendamm\", \"ust_id\": \"1345\"}";
        var firma = new Firma(123, null, null, null,  null);
        doReturn(firma).when(firmaService).create(any());

        // when
        mockMvc.perform(
                        post("/api/v1/firma")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(firmaToCreateAsJson)
                )
                // then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/firma/" + firma.getId()))));
//            .andExpect(header().string("Location", Matchers.containsString(Long.toString(firma.getId()))));

    }

    /*@Test
    @DisplayName("should validate create firma request")
    void should_validate_create_firma_request() throws Exception {
        // given
        String firmaToCreateAsJson = "{\"firmaName\": \"YM AG\", \"address\":\"Kurfürstendamm\", \"ust_id\": \"12345\"}";

        // when
        mockMvc.perform(
                        post("/api/v1/firma")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(firmaToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());
    }*/
}
