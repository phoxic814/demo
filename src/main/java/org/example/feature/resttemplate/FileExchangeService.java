package org.example.feature.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;

/**
 * simple file invoke by rest template
 */
public class FileExchangeService {

    // sample url
    private static String url = "http://img.championat.com/news/big/l/c/ujejn-runi_1439911080563855663.jpg";

    @Autowired
    private RestTemplate restTemplate;

    public void restI() throws IOException {
        byte[] imageBytes = restTemplate.getForObject(url, byte[].class);
        Files.write(Paths.get("image.jpg"), imageBytes);
    }

    public void restII() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);
        Files.write(Paths.get("demo1.jpg"), response.getBody());
    }

    public void restIII() {
        RequestCallback requestCallback = request -> request
                .getHeaders()
                .setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));

        // Streams the response instead of loading it all in memory
        ResponseExtractor<Void> responseExtractor = response -> {
            // Here you can write the inputstream to a file or any other place
            Path path = Paths.get("downloadv3.jpg");
            Files.copy(response.getBody(), path);
            return null;
        };

        restTemplate.execute(url, HttpMethod.GET, requestCallback, responseExtractor);
    }

    public void invokeI() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("cookie", "test");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);

        try {
            if (response.getStatusCode() != HttpStatusCode.valueOf(200)) {
                throw new Exception("api not 200");
            }

            if (response.getBody() == null) {
                System.out.println("filePath error:" + url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
