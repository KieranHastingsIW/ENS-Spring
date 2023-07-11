package nz.govt.tewhatuora.ens.Entity;

import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;




@RequiredArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "new_table_for_test")
public class RLS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long EventTransactionId;
    
    @NonNull
    @Column(name = "resource_type", nullable = false)
    private String ResourceType;
    
    @NonNull
    @Column(name = "source", nullable = false)
    private String Source;

    @NonNull
    @Column(name = "role_id", nullable = true)
    private String RoleId;

    @NonNull
    @Column(name = "event_received_date", nullable = false)
    private String EventReceivedDate;
    
    @NonNull
    @Column(name = "url", nullable = false)
    private String URL;

    @NonNull
    @Column(name = "status", nullable = false)
    private String Status;
}






