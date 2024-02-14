package EmployeeService.Employee.service.service;

import EmployeeService.Employee.service.dto.AddressDto;
import EmployeeService.Employee.service.dto.EmployeeDto;
import EmployeeService.Employee.service.entity.Employee;
import EmployeeService.Employee.service.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RestTemplate restTemplate;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper, RestTemplate restTemplate) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.restTemplate = restTemplate;
    }
    public EmployeeDto getEmployeeById(int id){
        AddressDto addressDto = restTemplate.getForObject("http://localhost:8081/address-app/api/address/{id}", AddressDto.class, id);
        Employee employee = employeeRepository.findById(id).get();
        EmployeeDto employeeDto = mapToDto(employee);
        employeeDto.setAddressDto(addressDto);
        return employeeDto;
    }
    EmployeeDto mapToDto(Employee employee){
        return modelMapper.map(employee, EmployeeDto.class);
    }
    Employee mapToEntity(EmployeeDto employeeDto){
        return modelMapper.map(employeeDto, Employee.class);
    }
}
