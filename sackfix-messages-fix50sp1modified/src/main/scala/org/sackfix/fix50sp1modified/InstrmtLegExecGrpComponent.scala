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
case class InstrmtLegExecGrpComponent(noLegsField:Option[NoLegsField]=None,
                                      legsGroups: Option[List[LegsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noLegsField.map(_.value).getOrElse(0) != legsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoLegsField.TagId,noLegsField.map(_.value).getOrElse(0), legsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noLegsField.foreach(fmt(b,_))
    legsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object InstrmtLegExecGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    LegsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoLegsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    LegsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    LegsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoLegsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = LegsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[InstrmtLegExecGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(InstrmtLegExecGrpComponent(myFields.get(NoLegsField.TagId).flatMap(f=>NoLegsField.decode(f)),
        if (nextTagPosLookup.contains(NoLegsField.TagId)) LegsGroup.decode(flds, nextTagPosLookup(NoLegsField.TagId)) else None))
    } else None
  }

    
}
     