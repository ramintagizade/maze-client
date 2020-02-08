package maze.http;



import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class MazeHttpClient {



    public HttpResponse sendGetRequest(String url) {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);

        HttpResponse response;

        try {
            response = client.execute(request);
        }
        catch (Exception e) {
            response = null;
        }

        return response;

    }

    public void sendPostRequest(String url, String value){
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        if (value!=null ) {
            StringEntity entity = new StringEntity(value, ContentType.create("text/plain", "UTF-8"));
            post.setEntity(entity);
        }
        HttpResponse response;
        try {
            response = client.execute(post);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
