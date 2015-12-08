package vR.Modell.util;

import de.uniks.networkparser.json.JsonIdMap;
import org.sdmlib.serialization.SDMLibJsonIdMap;

class CreatorCreator{

   public static JsonIdMap createIdMap(String sessionID)
   {
      JsonIdMap jsonIdMap = (JsonIdMap) new SDMLibJsonIdMap().withSessionId(sessionID);
      jsonIdMap.withCreator(new PaneeleCreator());
      jsonIdMap.withCreator(new PaneelePOCreator());
      jsonIdMap.withCreator(new PaneeleGrooveCreator());
      jsonIdMap.withCreator(new PaneeleGroovePOCreator());
      jsonIdMap.withCreator(new PaneeleFeatherCreator());
      jsonIdMap.withCreator(new PaneeleFeatherPOCreator());
      jsonIdMap.withCreator(new RoomCreator());
      jsonIdMap.withCreator(new RoomPOCreator());
      return jsonIdMap;
   }
}
