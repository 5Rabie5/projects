//package at.nacs.drhousediagnoses.logic;
//
//import org.apache.tomcat.util.codec.binary.Base64;
//import org.springframework.http.HttpHeaders;
//
//import java.nio.charset.Charset;
//
//public class AuthorizationCreater {
//  HttpHeaders createHeaders(String username, String password) {
//    return new HttpHeaders() {{
//      String auth = username + ":" + password;
//      byte[] encodedAuth = Base64.encodeBase64(
//          auth.getBytes(Charset.forName("US-ASCII")));
//      String authHeader = "Basic " + new String(encodedAuth);
//      set("Authorization", authHeader);
//    }};
//  }
//}
