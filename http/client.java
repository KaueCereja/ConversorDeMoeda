package http;

import com.google.gson.Gson;
import moedas.moeda;
import moedas.moedaApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class client {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite a moeda desejada: ");
        String MoedaDesejada = teclado.next();
        System.out.println(MoedaDesejada);


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/a170c7b103854ce38b4e201f/latest/" + MoedaDesejada))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(response.body());

        Gson gson = new Gson();

        moedaApi moedaApi = gson.fromJson(json, moedaApi.class);

        System.out.println(moedaApi);




    }
}
