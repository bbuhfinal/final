package com.yuukiiii.finalwork.service;

import java.util.List;
import com.yuukiiii.finalwork.model.Company;
import com.yuukiiii.finalwork.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Yuukiiii
 * on 2018/4/12 14:24
 */

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company addCompany(Company company){
        return companyRepository.save(company);
    }

    public void deleteCompany(Integer companyid){
        companyRepository.deleteById(companyid);
    }

    public List<Company> getAllCompany(){
        return companyRepository.findAll();
    }

    public Company getOneCompanyById(Integer companyid){
        return companyRepository.getOne(companyid);
    }

    public Company updateCompany(Company company){
        return companyRepository.save(company);
    }
}
