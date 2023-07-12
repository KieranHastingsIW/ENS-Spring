package nz.govt.tewhatuora.ens.Services;


import org.springframework.http.HttpStatus;



public interface GpService {
    String json(String string);
    HttpStatus email(String string);
    void db(String payload);

}
