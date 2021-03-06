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

import org.sdmlib.models.modelsets.SDMSet;
import vR.Modell.PaneeleFeather;
import java.util.Collection;
import org.sdmlib.models.modelsets.doubleList;
import org.sdmlib.models.modelsets.ObjectSet;
import vR.Modell.util.RoomSet;
import vR.Modell.Room;

public class PaneeleFeatherSet extends SDMSet<PaneeleFeather>
{

   public static final PaneeleFeatherSet EMPTY_SET = new PaneeleFeatherSet().withReadOnly(true);


   public PaneeleFeatherPO hasPaneeleFeatherPO()
   {
      return new PaneeleFeatherPO(this.toArray(new PaneeleFeather[this.size()]));
   }


   public String getEntryType()
   {
      return "vR.Modell.PaneeleFeather";
   }


   @SuppressWarnings("unchecked")
   public PaneeleFeatherSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<PaneeleFeather>)value);
      }
      else if (value != null)
      {
         this.add((PaneeleFeather) value);
      }
      
      return this;
   }
   
   public PaneeleFeatherSet without(PaneeleFeather value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of PaneeleFeather objects and collect a list of the length attribute values. 
    * 
    * @return List of double objects reachable via length attribute
    */
   public doubleList getLength()
   {
      doubleList result = new doubleList();
      
      for (PaneeleFeather obj : this)
      {
         result.add(obj.getLength());
      }
      
      return result;
   }


   /**
    * Loop through the current set of PaneeleFeather objects and collect those PaneeleFeather objects where the length attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of PaneeleFeather objects that match the parameter
    */
   public PaneeleFeatherSet hasLength(double value)
   {
      PaneeleFeatherSet result = new PaneeleFeatherSet();
      
      for (PaneeleFeather obj : this)
      {
         if (value == obj.getLength())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PaneeleFeather objects and collect those PaneeleFeather objects where the length attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of PaneeleFeather objects that match the parameter
    */
   public PaneeleFeatherSet hasLength(double lower, double upper)
   {
      PaneeleFeatherSet result = new PaneeleFeatherSet();
      
      for (PaneeleFeather obj : this)
      {
         if (lower <= obj.getLength() && obj.getLength() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PaneeleFeather objects and assign value to the length attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of PaneeleFeather objects now with new attribute values.
    */
   public PaneeleFeatherSet withLength(double value)
   {
      for (PaneeleFeather obj : this)
      {
         obj.setLength(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of PaneeleFeather objects and collect a list of the wide attribute values. 
    * 
    * @return List of double objects reachable via wide attribute
    */
   public doubleList getWide()
   {
      doubleList result = new doubleList();
      
      for (PaneeleFeather obj : this)
      {
         result.add(obj.getWide());
      }
      
      return result;
   }


   /**
    * Loop through the current set of PaneeleFeather objects and collect those PaneeleFeather objects where the wide attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of PaneeleFeather objects that match the parameter
    */
   public PaneeleFeatherSet hasWide(double value)
   {
      PaneeleFeatherSet result = new PaneeleFeatherSet();
      
      for (PaneeleFeather obj : this)
      {
         if (value == obj.getWide())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PaneeleFeather objects and collect those PaneeleFeather objects where the wide attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of PaneeleFeather objects that match the parameter
    */
   public PaneeleFeatherSet hasWide(double lower, double upper)
   {
      PaneeleFeatherSet result = new PaneeleFeatherSet();
      
      for (PaneeleFeather obj : this)
      {
         if (lower <= obj.getWide() && obj.getWide() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PaneeleFeather objects and assign value to the wide attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of PaneeleFeather objects now with new attribute values.
    */
   public PaneeleFeatherSet withWide(double value)
   {
      for (PaneeleFeather obj : this)
      {
         obj.setWide(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of PaneeleFeather objects and collect a set of the Room objects reached via room. 
    * 
    * @return Set of Room objects reachable via room
    */
   public RoomSet getRoom()
   {
      RoomSet result = new RoomSet();
      
      for (PaneeleFeather obj : this)
      {
         result.add(obj.getRoom());
      }
      
      return result;
   }

   /**
    * Loop through the current set of PaneeleFeather objects and collect all contained objects with reference room pointing to the object passed as parameter. 
    * 
    * @param value The object required as room neighbor of the collected results. 
    * 
    * @return Set of Room objects referring to value via room
    */
   public PaneeleFeatherSet hasRoom(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection<?>) value);
      }
      else
      {
         neighbors.add(value);
      }
      
      PaneeleFeatherSet answer = new PaneeleFeatherSet();
      
      for (PaneeleFeather obj : this)
      {
         if (neighbors.contains(obj.getRoom()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the PaneeleFeather object passed as parameter to the Room attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Room attributes.
    */
   public PaneeleFeatherSet withRoom(Room value)
   {
      for (PaneeleFeather obj : this)
      {
         obj.withRoom(value);
      }
      
      return this;
   }

}
