package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class SecSizesGrpComponent(noOfSecSizesField:Option[NoOfSecSizesField]=None,
                                ofSecSizesGroups: Option[List[OfSecSizesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noOfSecSizesField.map(_.value).getOrElse(0) != ofSecSizesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoOfSecSizesField.TagId,noOfSecSizesField.map(_.value).getOrElse(0), ofSecSizesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noOfSecSizesField.foreach(fmt(b,_))
    ofSecSizesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object SecSizesGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    OfSecSizesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoOfSecSizesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    OfSecSizesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    OfSecSizesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoOfSecSizesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = OfSecSizesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SecSizesGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(SecSizesGrpComponent(myFields.get(NoOfSecSizesField.TagId).flatMap(f=>NoOfSecSizesField.decode(f)),
        if (nextTagPosLookup.contains(NoOfSecSizesField.TagId)) OfSecSizesGroup.decode(flds, nextTagPosLookup(NoOfSecSizesField.TagId)) else None))
    } else None
  }

    
}
     