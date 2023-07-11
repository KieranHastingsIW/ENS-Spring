package nz.govt.tewhatuora.ens.Entity;

import lombok.*;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Cache")
public class Cache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long EventTransactionId;
    
    
    @Column(name = "resource_type", nullable = false)
    private String ResourceType;
    
    
    @Column(name = "source", nullable = false)
    private String Source;

    
    @Column(name = "role_id", nullable = false)
    private String RoleId;

    
    @Column(name = "event_received_date", nullable = false)
    private String EventReceivedDate;
    
    
    @Column(name = "url", nullable = false)
    private String URL;

    
    @Column(name = "status", nullable = false)
    private String Status;
}