package nz.govt.tewhatuora.ens.Services;

import nz.govt.tewhatuora.ens.Entity.RLS;

public interface GpService {
    String json(String string);
    String email(String string);
    void db(RLS payload);

}
