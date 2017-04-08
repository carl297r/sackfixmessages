package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class SettlInstructionsDataComponent(settlDeliveryTypeField:Option[SettlDeliveryTypeField]=None,
                                          standInstDbTypeField:Option[StandInstDbTypeField]=None,
                                          standInstDbNameField:Option[StandInstDbNameField]=None,
                                          standInstDbIDField:Option[StandInstDbIDField]=None,
                                          noDlvyInstField:Option[NoDlvyInstField]=None,
                                          dlvyInstGroups: Option[List[DlvyInstGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noDlvyInstField.map(_.value).getOrElse(0) != dlvyInstGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoDlvyInstField.TagId,noDlvyInstField.map(_.value).getOrElse(0), dlvyInstGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    settlDeliveryTypeField.foreach(fmt(b,_))
    standInstDbTypeField.foreach(fmt(b,_))
    standInstDbNameField.foreach(fmt(b,_))
    standInstDbIDField.foreach(fmt(b,_))
    noDlvyInstField.foreach(fmt(b,_))
    dlvyInstGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object SettlInstructionsDataComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    DlvyInstGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SettlDeliveryTypeField.TagId, StandInstDbTypeField.TagId, StandInstDbNameField.TagId, StandInstDbIDField.TagId, NoDlvyInstField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    DlvyInstGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    DlvyInstGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoDlvyInstField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SettlDeliveryTypeField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SettlInstructionsDataComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(SettlInstructionsDataComponent(myFields.get(SettlDeliveryTypeField.TagId).flatMap(f=>SettlDeliveryTypeField.decode(f)),
        myFields.get(StandInstDbTypeField.TagId).flatMap(f=>StandInstDbTypeField.decode(f)),
        myFields.get(StandInstDbNameField.TagId).flatMap(f=>StandInstDbNameField.decode(f)),
        myFields.get(StandInstDbIDField.TagId).flatMap(f=>StandInstDbIDField.decode(f)),
        myFields.get(NoDlvyInstField.TagId).flatMap(f=>NoDlvyInstField.decode(f)),
        if (nextTagPosLookup.contains(NoDlvyInstField.TagId)) DlvyInstGroup.decode(flds, nextTagPosLookup(NoDlvyInstField.TagId)) else None))
    } else None
  }

    
}
     