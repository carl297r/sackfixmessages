package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class CompIDReqGrpComponent(noCompIDsField:Option[NoCompIDsField]=None,
                                 compIDsGroups: Option[List[CompIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noCompIDsField.map(_.value).getOrElse(0) != compIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoCompIDsField.TagId,noCompIDsField.map(_.value).getOrElse(0), compIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noCompIDsField.foreach(fmt(b,_))
    compIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object CompIDReqGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    CompIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoCompIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    CompIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    CompIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoCompIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = CompIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[CompIDReqGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(CompIDReqGrpComponent(myFields.get(NoCompIDsField.TagId).flatMap(f=>NoCompIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoCompIDsField.TagId)) CompIDsGroup.decode(flds, nextTagPosLookup(NoCompIDsField.TagId)) else None))
    } else None
  }

    
}
     