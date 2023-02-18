import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class HttpURLConPostRequest {
    private static HttpURLConnection con;
    public static void main(String[] args) throws IOException {
        try{
            String url = "https://test.server.com/";
            String form = "RegNo=" + encodeURIStr("ADH00000184");
            form += "&MobileNo=" + encodeURIStr("7878745445");

            byte[] postData = form.getBytes(StandardCharsets.UTF_8);
            try {
                URL myurl = new URL(url);
                con = (HttpURLConnection) myurl.openConnection();
                con.setDoOutput(true);
                con.setRequestMethod("POST");
                con.setRequestProperty("User-Agent", "Java client");
                con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//                con.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VySWQiOjEwMTk3LCJJc1NhbmRib3giOnRydWUsImlhdCI6MTY3NjY5MzgwMSwiZXhwIjoxNjc2Njk0MTAxfQ.HbKco-oJjZhe9UWBNXn7izAxaLkpOQuWHrDuV81U80o");
                try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                    wr.write(postData);
                }

                StringBuilder content;
                String line;
                if( con.getResponseCode() == 200 ) {
                    try (BufferedReader br = new BufferedReader( new InputStreamReader(con.getInputStream()))) {
                        content = new StringBuilder();
                        while ((line = br.readLine()) != null) {
                            content.append(line);
                            content.append(System.lineSeparator());
                        }
                    }
                }
                else{
                    try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getErrorStream()))) {
                        content = new StringBuilder();
                        while ((line = br.readLine()) != null) {
                            content.append(line);
                            content.append(System.lineSeparator());
                        }
                    }
                }
                System.out.println(content.toString());
            }catch (Exception e){
                System.out.println("e = " + e);
            }
        } finally {
            con.disconnect();
        }
    }

    public static String encodeURIStr(String s){
        try {
            return URLEncoder.encode(s, "UTF-8");
        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return "";
    }
}