package com.example.insuranceprototype.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class BackupAgentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long clientId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "clientId", insertable = false, updatable = false)
    private ClientMaintainPersonal client;

    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateAppointed;

    private String exclusive;
    private Boolean previousAgent;

    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate prevDateOfTermination;

    private Long previousAgentId;

    private String distributionChannel;
    private String areaCode;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long agentType;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "agentType", insertable = false, updatable = false)
    private AgentTypeLevel agentTypeLevel;


    private String payMethod;
    private String payFrequency;
    private String currencyType;
    private String minimumAmount;

    private String bonusAllocation;

    private String basicCommission;
    private String renewalCommission;
    private String servicingCommission;
    private String commissionClass;

    private Long upLevelAgentId;

    private Long officeId;

    private int validFlag;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @UpdateTimestamp
    private LocalDateTime modifiedDate;
}
