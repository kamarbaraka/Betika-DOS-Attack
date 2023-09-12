package requests;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * the http/2 registration request to betika.
 * @author kamar baraka.*/

public class RegistrationRequest {

    public void sendRegistrationRequest(){

        /*construct a http client*/
        HttpClient client = HttpClient.newBuilder().build();

        /*construct the request*/
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://trk.elephantmob.com/a/tk/s"))
                .version(HttpClient.Version.HTTP_2)
                .header("Cache-Control", "no- cache")
                .header("Content-Type", "application/json")
                .header("Origin", "https://www.betika.com")
                .header("pragma", "no-cache")
                .header("Referer", "https://www.betika.com/")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "cross-site")
                .header("User-Agent", "Mozilla/5.0")
                .POST(BodyPublishers.ofString(
                        "{\"bw\":\"chrome\"," +
                                "\"conn\":4," +
                                "\"hs\":\"www.betika.com\"," +
                                "\"aid\":\"ac7db7e590056a5201d58d6075dde55c\"," +
                                "\"an\":\"RegistrationFinished\"," +
                                "\"lang\":\"en-US\"," +
                                "\"mb\":1," +
                                "\"pid\":\"14cf1a38-af07-b524-04a4-0244a050bbac\"," +
                                "\"pr\":2," +
                                "\"pvc\":1," +
                                "\"ref\":\"https://www.bing.com\"," +
                                "\"sh\":921," +
                                "\"sw\":924," +
                                "\"ua\":\"Mozilla/5.0\"," +
                                "\"uuid\":\"5a530d18-fca2-4ea3-81bc-f961e9763089\"," +
                                "\"sv\":\"0.0.2\"," +
                                "\"mn\":\"Betika,Jackpot, Todays games, this week jackpot. bingwa, bet, multibet\"," +
                                "\"up\":\"next=%2F\"," +
                                "\"ts\":148000}"
                )).build();

        /*send the request and get the response*/
        try
        {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            /*print out the response*/
            System.out.println(response.statusCode());
            System.out.println(response.body());

        }
        catch (Exception exception){

            /*print out */
            exception.printStackTrace();
        }

    }

    public static void main(String[] args) {

        /*create the registration request*/
        RegistrationRequest request = new RegistrationRequest();

        while (true)
        {/*send the request and get the response*/
            request.sendRegistrationRequest();
        }
    }
}
