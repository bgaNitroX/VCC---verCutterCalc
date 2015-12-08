package vR.test;

import static org.junit.Assert.*;

import org.junit.Test;

import de.uniks.networkparser.gui.javafx.test.model.util.doubleList;
import vR.Modell.Room;
import vR.logik.vrLogikController;

public class testAll
{

	@Test
	public void test()
	{
		
		Room room = new Room().withLength(60).withWide(480);
		double paneeleLength = 260;
		double paneeleWide = 30;
		
		vrLogikController logikController = new vrLogikController(room, paneeleLength, paneeleWide);
		
		logikController.calulateBlend();
		
		double blend =0;
		for (double d : room.getBlendPaneelsFeathers().getLength())
		{
			blend = blend + d;
		}
		for (double d : room.getBlendPaneelsGroove().getLength())
		{
			blend = blend + d;
		}
		System.out.println("Vershcnitt: " + blend);
		assertTrue(blend == 600);
	}

}
