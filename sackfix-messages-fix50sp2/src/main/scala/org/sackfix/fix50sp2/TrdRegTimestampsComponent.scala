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
case class TrdRegTimestampsComponent(noTrdRegTimestampsField:Option[NoTrdRegTimestampsField]=None,
                                     trdRegTimestampsGroups: Option[List[TrdRegTimestampsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noTrdRegTimestampsField.map(_.value).getOrElse(0) != trdRegTimestampsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoTrdRegTimestampsField.TagId,noTrdRegTimestampsField.map(_.value).getOrElse(0), trdRegTimestampsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noTrdRegTimestampsField.foreach(fmt(b,_))
    trdRegTimestampsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object TrdRegTimestampsComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    TrdRegTimestampsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoTrdRegTimestampsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    TrdRegTimestampsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    TrdRegTimestampsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoTrdRegTimestampsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = TrdRegTimestampsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[TrdRegTimestampsComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(TrdRegTimestampsComponent(myFields.get(NoTrdRegTimestampsField.TagId).flatMap(f=>NoTrdRegTimestampsField.decode(f)),
        if (nextTagPosLookup.contains(NoTrdRegTimestampsField.TagId)) TrdRegTimestampsGroup.decode(flds, nextTagPosLookup(NoTrdRegTimestampsField.TagId)) else None))
    } else None
  }

    
}
     