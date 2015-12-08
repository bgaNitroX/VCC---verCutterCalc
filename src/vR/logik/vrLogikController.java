package vR.logik;

import vR.Modell.Paneele;
import vR.Modell.PaneeleFeather;
import vR.Modell.PaneeleGroove;
import vR.Modell.Room;
import vR.Modell.util.PaneeleFeatherSet;
import vR.Modell.util.PaneeleGrooveSet;

public class vrLogikController
{
	private Room room;
	private double paneeleLength;
	private double paneeleWide;
	private double roomLength;
	private double roomWide;

	public vrLogikController(Room room, double paneeleLength, double paneeleWide)
	{
		this.room = room;
		this.paneeleLength = paneeleLength;
		this.paneeleWide = paneeleWide;
		this.roomLength = room.getLength();
		this.roomWide = room.getWide();
	}

	public void setRoom(Room room)
	{
		this.room = room;
	}

	public Room getRoom()
	{
		return room;
	}

	public void calulateBlend()
	{

		if (roomLength > 0)
		{
			int i = (int) (roomWide / paneeleLength);
			System.out.println(i);
			for (; i > 0; i--)
			{
				room.withPaneeles(new Paneele().withLength(paneeleLength).withWide(roomWide));
			}

			double feather = (roomWide % paneeleLength) / 2;
			double groove = (roomWide % paneeleLength) / 2;

			// gucken ob alte bretter passen
			if (room.getBlendPaneelsFeathers().hasLength(feather, paneeleLength).size() >=1)
			{
				System.out.println("help1");
				PaneeleFeatherSet temp = room.getBlendPaneelsFeathers().hasLength(feather, paneeleLength);
				
				room.withPaneeleFeathers(temp.first());
				room.removeBlendPaneelsFeather(temp.first());

			}
			// muss uasgefürt werden wenn neue bretter gebraucht wurden
			else if (room.getBlendPaneelsFeathers().hasLength(feather, paneeleLength).size() <=0)
			{
				System.out.println("help2");
				room.withPaneeleFeathers(new PaneeleFeather().withLength(feather).withWide(paneeleWide));
				room.addBlendPaneelsGroove(new PaneeleGroove().withLength(paneeleLength - feather).withWide(paneeleWide));
				System.out.println(room.getBlendPaneelsGroove().size());
			}
			// gucken ob alte bretter passen
			if (room.getBlendPaneelsGroove().hasLength(groove, paneeleLength).size() >=1)
			{
				PaneeleGrooveSet temp = room.getPaneeleGrooves().hasLength(groove, paneeleLength);
				System.out.println("temp is: " + temp.toString());
				System.out.println("help3");
				
				room.removeBlendPaneelGrooves(temp.first());
			}
			// muss uasgefürt werden wenn neue bretter gebraucht wurden
			else if (room.getBlendPaneelsGroove().hasLength(groove, paneeleLength).size() <= 0)
			{
				System.out.println("help4");
				room.withPaneeleGrooves(new PaneeleGroove().withLength(groove).withWide(paneeleWide));
				room.addBlendPaneelsFeather(new PaneeleFeather().withLength(paneeleLength - groove).withWide(paneeleWide));
			}
			System.out.println(roomLength);
			roomLength = roomLength - paneeleWide;
			System.out.println(roomLength);
		}
		if (roomLength > 0)
		{
			//roomLength = roomLength - paneeleWide;
		}
		
		if (roomLength > 0)
		{
			System.out.println("uie");
			calulateBlend();
		}

		if(roomLength ==0)
		{
			return;
		}
	}
}
