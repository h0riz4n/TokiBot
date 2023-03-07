package WebApp.WebSite.toki_api;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class Bot
{
    private static String BOT_TOKEN;

    static
    {
        BOT_TOKEN = System.getenv("BOT_TOKEN");
    }

    public static void sendMessage(long id) throws Exception {
        String chat_id = String.valueOf(id);
        String method = "/sendMessage";
        String url = "https://api.telegram.org/bot" + BOT_TOKEN + method;
        String text = "You have been already added✅";

        HttpPost post = new HttpPost(url);

        // request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("chat_id", chat_id));
        urlParameters.add(new BasicNameValuePair("text", text));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        // sendPost to url
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }

    public static void sendSticker(long chat_id) throws Exception {
        String id = String.valueOf(chat_id);
        String method = "/sendSticker";
        String url = "https://api.telegram.org/bot" + BOT_TOKEN + method;
        String stickerId = "CAACAgIAAxkBAAEH-5xkAj2zdfrCWFiFjyY7YScq4_veZAACVB0AAoqR0ElUTMG-FBDOOy4E";

        HttpPost post = new HttpPost(url);

        // request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("chat_id", id));
        urlParameters.add(new BasicNameValuePair("sticker", stickerId));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        // sendPost to url
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            System.out.println(EntityUtils.toString(response.getEntity()));
        }

    }
}
