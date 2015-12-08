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
   /**
    * 
    * @see <a href='../../../src/GenclassModel/GenerateModell.java'>GenerateModell.java</a>/n */
   public  class Paneele implements PropertyChangeInterface
{

   
   //==========================================================================
   
   protected PropertyChangeSupport listeners = new PropertyChangeSupport(this);
   
   public PropertyChangeSupport getPropertyChangeSupport()
   {
      return listeners;
   }
   
   public void addPropertyChangeListener(PropertyChangeListener listener) 
   {
      getPropertyChangeSupport().addPropertyChangeListener(listener);
   }

   
   //==========================================================================
   
   
   public void removeYou()
   {
   
      setRoom(null);
      getPropertyChangeSupport().firePropertyChange("REMOVE_YOU", this, null);
   }

   
   //==========================================================================
   
   public static final String PROPERTY_LENGTH = "length";
   
   private double length;

   public double getLength()
   {
      return this.length;
   }
   
   public void setLength(double value)
   {
      if (this.length != value) {
      
         double oldValue = this.length;
         this.length = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_LENGTH, oldValue, value);
      }
   }
   
   public Paneele withLength(double value)
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


   
   //==========================================================================
   
   public static final String PROPERTY_WIDE = "wide";
   
   private double wide;

   public double getWide()
   {
      return this.wide;
   }
   
   public void setWide(double value)
   {
      if (this.wide != value) {
      
         double oldValue = this.wide;
         this.wide = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_WIDE, oldValue, value);
      }
   }
   
   public Paneele withWide(double value)
   {
      setWide(value);
      return this;
   } 

   
   /********************************************************************
    * <pre>
    *              many                       one
    * Paneele ----------------------------------- Room
    *              paneeles                   room
    * </pre>
    */
   
   public static final String PROPERTY_ROOM = "room";

   private Room room = null;

   public Room getRoom()
   {
      return this.room;
   }

   public boolean setRoom(Room value)
   {
      boolean changed = false;
      
      if (this.room != value)
      {
         Room oldValue = this.room;
         
         if (this.room != null)
         {
            this.room = null;
            oldValue.withoutPaneeles(this);
         }
         
         this.room = value;
         
         if (value != null)
         {
            value.withPaneeles(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_ROOM, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Paneele withRoom(Room value)
   {
      setRoom(value);
      return this;
   } 

   public Room createRoom()
   {
      Room value = new Room();
      withRoom(value);
      return value;
   } 
}
