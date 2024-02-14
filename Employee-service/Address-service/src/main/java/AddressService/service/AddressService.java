package AddressService.service;

import AddressService.dto.AddressDto;
import AddressService.entity.Address;
import AddressService.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ModelMapper modelMapper;

    public AddressService(AddressRepository addressRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }
    public AddressDto getAddressByEmployeeId(int employeeId){
        Address address = addressRepository.findAddressByEmployeeId(employeeId);
        return mapToDto(address);
    }
    AddressDto mapToDto(Address address){
        return modelMapper.map(address, AddressDto.class);
    }
    Address mapToEntity(AddressDto addressDto){
        return modelMapper.map(addressDto, Address.class);
    }
}
