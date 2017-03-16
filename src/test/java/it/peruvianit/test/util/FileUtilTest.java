package it.peruvianit.test.util;

import static org.junit.Assert.*;

import org.junit.Test;

import it.peruvianit.commons.exception.PeruvianCommonsException;
import it.peruvianit.commons.util.lang.FileUtils;

public class FileUtilTest {

	@Test
	public void test() {
		try {
			FileUtils.checkDirecctory("c:\\temp","c:\\temp-error");
		} catch (PeruvianCommonsException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
}
