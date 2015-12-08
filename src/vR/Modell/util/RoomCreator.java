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
   
package vR.Modell.util;

import org.sdmlib.serialization.EntityFactory;
import de.uniks.networkparser.json.JsonIdMap;
import vR.Modell.Room;
import vR.Modell.Paneele;
import vR.Modell.PaneeleFeather;
import vR.Modell.PaneeleGroove;

public class RoomCreator extends EntityFactory
{
   private final String[] properties = new String[]
   {
      Room.PROPERTY_LENGTH,
      Room.PROPERTY_WIDE,
      Room.PROPERTY_PANEELES,
      Room.PROPERTY_PANEELEFEATHERS,
      Room.PROPERTY_PANEELEGROOVES,
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new Room();
   }
   
   @Override
   public Object getValue(Object target, String attrName)
   {
      int pos = attrName.indexOf('.');
      String attribute = attrName;
      
      if (pos > 0)
      {
         attribute = attrName.substring(0, pos);
      }

      if (Room.PROPERTY_LENGTH.equalsIgnoreCase(attribute))
      {
         return ((Room) target).getLength();
      }

      if (Room.PROPERTY_WIDE.equalsIgnoreCase(attribute))
      {
         return ((Room) target).getWide();
      }

      if (Room.PROPERTY_PANEELES.equalsIgnoreCase(attribute))
      {
         return ((Room) target).getPaneeles();
      }

      if (Room.PROPERTY_PANEELEFEATHERS.equalsIgnoreCase(attribute))
      {
         return ((Room) target).getPaneeleFeathers();
      }

      if (Room.PROPERTY_PANEELEGROOVES.equalsIgnoreCase(attribute))
      {
         return ((Room) target).getPaneeleGrooves();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (JsonIdMap.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (Room.PROPERTY_LENGTH.equalsIgnoreCase(attrName))
      {
         ((Room) target).withLength(Double.parseDouble(value.toString()));
         return true;
      }

      if (Room.PROPERTY_WIDE.equalsIgnoreCase(attrName))
      {
         ((Room) target).withWide(Double.parseDouble(value.toString()));
         return true;
      }

      if (Room.PROPERTY_PANEELES.equalsIgnoreCase(attrName))
      {
         ((Room) target).withPaneeles((Paneele) value);
         return true;
      }
      
      if ((Room.PROPERTY_PANEELES + JsonIdMap.REMOVE).equalsIgnoreCase(attrName))
      {
         ((Room) target).withoutPaneeles((Paneele) value);
         return true;
      }

      if (Room.PROPERTY_PANEELEFEATHERS.equalsIgnoreCase(attrName))
      {
         ((Room) target).withPaneeleFeathers((PaneeleFeather) value);
         return true;
      }
      
      if ((Room.PROPERTY_PANEELEFEATHERS + JsonIdMap.REMOVE).equalsIgnoreCase(attrName))
      {
         ((Room) target).withoutPaneeleFeathers((PaneeleFeather) value);
         return true;
      }

      if (Room.PROPERTY_PANEELEGROOVES.equalsIgnoreCase(attrName))
      {
         ((Room) target).withPaneeleGrooves((PaneeleGroove) value);
         return true;
      }
      
      if ((Room.PROPERTY_PANEELEGROOVES + JsonIdMap.REMOVE).equalsIgnoreCase(attrName))
      {
         ((Room) target).withoutPaneeleGrooves((PaneeleGroove) value);
         return true;
      }
      
      return false;
   }
   public static JsonIdMap createIdMap(String sessionID)
   {
      return vR.Modell.util.CreatorCreator.createIdMap(sessionID);
   }
   
   //==========================================================================
   
   @Override
   public void removeObject(Object entity)
   {
      ((Room) entity).removeYou();
   }
}
