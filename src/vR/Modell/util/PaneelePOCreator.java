package vR.Modell.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.json.JsonIdMap;
import vR.Modell.Paneele;

public class PaneelePOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new PaneelePO(new Paneele[]{});
      } else {
          return new PaneelePO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return vR.Modell.util.CreatorCreator.createIdMap(sessionID);
   }
}
