package AddressService.Controller;

import AddressService.dto.AddressDto;
import AddressService.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressDto> getAddressByEmployeeId(@PathVariable int employeeId) {
        AddressDto addressDto = addressService.getAddressByEmployeeId(employeeId);
        return new ResponseEntity<>(addressDto, HttpStatus.OK);
    }
}
