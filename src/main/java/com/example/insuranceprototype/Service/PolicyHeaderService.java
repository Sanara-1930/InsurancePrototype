package com.example.insuranceprototype.Service;

import com.example.insuranceprototype.Entity.PolicyHeader;
import com.example.insuranceprototype.Repository.PolicyHeaderRepository;
import com.example.insuranceprototype.error.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyHeaderService {


    @Autowired
    private PolicyHeaderRepository repository;

    @Autowired
    private ErrorService errorService;


    public List<PolicyHeader> getAllPolicyHeader(){
        return repository.getAllValid();
    }

    public PolicyHeader getPolicyHeader(Long id){
        return repository.findById(id).get();
    }

    public String addPolicyHeader(PolicyHeader policyHeader){
        policyHeader.setIsActive(1);
        repository.save(policyHeader);
        return errorService.getErrorById("ER001");
    }

    public String clonePolicyHeader(PolicyHeader policyHeader){
        PolicyHeader policyHeader1 = new PolicyHeader();
        policyHeader1.setPolicyNumber(policyHeader.getPolicyNumber());
        policyHeader1.setCompanyId(policyHeader.getCompanyId());
        policyHeader1.setAgentId(policyHeader.getAgentId());
        policyHeader1.setPremium(policyHeader.getPremium());
        policyHeader1.setCoveragePolicyStatusId(policyHeader.getCoveragePolicyStatusId());
        policyHeader1.setCoverageStatusId(policyHeader.getCoverageStatusId());
        policyHeader1.setStartDate(policyHeader.getStartDate());
        policyHeader1.setBillDate(policyHeader.getBillDate());
        policyHeader1.setPaidDate(policyHeader.getPaidDate());
        policyHeader1.setCurrency(policyHeader.getCurrency());
        policyHeader1.setProductId(policyHeader.getProductId());
        return addPolicyHeader(policyHeader1);
    }

    public String updatePolicyHeader(Long id, PolicyHeader newOne){

        PolicyHeader oldOne = repository.getById(id);

        if(newOne.getCompanyId() != null){
            oldOne.setCompanyId(newOne.getCompanyId());
        }

        if(newOne.getAgentId() != null){
            oldOne.setAgentId(newOne.getAgentId());
        }

        if(newOne.getPolicyNumber() != null){
            oldOne.setPolicyNumber(newOne.getPolicyNumber());
        }

        if(newOne.getPremium() != null){
            oldOne.setPremium(newOne.getPremium());
        }

        if(newOne.getCoverageStatusId() != null){
            oldOne.setCoverageStatusId(newOne.getCoverageStatusId());
        }

        if(newOne.getCoveragePolicyStatusId() != null){
            oldOne.setCoveragePolicyStatusId(newOne.getCoveragePolicyStatusId());
        }

        if(newOne.getStartDate() != null){
            oldOne.setStartDate(newOne.getStartDate());
        }

        if(newOne.getBillDate() != null){
            oldOne.setBillDate(newOne.getBillDate());
        }

        if(newOne.getPaidDate() != null){
            oldOne.setPaidDate(newOne.getPaidDate());
        }

        if(newOne.getCurrency() != null){
            oldOne.setCurrency(newOne.getCurrency());
        }

        if(newOne.getProduct() != null){
            oldOne.setProduct(newOne.getProduct());
        }

        repository.save(oldOne);
        return errorService.getErrorById("ER003");
    }


    public String softDeletePolicyHeader(Long id){

        PolicyHeader oldOne = repository.getById(id);
        oldOne.setIsActive(-1);
        repository.save(oldOne);
        return errorService.getErrorById("ER003");
    }

    public String hardDeletePolicyHeader(Long id){

        repository.deleteById(id);
        return errorService.getErrorById("ER003");
    }

    public List<PolicyHeader> search(String key){
        return repository.globalSearch(key);
    }

}
