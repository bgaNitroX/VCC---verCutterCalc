package GenclassModel;

import static org.junit.Assert.*;

import org.junit.Test;
import org.sdmlib.models.classes.Card;
import org.sdmlib.models.classes.ClassModel;
import org.sdmlib.models.classes.Clazz;
import org.sdmlib.models.classes.DataType;

public class GenerateModell
{

	@Test
	public void test()
	{
		ClassModel cm = new ClassModel("vR.Modell");

		Clazz paneele = cm.createClazz("Paneele")
				.withAttribute("length", DataType.DOUBLE)
				.withAttribute("wide", DataType.DOUBLE);

		Clazz paneeleGroove = cm.createClazz("PaneeleGroove")
				.withAttribute("length", DataType.DOUBLE)
				.withAttribute("wide", DataType.DOUBLE);
		
		Clazz paneelefeather = cm.createClazz("PaneeleFeather")
				.withAttribute("length", DataType.DOUBLE)
				.withAttribute("wide", DataType.DOUBLE);
		
		Clazz room = cm.createClazz("Room")
				.withAttribute("length", DataType.DOUBLE)
				.withAttribute("wide", DataType.DOUBLE);
		
		room.withAssoc(paneele, "paneeles", Card.MANY, "room", Card.ONE);
		room.withAssoc(paneelefeather, "paneeleFeathers", Card.MANY, "room", Card.ONE);
		room.withAssoc(paneeleGroove, "paneeleGrooves", Card.MANY, "room", Card.ONE);
		
		cm.generate();
	}

}
