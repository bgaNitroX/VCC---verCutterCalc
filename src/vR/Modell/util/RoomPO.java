package vR.Modell.util;

import org.sdmlib.models.pattern.PatternObject;
import vR.Modell.Room;
import org.sdmlib.models.pattern.AttributeConstraint;
import vR.Modell.util.PaneelePO;
import vR.Modell.Paneele;
import vR.Modell.util.RoomPO;
import vR.Modell.util.PaneeleSet;
import vR.Modell.util.PaneeleFeatherPO;
import vR.Modell.PaneeleFeather;
import vR.Modell.util.PaneeleFeatherSet;
import vR.Modell.util.PaneeleGroovePO;
import vR.Modell.PaneeleGroove;
import vR.Modell.util.PaneeleGrooveSet;

public class RoomPO extends PatternObject<RoomPO, Room>
{

    public RoomSet allMatches()
   {
      this.setDoAllMatches(true);
      
      RoomSet matches = new RoomSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((Room) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public RoomPO(){
      newInstance(vR.Modell.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public RoomPO(Room... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(vR.Modell.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public RoomPO hasLength(double value)
   {
      new AttributeConstraint()
      .withAttrName(Room.PROPERTY_LENGTH)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public RoomPO hasLength(double lower, double upper)
   {
      new AttributeConstraint()
      .withAttrName(Room.PROPERTY_LENGTH)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public RoomPO createLength(double value)
   {
      this.startCreate().hasLength(value).endCreate();
      return this;
   }
   
   public double getLength()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Room) getCurrentMatch()).getLength();
      }
      return 0;
   }
   
   public RoomPO withLength(double value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Room) getCurrentMatch()).setLength(value);
      }
      return this;
   }
   
   public RoomPO hasWide(double value)
   {
      new AttributeConstraint()
      .withAttrName(Room.PROPERTY_WIDE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public RoomPO hasWide(double lower, double upper)
   {
      new AttributeConstraint()
      .withAttrName(Room.PROPERTY_WIDE)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public RoomPO createWide(double value)
   {
      this.startCreate().hasWide(value).endCreate();
      return this;
   }
   
   public double getWide()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Room) getCurrentMatch()).getWide();
      }
      return 0;
   }
   
   public RoomPO withWide(double value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Room) getCurrentMatch()).setWide(value);
      }
      return this;
   }
   
   public PaneelePO hasPaneeles()
   {
      PaneelePO result = new PaneelePO(new Paneele[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Room.PROPERTY_PANEELES, result);
      
      return result;
   }

   public PaneelePO createPaneeles()
   {
      return this.startCreate().hasPaneeles().endCreate();
   }

   public RoomPO hasPaneeles(PaneelePO tgt)
   {
      return hasLinkConstraint(tgt, Room.PROPERTY_PANEELES);
   }

   public RoomPO createPaneeles(PaneelePO tgt)
   {
      return this.startCreate().hasPaneeles(tgt).endCreate();
   }

   public PaneeleSet getPaneeles()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Room) this.getCurrentMatch()).getPaneeles();
      }
      return null;
   }

   public PaneeleFeatherPO hasPaneeleFeathers()
   {
      PaneeleFeatherPO result = new PaneeleFeatherPO(new PaneeleFeather[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Room.PROPERTY_PANEELEFEATHERS, result);
      
      return result;
   }

   public PaneeleFeatherPO createPaneeleFeathers()
   {
      return this.startCreate().hasPaneeleFeathers().endCreate();
   }

   public RoomPO hasPaneeleFeathers(PaneeleFeatherPO tgt)
   {
      return hasLinkConstraint(tgt, Room.PROPERTY_PANEELEFEATHERS);
   }

   public RoomPO createPaneeleFeathers(PaneeleFeatherPO tgt)
   {
      return this.startCreate().hasPaneeleFeathers(tgt).endCreate();
   }

   public PaneeleFeatherSet getPaneeleFeathers()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Room) this.getCurrentMatch()).getPaneeleFeathers();
      }
      return null;
   }

   public PaneeleGroovePO hasPaneeleGrooves()
   {
      PaneeleGroovePO result = new PaneeleGroovePO(new PaneeleGroove[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Room.PROPERTY_PANEELEGROOVES, result);
      
      return result;
   }

   public PaneeleGroovePO createPaneeleGrooves()
   {
      return this.startCreate().hasPaneeleGrooves().endCreate();
   }

   public RoomPO hasPaneeleGrooves(PaneeleGroovePO tgt)
   {
      return hasLinkConstraint(tgt, Room.PROPERTY_PANEELEGROOVES);
   }

   public RoomPO createPaneeleGrooves(PaneeleGroovePO tgt)
   {
      return this.startCreate().hasPaneeleGrooves(tgt).endCreate();
   }

   public PaneeleGrooveSet getPaneeleGrooves()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Room) this.getCurrentMatch()).getPaneeleGrooves();
      }
      return null;
   }

}
