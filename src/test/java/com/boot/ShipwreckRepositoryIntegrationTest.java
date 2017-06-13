package com.boot;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boot.model.Shipwreck;
import com.boot.rep.ShipwreckRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class ShipwreckRepositoryIntegrationTest {
	@Autowired
	private ShipwreckRepository repository;
	
	@Test
	public void testAll() {
		List<Shipwreck>  wp = repository.findAll();
		Assert.assertThat(wp.size(), Matchers.greaterThanOrEqualTo(0));
	}
}
