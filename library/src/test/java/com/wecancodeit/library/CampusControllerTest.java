package com.wecancodeit.library;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.wecancodeit.library.CampusController.CampusController;
import com.wecancodeit.library.Models.Campus;
import com.wecancodeit.library.Repositories.CampusRepository;

public class CampusControllerTest {
    
    @InjectMocks
    private CampusController underTest;

    @Mock
    private CampusRepository campusRepository;

    @Mock
    private Campus campus1;

    @Mock
    private Campus campus2;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnAllCampuses(){
        Collection<Campus> allCampuses = Arrays.asList(campus1,campus2);
        when(campusRepository.findAll()).thenReturn(allCampuses);
        underTest.displayCampuses(model);
        verify(model).addAttribute("campuses", allCampuses);
    }

    //Compare equals strings at campus.java (the last 2 methods)
    @Test
    public void shouldAddNewCampus(){
        underTest.addCampus("Colombus");
        verify(campusRepository).save(new Campus("Colombus"));
    }

    @Test
    public void shouldAddCampusAndRedirect(){
        String results = underTest.addCampus("Colombus");
        assertEquals("redirect:campuses", results);
    }

}
