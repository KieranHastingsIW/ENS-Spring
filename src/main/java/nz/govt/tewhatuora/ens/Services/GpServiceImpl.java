package nz.govt.tewhatuora.ens.Services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nz.govt.tewhatuora.ens.Entity.Cache;
import nz.govt.tewhatuora.ens.Entity.RLS;
import nz.govt.tewhatuora.ens.Repository.CacheRepository;
import nz.govt.tewhatuora.ens.Repository.RLSRepository;

import java.util.Base64;

@Service
@AllArgsConstructor
public class GpServiceImpl implements GpService {
    CacheRepository cacheRepository;
    RLSRepository rLSRepository;
    
    @Override
    public String json(String string) {
        throw new UnsupportedOperationException("Unimplemented method 'json'");
    }

    @Override
    public String email(String string) {
        apiRequest();
        return string;
    }

    public String apiRequest(){  // String email, String gp
        String originalInput = "test input";
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        String requestBody = "{\"from\": \"Sender@ketewaiora.nz\",\"to\": \"kiehast@gmail.com\",\"subject\":\"Has received an updated annual Practicing certifiate\",\"contentType\": \"text/plain\",\"content\": \" " + encodedString +"\"}" ;
        HttpRequest request = HttpRequest.newBuilder()
                .header("Authorization","Bearer eyJ4NXQiOiJNV0l5TkRJNVlqRTJaV1kxT0RNd01XSTNOR1ptTVRZeU5UTTJOVFZoWlRnMU5UTTNaVE5oTldKbVpERTFPVEE0TldFMVlUaGxNak5sTldFellqSXlZUSIsImtpZCI6Ik1XSXlOREk1WWpFMlpXWTFPRE13TVdJM05HWm1NVFl5TlRNMk5UVmhaVGcxTlRNM1pUTmhOV0ptWkRFMU9UQTROV0UxWVRobE1qTmxOV0V6WWpJeVlRX1JTMjU2IiwidHlwIjoiYXQrand0IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiI2N2E4Mzk2Mi1hNWQ5LTQ4MDMtOWEzMy05ZjZkZDg3N2Y1NzQiLCJhdXQiOiJBUFBMSUNBVElPTiIsImF1ZCI6IkE0Z1pqUktGTzlTRWNaOGY2Zno2S2tKNVVPTWEiLCJuYmYiOjE2ODkwMjg1MDIsImF6cCI6IkE0Z1pqUktGTzlTRWNaOGY2Zno2S2tKNVVPTWEiLCJzY29wZSI6ImRlZmF1bHQiLCJpc3MiOiJodHRwczpcL1wvYW0uMi5ucGUua2V0ZXdhaW9yYS5pcGFhcy5uejo0NDNcL29hdXRoMlwvdG9rZW4iLCJleHAiOjE2ODkxMDA1MDIsImlhdCI6MTY4OTAyODUwMiwianRpIjoiZmFkNTM3MWYtZDllYS00YjUyLWI4YzUtN2I0YWRmMGZkYmJmIiwiY2xpZW50X2lkIjoiQTRnWmpSS0ZPOVNFY1o4ZjZmejZLa0o1VU9NYSJ9.c6DJ5ZO6eAZeMNWW8ph_xrfWVM0Ltz6FjyWOcRCMVN5kld8vMYUQMPfCiNT7Z92blZsV9QG06DScJ4Djw5XBX45-W7PlJgAFssaV2q0FCGuoShG1Myyr-V6P7d7Xcy21zdF1R3D7R8bvfacG9qYi16l2fyqh2vr22R36lJcuE2wd0_LV7cYW8PGjVLa533QUH0cXfkzXS1UVOd2uxyqkRrEbW2to2e_qHiGm7q1O2brZ0yMR_iCxwBVpfmsWPrs34MEI4i8-z13FOMbpH7A5Vr2pytDZqf48ACi-oWPJpm1gyv5wXkFK32tp42bWhoLomvbAAbaq6mQseHsdNtL4KQ")
                .header("Content-Type", "application/json")
                .uri(URI.create("https://amgw.2.npe.ketewaiora.ipaas.nz:443/smtp/1.0.0/send"))
                .method("POST", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response.body().toString();
    }

    @Override
    public void db(RLS payload) {
        rLSRepository.save(payload);
    }




    
}
