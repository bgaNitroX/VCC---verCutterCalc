package vR.Modell.util;

import org.sdmlib.models.pattern.PatternObject;
import vR.Modell.PaneeleGroove;
import org.sdmlib.models.pattern.AttributeConstraint;
import vR.Modell.util.RoomPO;
import vR.Modell.Room;
import vR.Modell.util.PaneeleGroovePO;

public class PaneeleGroovePO extends PatternObject<PaneeleGroovePO, PaneeleGroove>
{

    public PaneeleGrooveSet allMatches()
   {
      this.setDoAllMatches(true);
      
      PaneeleGrooveSet matches = new PaneeleGrooveSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((PaneeleGroove) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public PaneeleGroovePO(){
      newInstance(vR.Modell.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public PaneeleGroovePO(PaneeleGroove... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(vR.Modell.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public PaneeleGroovePO hasLength(double value)
   {
      new AttributeConstraint()
      .withAttrName(PaneeleGroove.PROPERTY_LENGTH)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public PaneeleGroovePO hasLength(double lower, double upper)
   {
      new AttributeConstraint()
      .withAttrName(PaneeleGroove.PROPERTY_LENGTH)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public PaneeleGroovePO createLength(double value)
   {
      this.startCreate().hasLength(value).endCreate();
      return this;
   }
   
   public double getLength()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((PaneeleGroove) getCurrentMatch()).getLength();
      }
      return 0;
   }
   
   public PaneeleGroovePO withLength(double value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((PaneeleGroove) getCurrentMatch()).setLength(value);
      }
      return this;
   }
   
   public PaneeleGroovePO hasWide(double value)
   {
      new AttributeConstraint()
      .withAttrName(PaneeleGroove.PROPERTY_WIDE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public PaneeleGroovePO hasWide(double lower, double upper)
   {
      new AttributeConstraint()
      .withAttrName(PaneeleGroove.PROPERTY_WIDE)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public PaneeleGroovePO createWide(double value)
   {
      this.startCreate().hasWide(value).endCreate();
      return this;
   }
   
   public double getWide()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((PaneeleGroove) getCurrentMatch()).getWide();
      }
      return 0;
   }
   
   public PaneeleGroovePO withWide(double value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((PaneeleGroove) getCurrentMatch()).setWide(value);
      }
      return this;
   }
   
   public RoomPO hasRoom()
   {
      RoomPO result = new RoomPO(new Room[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(PaneeleGroove.PROPERTY_ROOM, result);
      
      return result;
   }

   public RoomPO createRoom()
   {
      return this.startCreate().hasRoom().endCreate();
   }

   public PaneeleGroovePO hasRoom(RoomPO tgt)
   {
      return hasLinkConstraint(tgt, PaneeleGroove.PROPERTY_ROOM);
   }

   public PaneeleGroovePO createRoom(RoomPO tgt)
   {
      return this.startCreate().hasRoom(tgt).endCreate();
   }

   public Room getRoom()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((PaneeleGroove) this.getCurrentMatch()).getRoom();
      }
      return null;
   }

}
