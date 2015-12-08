package vR.Modell.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.json.JsonIdMap;
import vR.Modell.PaneeleFeather;

public class PaneeleFeatherPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new PaneeleFeatherPO(new PaneeleFeather[]{});
      } else {
          return new PaneeleFeatherPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return vR.Modell.util.CreatorCreator.createIdMap(sessionID);
   }
}
