package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class RootPartyIDsGroup(rootPartyIDField:Option[RootPartyIDField]=None,
                             rootPartyIDSourceField:Option[RootPartyIDSourceField]=None,
                             rootPartyRoleField:Option[RootPartyRoleField]=None,
                             rootSubPartiesComponent:Option[RootSubPartiesComponent]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    rootPartyIDField.foreach(fmt(b,_))
    rootPartyIDSourceField.foreach(fmt(b,_))
    rootPartyRoleField.foreach(fmt(b,_))
    rootSubPartiesComponent.foreach(fmt(b,_))
    b
  }

}
     
object RootPartyIDsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    RootSubPartiesComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    RootPartyIDField.TagId, RootPartyIDSourceField.TagId, RootPartyRoleField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    RootSubPartiesComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    RootSubPartiesComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==RootPartyIDField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[RootPartyIDsGroup]=ArrayBuffer.empty[RootPartyIDsGroup]):Option[List[RootPartyIDsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[RootPartyIDsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[RootPartyIDsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(RootPartyIDsGroup(myFields.get(RootPartyIDField.TagId).flatMap(f=>RootPartyIDField.decode(f)),
          myFields.get(RootPartyIDSourceField.TagId).flatMap(f=>RootPartyIDSourceField.decode(f)),
          myFields.get(RootPartyRoleField.TagId).flatMap(f=>RootPartyRoleField.decode(f)),
          RootSubPartiesComponent.decode(flds, startPos))))
      } else (startPos, None)
    }
  }
    
}
     