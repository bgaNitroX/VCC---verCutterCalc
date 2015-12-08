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
import vR.Modell.PaneeleGroove;
import vR.Modell.Room;

public class PaneeleGrooveCreator extends EntityFactory
{
   private final String[] properties = new String[]
   {
      PaneeleGroove.PROPERTY_LENGTH,
      PaneeleGroove.PROPERTY_WIDE,
      PaneeleGroove.PROPERTY_ROOM,
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new PaneeleGroove();
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

      if (PaneeleGroove.PROPERTY_LENGTH.equalsIgnoreCase(attribute))
      {
         return ((PaneeleGroove) target).getLength();
      }

      if (PaneeleGroove.PROPERTY_WIDE.equalsIgnoreCase(attribute))
      {
         return ((PaneeleGroove) target).getWide();
      }

      if (PaneeleGroove.PROPERTY_ROOM.equalsIgnoreCase(attribute))
      {
         return ((PaneeleGroove) target).getRoom();
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

      if (PaneeleGroove.PROPERTY_LENGTH.equalsIgnoreCase(attrName))
      {
         ((PaneeleGroove) target).withLength(Double.parseDouble(value.toString()));
         return true;
      }

      if (PaneeleGroove.PROPERTY_WIDE.equalsIgnoreCase(attrName))
      {
         ((PaneeleGroove) target).withWide(Double.parseDouble(value.toString()));
         return true;
      }

      if (PaneeleGroove.PROPERTY_ROOM.equalsIgnoreCase(attrName))
      {
         ((PaneeleGroove) target).setRoom((Room) value);
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
      ((PaneeleGroove) entity).removeYou();
   }
}
