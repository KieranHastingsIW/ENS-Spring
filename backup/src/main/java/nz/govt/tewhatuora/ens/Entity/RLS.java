package nz.govt.tewhatuora.ens.Entity;

import lombok.*;

import java.time.LocalDate;

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
@Table(name = "RLS")
public class RLS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long EventTransactionId;
    
    @NonNull
    @Column(name = "ResourceType", nullable = false)
    private String ResourceType;
    
    @NonNull
    @Column(name = "Source", nullable = false)
    private String Source;

    @NonNull
    @Column(name = "RoleId", nullable = true)
    private String RoleId;


    @Column(name = "EventReceivedDate", nullable = false)
    private LocalDate EventReceivedDate;
    
    @NonNull
    @Column(name = "URL", nullable = false)
    private String URL;

    @NonNull
    @Column(name = "Status", nullable = false)
    private String Status;
}






