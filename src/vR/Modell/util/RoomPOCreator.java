package vR.Modell.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.json.JsonIdMap;
import vR.Modell.Room;

public class RoomPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new RoomPO(new Room[]{});
      } else {
          return new RoomPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return vR.Modell.util.CreatorCreator.createIdMap(sessionID);
   }
}
