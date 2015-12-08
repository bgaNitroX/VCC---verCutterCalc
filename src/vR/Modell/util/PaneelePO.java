package vR.Modell.util;

import org.sdmlib.models.pattern.PatternObject;
import vR.Modell.Paneele;
import org.sdmlib.models.pattern.AttributeConstraint;
import vR.Modell.util.RoomPO;
import vR.Modell.Room;
import vR.Modell.util.PaneelePO;

public class PaneelePO extends PatternObject<PaneelePO, Paneele>
{

    public PaneeleSet allMatches()
   {
      this.setDoAllMatches(true);
      
      PaneeleSet matches = new PaneeleSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((Paneele) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public PaneelePO(){
      newInstance(vR.Modell.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public PaneelePO(Paneele... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(vR.Modell.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public PaneelePO hasLength(double value)
   {
      new AttributeConstraint()
      .withAttrName(Paneele.PROPERTY_LENGTH)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public PaneelePO hasLength(double lower, double upper)
   {
      new AttributeConstraint()
      .withAttrName(Paneele.PROPERTY_LENGTH)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public PaneelePO createLength(double value)
   {
      this.startCreate().hasLength(value).endCreate();
      return this;
   }
   
   public double getLength()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Paneele) getCurrentMatch()).getLength();
      }
      return 0;
   }
   
   public PaneelePO withLength(double value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Paneele) getCurrentMatch()).setLength(value);
      }
      return this;
   }
   
   public PaneelePO hasWide(double value)
   {
      new AttributeConstraint()
      .withAttrName(Paneele.PROPERTY_WIDE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public PaneelePO hasWide(double lower, double upper)
   {
      new AttributeConstraint()
      .withAttrName(Paneele.PROPERTY_WIDE)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public PaneelePO createWide(double value)
   {
      this.startCreate().hasWide(value).endCreate();
      return this;
   }
   
   public double getWide()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Paneele) getCurrentMatch()).getWide();
      }
      return 0;
   }
   
   public PaneelePO withWide(double value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Paneele) getCurrentMatch()).setWide(value);
      }
      return this;
   }
   
   public RoomPO hasRoom()
   {
      RoomPO result = new RoomPO(new Room[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Paneele.PROPERTY_ROOM, result);
      
      return result;
   }

   public RoomPO createRoom()
   {
      return this.startCreate().hasRoom().endCreate();
   }

   public PaneelePO hasRoom(RoomPO tgt)
   {
      return hasLinkConstraint(tgt, Paneele.PROPERTY_ROOM);
   }

   public PaneelePO createRoom(RoomPO tgt)
   {
      return this.startCreate().hasRoom(tgt).endCreate();
   }

   public Room getRoom()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Paneele) this.getCurrentMatch()).getRoom();
      }
      return null;
   }

}
