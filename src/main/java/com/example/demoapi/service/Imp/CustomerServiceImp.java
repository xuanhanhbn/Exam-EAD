package com.example.demoapi.service.Imp;

import com.example.demoapi.common.SearchUtil;
import com.example.demoapi.dto.request.CustomerRequest;
import com.example.demoapi.entity.Customer;
import com.example.demoapi.repository.CustomerRepo;
import com.example.demoapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Page<Customer> getAll(CustomerRequest customerRequest, Pageable pageable) {

        if(customerRequest != null) {
            List<Specification<Customer>> specList = getAdvanceSearchSpecList(customerRequest);
            if (!specList.isEmpty()) {
                Specification<Customer> spec = specList.get(0);
                for (int i = 1; i < specList.size(); i++) {
                    spec = spec.and(specList.get(i));
                }
                return customerRepo.findAll(spec, pageable);
            }
            return customerRepo.findAll(pageable);

        }
        return new PageImpl<>(new ArrayList<>(), pageable, 0);
    }

    private List<Specification<Customer>> getAdvanceSearchSpecList(@Valid CustomerRequest customerRequest) {
        List<Specification<Customer>> specList = new ArrayList<>();
        if (customerRequest.getName() != null && !customerRequest.getName().isEmpty()) {
            specList.add(SearchUtil.like("name", customerRequest.getName()));
        }
        if (customerRequest.getAge() != null && !customerRequest.getAge().isEmpty()) {
            specList.add(SearchUtil.like("age", customerRequest.getAge()));
        }
        if (customerRequest.getAddress() != null && !customerRequest.getAddress().isEmpty()) {
            specList.add(SearchUtil.like("address", customerRequest.getAddress()));
        }
        return specList;
    }
}
