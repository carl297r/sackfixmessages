package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class StrikeRulesComponent(noStrikeRulesField:Option[NoStrikeRulesField]=None,
                                strikeRulesGroups: Option[List[StrikeRulesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noStrikeRulesField.map(_.value).getOrElse(0) != strikeRulesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoStrikeRulesField.TagId,noStrikeRulesField.map(_.value).getOrElse(0), strikeRulesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noStrikeRulesField.foreach(fmt(b,_))
    strikeRulesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object StrikeRulesComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    StrikeRulesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoStrikeRulesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    StrikeRulesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    StrikeRulesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoStrikeRulesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = StrikeRulesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[StrikeRulesComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(StrikeRulesComponent(myFields.get(NoStrikeRulesField.TagId).flatMap(f=>NoStrikeRulesField.decode(f)),
        if (nextTagPosLookup.contains(NoStrikeRulesField.TagId)) StrikeRulesGroup.decode(flds, nextTagPosLookup(NoStrikeRulesField.TagId)) else None))
    } else None
  }

    
}
     