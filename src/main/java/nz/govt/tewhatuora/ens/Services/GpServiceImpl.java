package nz.govt.tewhatuora.ens.Services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
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
    public HttpStatus email(String email) {

        HttpStatus emailResponse = apiRequest(email);
        return emailResponse;
    }

    public HttpStatus apiRequest(String email){  // String email, String gp
        String originalInput = "test input";
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        System.out.println(email);
        String requestBody = "{\"from\": \"Sender@ketewaiora.nz\",\"to\": \"" + email +"\",\"subject\":\"Has received an updated annual Practicing certifiate\",\"contentType\": \"text/plain\",\"content\": \" " + encodedString +"\"}" ;
        System.out.println(requestBody);
        HttpRequest request = HttpRequest.newBuilder()
                .header("Authorization","Bearer eyJ4NXQiOiJNV0l5TkRJNVlqRTJaV1kxT0RNd01XSTNOR1ptTVRZeU5UTTJOVFZoWlRnMU5UTTNaVE5oTldKbVpERTFPVEE0TldFMVlUaGxNak5sTldFellqSXlZUSIsImtpZCI6Ik1XSXlOREk1WWpFMlpXWTFPRE13TVdJM05HWm1NVFl5TlRNMk5UVmhaVGcxTlRNM1pUTmhOV0ptWkRFMU9UQTROV0UxWVRobE1qTmxOV0V6WWpJeVlRX1JTMjU2IiwidHlwIjoiYXQrand0IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJhYjk1YTUxYy0wODVjLTQyZDgtYTUzNS02NDcyZDZhNTQyZTgiLCJhdXQiOiJBUFBMSUNBVElPTiIsImF1ZCI6ImJGcHpmZnZkMUlmdnBmZ3RTb3E0MHhyQmRCQWEiLCJuYmYiOjE2ODkxMjE0MTksImF6cCI6ImJGcHpmZnZkMUlmdnBmZ3RTb3E0MHhyQmRCQWEiLCJzY29wZSI6ImRlZmF1bHQiLCJpc3MiOiJodHRwczpcL1wvYW0uMi5ucGUua2V0ZXdhaW9yYS5pcGFhcy5uejo0NDNcL29hdXRoMlwvdG9rZW4iLCJleHAiOjE2OTYzMjE0MTksImlhdCI6MTY4OTEyMTQxOSwianRpIjoiZjNmMzgxZDAtNmZjNi00YmVhLWI3YjgtOGRhYmQxODRmNDAzIiwiY2xpZW50X2lkIjoiYkZwemZmdmQxSWZ2cGZndFNvcTQweHJCZEJBYSJ9.PNF0oLiAkkmGzHx5weiSIaaLgGdayUIFyig3CZylbFKsqRpjYk6fop2jhf4LUb7p1xkzeSmgxB0PMzHJXOjFwAchzFLYQ7xdWr2KzFxTSniRQEftAwaQ0I8Sz3HskOZsinMLhql6A1rzKlKQ5sIxBZE4tq95gOor66_wF-r4FvinuPPTV75Zj-OAeRxUYhL9p_zo9Ur_zQXzXYcndwnwmmh4YBROKvIinwua3Mdt8a8BpkooRu5N3tQBJxQy2-k8-NQHSnOSDRpVfkRW-H7LJSxAashLQpZDfrW6hP1AtIRO0BvpsCfj8yDWANgi9rGB2PXf5ECWCYSNf5yVsDwjFg")
                .header("Content-Type", "application/json")
                .uri(URI.create("https://amgw.2.npe.ketewaiora.ipaas.nz:443/smtp/1.0.0/send"))
                .method("POST", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            if (response.statusCode() == 500){
                return HttpStatus.GATEWAY_TIMEOUT;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return HttpStatus.OK;
    }

    @Override
    public void db(String rlsString) {
        // String filter = dBfilterMethod(rlsString);
        // System.out.println(rlsString);

        //String[] payload is a list of all values sent in the use casses only 4 items passed
        // not sure which items are to be defined by the filtering 
        // duplicate everything here for the Cache section
        String[] payload = rlsString.split(",");
        RLS rlsPayload = new RLS();
        rlsPayload.setResourceType(payload[0]);
        rlsPayload.setSource(payload[1]);
        rlsPayload.setRoleId(payload[2]);
        LocalDate parse = LocalDate.parse(payload[3]);
        rlsPayload.setEventReceivedDate(parse);
        rlsPayload.setURL(payload[4]);
        rlsPayload.setStatus(payload[5]);
        rLSRepository.save(rlsPayload);

    }

    public String dBfilterMethod(String messageObject){
     
        return messageObject;
    }




    
}
