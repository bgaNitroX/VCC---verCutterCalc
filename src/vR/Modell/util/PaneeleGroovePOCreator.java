package vR.Modell.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.json.JsonIdMap;
import vR.Modell.PaneeleGroove;

public class PaneeleGroovePOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new PaneeleGroovePO(new PaneeleGroove[]{});
      } else {
          return new PaneeleGroovePO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return vR.Modell.util.CreatorCreator.createIdMap(sessionID);
   }
}
