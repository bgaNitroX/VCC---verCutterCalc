package vR.Modell.util;

import org.sdmlib.models.pattern.PatternObject;
import vR.Modell.PaneeleFeather;
import org.sdmlib.models.pattern.AttributeConstraint;
import vR.Modell.util.RoomPO;
import vR.Modell.Room;
import vR.Modell.util.PaneeleFeatherPO;

public class PaneeleFeatherPO extends PatternObject<PaneeleFeatherPO, PaneeleFeather>
{

    public PaneeleFeatherSet allMatches()
   {
      this.setDoAllMatches(true);
      
      PaneeleFeatherSet matches = new PaneeleFeatherSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((PaneeleFeather) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public PaneeleFeatherPO(){
      newInstance(vR.Modell.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public PaneeleFeatherPO(PaneeleFeather... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(vR.Modell.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public PaneeleFeatherPO hasLength(double value)
   {
      new AttributeConstraint()
      .withAttrName(PaneeleFeather.PROPERTY_LENGTH)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public PaneeleFeatherPO hasLength(double lower, double upper)
   {
      new AttributeConstraint()
      .withAttrName(PaneeleFeather.PROPERTY_LENGTH)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public PaneeleFeatherPO createLength(double value)
   {
      this.startCreate().hasLength(value).endCreate();
      return this;
   }
   
   public double getLength()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((PaneeleFeather) getCurrentMatch()).getLength();
      }
      return 0;
   }
   
   public PaneeleFeatherPO withLength(double value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((PaneeleFeather) getCurrentMatch()).setLength(value);
      }
      return this;
   }
   
   public PaneeleFeatherPO hasWide(double value)
   {
      new AttributeConstraint()
      .withAttrName(PaneeleFeather.PROPERTY_WIDE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public PaneeleFeatherPO hasWide(double lower, double upper)
   {
      new AttributeConstraint()
      .withAttrName(PaneeleFeather.PROPERTY_WIDE)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public PaneeleFeatherPO createWide(double value)
   {
      this.startCreate().hasWide(value).endCreate();
      return this;
   }
   
   public double getWide()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((PaneeleFeather) getCurrentMatch()).getWide();
      }
      return 0;
   }
   
   public PaneeleFeatherPO withWide(double value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((PaneeleFeather) getCurrentMatch()).setWide(value);
      }
      return this;
   }
   
   public RoomPO hasRoom()
   {
      RoomPO result = new RoomPO(new Room[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(PaneeleFeather.PROPERTY_ROOM, result);
      
      return result;
   }

   public RoomPO createRoom()
   {
      return this.startCreate().hasRoom().endCreate();
   }

   public PaneeleFeatherPO hasRoom(RoomPO tgt)
   {
      return hasLinkConstraint(tgt, PaneeleFeather.PROPERTY_ROOM);
   }

   public PaneeleFeatherPO createRoom(RoomPO tgt)
   {
      return this.startCreate().hasRoom(tgt).endCreate();
   }

   public Room getRoom()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((PaneeleFeather) this.getCurrentMatch()).getRoom();
      }
      return null;
   }

}
