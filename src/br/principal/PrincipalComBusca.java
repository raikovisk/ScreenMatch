package br.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Informe o filme para buscar: ");
        var busca = leitura.hasNextLine();
        var URL = "https://www.omdbapi.com/?t=" + busca + "&apikey=27ce6fd6";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        
        String json = response.body();
        System.out.println("JSON: "+json);

        Gson gson = new Gson();
        Titulo tituloOMDB = gson.fromJson(json, Titulo.class);
        System.out.println("Titulo OMDB: " + tituloOMDB.getNome());


    }
}
