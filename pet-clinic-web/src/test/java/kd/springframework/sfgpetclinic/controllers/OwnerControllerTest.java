package kd.springframework.sfgpetclinic.controllers;

import kd.springframework.sfgpetclinic.model.Owner;
import kd.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnerController controller;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void ownersList() throws Exception{
        when(ownerService.findAll()).thenReturn(owners);
    //uncoment until import get from mvc servlet.setup.get
        /*mockMvc.perform(get("/owners")).andExpect(status().is(200))
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners",hasSize(2)));
         */
    }


    @Test
    void ownersListByIndex() throws Exception{
        when(ownerService.findAll()).thenReturn(owners);
        //comented until do not import get from mvc servlet.setup.get
        /*mockMvc.perform(get("/owners/index")).andExpect(status().is(200))
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners",hasSize(2)));
         */
    }


    @Test
    void findOwners() throws Exception{
     //commented until we do not import mock setup get
       /* mockMvc.perform(get("/owners/find"))
                .andExpect(view().name("notimplemented"));*/
        //verifyNoInteractions(ownerService);
    }
}