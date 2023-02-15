package com.uax.accesodatos.AppFutbolApi.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

@Component
public class AppFutbolUtils {

	@Value("${api.key}")
	private String apiKey;
	
	public String getResponseToAPIFootball(String uri) throws IOException, InterruptedException {
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(uri))
				.header("X-RapidAPI-Key", apiKey)
				.header("X-RapidAPI-Host", "v3.football.api-sports.io")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		
		return response.body();
	}
	
	 public static String readFile(String file) throws IOException {

		    Resource resource = new ClassPathResource(file);

		    InputStream inputStream = resource.getInputStream();

		    byte[] dataAsBytes = FileCopyUtils.copyToByteArray(inputStream);

		    String data = new String(dataAsBytes, StandardCharsets.UTF_8);

		    return data;

		  }
	
}
