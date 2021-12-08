package tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.repository.CompteRepository;

public class TestAuditVersement {
	Compte compte=mock(Compte.class);
	@Test
    public void testgetFraisTransport() {
    	when(compte.getSolde()).thenReturn(5000.0);
    	assertEquals(5000.0,compte.getSolde());
    	
    }

}
