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
import vR.Modell.Room;
import java.util.Collection;
import org.sdmlib.models.modelsets.doubleList;
import org.sdmlib.models.modelsets.ObjectSet;
import java.util.Collections;
import vR.Modell.util.PaneeleSet;
import vR.Modell.Paneele;
import vR.Modell.util.PaneeleFeatherSet;
import vR.Modell.PaneeleFeather;
import vR.Modell.util.PaneeleGrooveSet;
import vR.Modell.PaneeleGroove;

public class RoomSet extends SDMSet<Room>
{

   public static final RoomSet EMPTY_SET = new RoomSet().withReadOnly(true);


   public RoomPO hasRoomPO()
   {
      return new RoomPO(this.toArray(new Room[this.size()]));
   }


   public String getEntryType()
   {
      return "vR.Modell.Room";
   }


   @SuppressWarnings("unchecked")
   public RoomSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Room>)value);
      }
      else if (value != null)
      {
         this.add((Room) value);
      }
      
      return this;
   }
   
   public RoomSet without(Room value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of Room objects and collect a list of the length attribute values. 
    * 
    * @return List of double objects reachable via length attribute
    */
   public doubleList getLength()
   {
      doubleList result = new doubleList();
      
      for (Room obj : this)
      {
         result.add(obj.getLength());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Room objects and collect those Room objects where the length attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Room objects that match the parameter
    */
   public RoomSet hasLength(double value)
   {
      RoomSet result = new RoomSet();
      
      for (Room obj : this)
      {
         if (value == obj.getLength())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Room objects and collect those Room objects where the length attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Room objects that match the parameter
    */
   public RoomSet hasLength(double lower, double upper)
   {
      RoomSet result = new RoomSet();
      
      for (Room obj : this)
      {
         if (lower <= obj.getLength() && obj.getLength() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Room objects and assign value to the length attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Room objects now with new attribute values.
    */
   public RoomSet withLength(double value)
   {
      for (Room obj : this)
      {
         obj.setLength(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of Room objects and collect a list of the wide attribute values. 
    * 
    * @return List of double objects reachable via wide attribute
    */
   public doubleList getWide()
   {
      doubleList result = new doubleList();
      
      for (Room obj : this)
      {
         result.add(obj.getWide());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Room objects and collect those Room objects where the wide attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Room objects that match the parameter
    */
   public RoomSet hasWide(double value)
   {
      RoomSet result = new RoomSet();
      
      for (Room obj : this)
      {
         if (value == obj.getWide())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Room objects and collect those Room objects where the wide attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Room objects that match the parameter
    */
   public RoomSet hasWide(double lower, double upper)
   {
      RoomSet result = new RoomSet();
      
      for (Room obj : this)
      {
         if (lower <= obj.getWide() && obj.getWide() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Room objects and assign value to the wide attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Room objects now with new attribute values.
    */
   public RoomSet withWide(double value)
   {
      for (Room obj : this)
      {
         obj.setWide(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Room objects and collect a set of the Paneele objects reached via paneeles. 
    * 
    * @return Set of Paneele objects reachable via paneeles
    */
   public PaneeleSet getPaneeles()
   {
      PaneeleSet result = new PaneeleSet();
      
      for (Room obj : this)
      {
         result.addAll(obj.getPaneeles());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Room objects and collect all contained objects with reference paneeles pointing to the object passed as parameter. 
    * 
    * @param value The object required as paneeles neighbor of the collected results. 
    * 
    * @return Set of Paneele objects referring to value via paneeles
    */
   public RoomSet hasPaneeles(Object value)
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
      
      RoomSet answer = new RoomSet();
      
      for (Room obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getPaneeles()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Room object passed as parameter to the Paneeles attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Paneeles attributes.
    */
   public RoomSet withPaneeles(Paneele value)
   {
      for (Room obj : this)
      {
         obj.withPaneeles(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the Room object passed as parameter from the Paneeles attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public RoomSet withoutPaneeles(Paneele value)
   {
      for (Room obj : this)
      {
         obj.withoutPaneeles(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Room objects and collect a set of the PaneeleFeather objects reached via paneeleFeathers. 
    * 
    * @return Set of PaneeleFeather objects reachable via paneeleFeathers
    */
   public PaneeleFeatherSet getPaneeleFeathers()
   {
      PaneeleFeatherSet result = new PaneeleFeatherSet();
      
      for (Room obj : this)
      {
         result.addAll(obj.getPaneeleFeathers());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Room objects and collect all contained objects with reference paneeleFeathers pointing to the object passed as parameter. 
    * 
    * @param value The object required as paneeleFeathers neighbor of the collected results. 
    * 
    * @return Set of PaneeleFeather objects referring to value via paneeleFeathers
    */
   public RoomSet hasPaneeleFeathers(Object value)
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
      
      RoomSet answer = new RoomSet();
      
      for (Room obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getPaneeleFeathers()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Room object passed as parameter to the PaneeleFeathers attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their PaneeleFeathers attributes.
    */
   public RoomSet withPaneeleFeathers(PaneeleFeather value)
   {
      for (Room obj : this)
      {
         obj.withPaneeleFeathers(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the Room object passed as parameter from the PaneeleFeathers attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public RoomSet withoutPaneeleFeathers(PaneeleFeather value)
   {
      for (Room obj : this)
      {
         obj.withoutPaneeleFeathers(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Room objects and collect a set of the PaneeleGroove objects reached via paneeleGrooves. 
    * 
    * @return Set of PaneeleGroove objects reachable via paneeleGrooves
    */
   public PaneeleGrooveSet getPaneeleGrooves()
   {
      PaneeleGrooveSet result = new PaneeleGrooveSet();
      
      for (Room obj : this)
      {
         result.addAll(obj.getPaneeleGrooves());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Room objects and collect all contained objects with reference paneeleGrooves pointing to the object passed as parameter. 
    * 
    * @param value The object required as paneeleGrooves neighbor of the collected results. 
    * 
    * @return Set of PaneeleGroove objects referring to value via paneeleGrooves
    */
   public RoomSet hasPaneeleGrooves(Object value)
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
      
      RoomSet answer = new RoomSet();
      
      for (Room obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getPaneeleGrooves()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Room object passed as parameter to the PaneeleGrooves attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their PaneeleGrooves attributes.
    */
   public RoomSet withPaneeleGrooves(PaneeleGroove value)
   {
      for (Room obj : this)
      {
         obj.withPaneeleGrooves(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the Room object passed as parameter from the PaneeleGrooves attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public RoomSet withoutPaneeleGrooves(PaneeleGroove value)
   {
      for (Room obj : this)
      {
         obj.withoutPaneeleGrooves(value);
      }
      
      return this;
   }

}
