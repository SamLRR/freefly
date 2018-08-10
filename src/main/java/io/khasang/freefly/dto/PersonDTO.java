package io.khasang.freefly.dto;

import io.khasang.freefly.entity.Address;
import io.khasang.freefly.entity.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDTO {
    private long id;

    private List<AddressDTO> addressDTOList = new ArrayList<>();

    public List<PersonDTO> getPersonDTOList(List<Person> personList) {
        List<PersonDTO> personDTOList = new ArrayList<>();
        for (Person person : personList) {
            List<AddressDTO> addressDTOList = new ArrayList<>();
            PersonDTO personDTO = new PersonDTO();
            personDTO.setId(person.getId());

            getAddressDTOFromPerson(person, addressDTOList);
            personDTO.setAddressDTOList(addressDTOList);
            personDTOList.add(personDTO);
        }

        return personDTOList;
    }

    public PersonDTO getPersonDTO(Person person) {
        List<AddressDTO> addressDTOList = new ArrayList<>();
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(personDTO.getId());

        getAddressDTOFromPerson(person, addressDTOList);
        personDTO.setAddressDTOList(addressDTOList);

        return personDTO;
    }

    private void getAddressDTOFromPerson(Person person, List<AddressDTO> addressDTOList) {
        for (Address address : person.getAddresses()) {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setId(address.getId());
            addressDTO.setStreet(address.getStreet());
            addressDTO.setNumber(address.getNumber());

            addressDTOList.add(addressDTO);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<AddressDTO> getAddressDTOList() {
        return addressDTOList;
    }

    public void setAddressDTOList(List<AddressDTO> addressDTOList) {
        this.addressDTOList = addressDTOList;
    }
}
