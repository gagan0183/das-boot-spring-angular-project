package com.boot;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.rep.ShipwreckRepository;

import junit.framework.Assert;

public class AppTest {
    @InjectMocks
	private ShipwreckController controller;
    
    @Mock
    private ShipwreckRepository repository;
    
    @Before
    public void init() {
    	MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void test() {
    	Shipwreck s = new Shipwreck();
    	s.setId(1L);
    	Mockito.when(repository.findOne(1L)).thenReturn(s);
    	
    	Shipwreck shipwreck = controller.get(1L);
    	Assert.assertEquals(1L, shipwreck.getId().longValue());
    }
}
