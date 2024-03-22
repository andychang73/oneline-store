package com.abstractionizer.Hello.World.controller;

import com.abstractionizer.Hello.World.business.CustomerBusiness;
import com.abstractionizer.Hello.World.model.dto.CreateCustomerDto;
import com.abstractionizer.Hello.World.model.dto.QueryCustomerDto;
import com.abstractionizer.Hello.World.model.dto.UpdateCustomerDto;
import com.abstractionizer.Hello.World.model.vo.PageVo;
import com.abstractionizer.Hello.World.response.SuccessResp;
import com.abstractionizer.Hello.World.storage.rmdb.entity.CustomerEntity;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    private final CustomerBusiness customerBusiness;

    public CustomerController(CustomerBusiness customerBusiness) {
        this.customerBusiness = customerBusiness;
    }

    @GetMapping
    public SuccessResp<PageVo<CustomerEntity>> getCustomers(@Valid QueryCustomerDto dto){
        return new SuccessResp<>(customerBusiness.getCustomers(dto));
    }

    @PostMapping
    public SuccessResp<Void> createCustomer(@RequestBody @Valid CreateCustomerDto dto){
        customerBusiness.createCustomer(dto);
        return new SuccessResp<>();
    }

    @PutMapping("/{customerId}")
    public SuccessResp<Void> updateCustomer(@PathVariable Long customerId, @RequestBody @Valid UpdateCustomerDto dto){
        customerBusiness.updateCustomer(customerId, dto);
        return new SuccessResp<>();
    }
}
