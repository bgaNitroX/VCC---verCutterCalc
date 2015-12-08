/*
   Copyright (c) 2015 XPREDATOR
   
   Permission is hereby granted, free of charge, to any person obtaining a copy of this software 
   and associated documentation files (the "Software"), to deal in the Software without restriction, 
   including without limitation the rights to use, copy, modify, merge, publish, distribute, 
   sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is 
   furnished to do so, subject to the following conditions: 
   
   The above copyright notice and this permission notice shall be included in all copies or 
   substantial portions of the Software. 
   
   The Software shall be used for Good, not Evil. 
   
   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING 
   BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
   NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
   DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package vR.Modell;

import org.sdmlib.serialization.PropertyChangeInterface;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import vR.Modell.util.PaneeleSet;
import vR.Modell.util.PaneeleFeatherSet;
import vR.Modell.util.PaneeleGrooveSet;

/**
 * 
 * @see <a href='../../../src/GenclassModel/GenerateModell.java'>GenerateModell.
 *      java</a>/n
 */
public class Room implements PropertyChangeInterface
{

	// ==========================================================================

	protected PropertyChangeSupport listeners = new PropertyChangeSupport(this);

	public PropertyChangeSupport getPropertyChangeSupport()
	{
		return listeners;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener)
	{
		getPropertyChangeSupport().addPropertyChangeListener(listener);
	}

	// ==========================================================================

	public void removeYou()
	{

		withoutPaneeles(this.getPaneeles().toArray(new Paneele[this.getPaneeles().size()]));
		withoutPaneeleFeathers(this.getPaneeleFeathers().toArray(new PaneeleFeather[this.getPaneeleFeathers().size()]));
		withoutPaneeleGrooves(this.getPaneeleGrooves().toArray(new PaneeleGroove[this.getPaneeleGrooves().size()]));
		getPropertyChangeSupport().firePropertyChange("REMOVE_YOU", this, null);
	}

	// ==========================================================================

	public static final String PROPERTY_LENGTH = "length";

	private double length;

	public double getLength()
	{
		return this.length;
	}

	public void setLength(double value)
	{
		if (this.length != value)
		{

			double oldValue = this.length;
			this.length = value;
			getPropertyChangeSupport().firePropertyChange(PROPERTY_LENGTH, oldValue, value);
		}
	}

	public Room withLength(double value)
	{
		setLength(value);
		return this;
	}

	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();

		result.append(" ").append(this.getLength());
		result.append(" ").append(this.getWide());
		return result.substring(1);
	}

	// ==========================================================================

	public static final String PROPERTY_WIDE = "wide";

	private double wide;

	public double getWide()
	{
		return this.wide;
	}

	public void setWide(double value)
	{
		if (this.wide != value)
		{

			double oldValue = this.wide;
			this.wide = value;
			getPropertyChangeSupport().firePropertyChange(PROPERTY_WIDE, oldValue, value);
		}
	}

	public Room withWide(double value)
	{
		setWide(value);
		return this;
	}

	/********************************************************************
	 * <pre>
	 *              one                       many
	 * Room ----------------------------------- Paneele
	 *              room                   paneeles
	 * </pre>
	 */

	public static final String PROPERTY_PANEELES = "paneeles";

	private PaneeleSet paneeles = null;

	public PaneeleSet getPaneeles()
	{
		if (this.paneeles == null)
		{
			return PaneeleSet.EMPTY_SET;
		}

		return this.paneeles;
	}

	public Room withPaneeles(Paneele... value)
	{
		if (value == null)
		{
			return this;
		}
		for (Paneele item : value)
		{
			if (item != null)
			{
				if (this.paneeles == null)
				{
					this.paneeles = new PaneeleSet();
				}

				boolean changed = this.paneeles.add(item);

				if (changed)
				{
					item.withRoom(this);
					getPropertyChangeSupport().firePropertyChange(PROPERTY_PANEELES, null, item);
				}
			}
		}
		return this;
	}

	public Room withoutPaneeles(Paneele... value)
	{
		for (Paneele item : value)
		{
			if ((this.paneeles != null) && (item != null))
			{
				if (this.paneeles.remove(item))
				{
					item.setRoom(null);
					getPropertyChangeSupport().firePropertyChange(PROPERTY_PANEELES, item, null);
				}
			}
		}
		return this;
	}

	public Paneele createPaneeles()
	{
		Paneele value = new Paneele();
		withPaneeles(value);
		return value;
	}

	/********************************************************************
	 * <pre>
	 *              one                       many
	 * Room ----------------------------------- PaneeleFeather
	 *              room                   paneeleFeathers
	 * </pre>
	 */

	public static final String PROPERTY_PANEELEFEATHERS = "paneeleFeathers";

	private PaneeleFeatherSet paneeleFeathers = null;

	public PaneeleFeatherSet getPaneeleFeathers()
	{
		if (this.paneeleFeathers == null)
		{
			return PaneeleFeatherSet.EMPTY_SET;
		}

		return this.paneeleFeathers;
	}

	public Room withPaneeleFeathers(PaneeleFeather... value)
	{
		if (value == null)
		{
			return this;
		}
		for (PaneeleFeather item : value)
		{
			if (item != null)
			{
				if (this.paneeleFeathers == null)
				{
					this.paneeleFeathers = new PaneeleFeatherSet();
				}

				boolean changed = this.paneeleFeathers.add(item);

				if (changed)
				{
					item.withRoom(this);
					getPropertyChangeSupport().firePropertyChange(PROPERTY_PANEELEFEATHERS, null, item);
				}
			}
		}
		return this;
	}

	public Room withoutPaneeleFeathers(PaneeleFeather... value)
	{
		for (PaneeleFeather item : value)
		{
			if ((this.paneeleFeathers != null) && (item != null))
			{
				if (this.paneeleFeathers.remove(item))
				{
					item.setRoom(null);
					getPropertyChangeSupport().firePropertyChange(PROPERTY_PANEELEFEATHERS, item, null);
				}
			}
		}
		return this;
	}

	public PaneeleFeather createPaneeleFeathers()
	{
		PaneeleFeather value = new PaneeleFeather();
		withPaneeleFeathers(value);
		return value;
	}

	/********************************************************************
	 * <pre>
	 *              one                       many
	 * Room ----------------------------------- PaneeleGroove
	 *              room                   paneeleGrooves
	 * </pre>
	 */

	public static final String PROPERTY_PANEELEGROOVES = "paneeleGrooves";

	private PaneeleGrooveSet paneeleGrooves = null;

	public PaneeleGrooveSet getPaneeleGrooves()
	{
		if (this.paneeleGrooves == null)
		{
			return PaneeleGrooveSet.EMPTY_SET;
		}

		return this.paneeleGrooves;
	}

	public Room withPaneeleGrooves(PaneeleGroove... value)
	{
		if (value == null)
		{
			return this;
		}
		for (PaneeleGroove item : value)
		{
			if (item != null)
			{
				if (this.paneeleGrooves == null)
				{
					this.paneeleGrooves = new PaneeleGrooveSet();
				}

				boolean changed = this.paneeleGrooves.add(item);

				if (changed)
				{
					item.withRoom(this);
					getPropertyChangeSupport().firePropertyChange(PROPERTY_PANEELEGROOVES, null, item);
				}
			}
		}
		return this;
	}

	public Room withoutPaneeleGrooves(PaneeleGroove... value)
	{
		for (PaneeleGroove item : value)
		{
			if ((this.paneeleGrooves != null) && (item != null))
			{
				if (this.paneeleGrooves.remove(item))
				{
					item.setRoom(null);
					getPropertyChangeSupport().firePropertyChange(PROPERTY_PANEELEGROOVES, item, null);
				}
			}
		}
		return this;
	}

	public PaneeleGroove createPaneeleGrooves()
	{
		PaneeleGroove value = new PaneeleGroove();
		withPaneeleGrooves(value);
		return value;
	}
	
	private static PaneeleFeatherSet blendPaneelsFeathers = new PaneeleFeatherSet();

	public PaneeleFeatherSet getBlendPaneelsFeathers()
	{
		return blendPaneelsFeathers;
	}

	public void setBlendPaneelsFeathers(PaneeleFeatherSet blendPaneelsFeathers)
	{
		this.blendPaneelsFeathers = blendPaneelsFeathers;
	}
	
	public void addBlendPaneelsFeather(PaneeleFeather blend)
	{
		if(!blendPaneelsFeathers.contains(blend))
		{
			blendPaneelsFeathers.add(blend);
		}
	}
	
	public void removeBlendPaneelsFeather(PaneeleFeather blend)
	{
		if(blendPaneelsFeathers.contains(blend))
		{
			blendPaneelsFeathers.remove(blend);
		}
	}
	
	private static PaneeleGrooveSet blendPaneelsGrooves = new PaneeleGrooveSet();

	public PaneeleFeatherSet getBlendPaneelsGroove()
	{
		return blendPaneelsFeathers;
	}

	public void setBlendPaneelGrooves(PaneeleGrooveSet blendPaneelsGroove)
	{
		this.blendPaneelsFeathers = blendPaneelsFeathers;
	}
	
	public void addBlendPaneelsGroove(PaneeleGroove blend)
	{
		//if(!blendPaneelsGrooves.contains(blend))
		{System.out.println("fu");
			blendPaneelsGrooves.add(blend);
		}
	}
	
	public void removeBlendPaneelGrooves(PaneeleGroove blend)
	{
		if(blendPaneelsFeathers.contains(blend))
		{
			blendPaneelsFeathers.remove(blend);
		}
	}
}
